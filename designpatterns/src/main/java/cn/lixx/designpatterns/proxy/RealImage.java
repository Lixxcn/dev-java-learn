package cn.lixx.designpatterns.proxy;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 真实主题：真实图片类
 * 负责从网络加载和显示完整图片
 * 支持多线程加载
 */
public class RealImage implements Image {

    private final String url;
    private final String fileName;
    private final ImageType type;
    private byte[] imageData;
    private long size;
    private boolean loaded;
    private final CountDownLatch loadLatch;

    public RealImage(String url, String fileName) {
        this.url = url;
        this.fileName = fileName;
        this.type = ImageType.fromFileName(fileName);
        this.loaded = false;
        this.loadLatch = new CountDownLatch(1);

        // 在实际应用中，这里会从网络下载图片
        // 这里模拟图片加载过程
        loadImageFromNetwork();
    }

    /**
     * 从网络加载图片（模拟）
     * 在实际应用中，这里会使用HttpURLConnection或类似工具下载图片
     */
    private void loadImageFromNetwork() {
        new Thread(() -> {
            try {
                // 模拟网络延迟和下载过程
                int downloadTime = (int) (Math.random() * 3000) + 1000; // 1-4秒
                System.out.printf("  [加载中] 正在从 '%s' 下载 %s...\n",
                        url, fileName);

                // 模拟分块下载
                int chunks = 10;
                for (int i = 1; i <= chunks; i++) {
                    Thread.sleep(downloadTime / chunks);
                    int progress = i * 100 / chunks;
                    System.out.printf("  [进度] %s: %d%%\n", fileName, progress);
                }

                // 模拟图片数据（实际应用中这里是真实图片数据）
                this.size = (long) (Math.random() * 5_000_000) + 100_000; // 100KB-5MB
                this.imageData = new byte[(int) size];
                this.loaded = true;

                System.out.printf("  [完成] %s 加载完成! 大小: %.2f KB\n",
                        fileName, size / 1024.0);

            } catch (InterruptedException e) {
                System.out.printf("  [错误] %s 加载被中断\n", fileName);
                Thread.currentThread().interrupt();
            } finally {
                loadLatch.countDown();
            }
        }, "ImageLoader-" + fileName).start();
    }

    /**
     * 显示完整图片
     */
    @Override
    public void display() {
        // 如果还未加载完成，等待加载完成
        if (!loaded) {
            System.out.printf("  [等待] %s 正在加载中，请稍候...\n", fileName);
            try {
                // 等待最多30秒
                if (!loadLatch.await(30, TimeUnit.SECONDS)) {
                    System.out.printf("  [超时] %s 加载超时\n", fileName);
                    return;
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        // 显示完整图片
        displayFullImage();
    }

    /**
     * 显示完整图片内容
     */
    private void displayFullImage() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n╔════════════════════════════════════════════════════════╗\n");
        sb.append("║                   【完整图片】                         ║\n");
        sb.append("╠════════════════════════════════════════════════════════╣\n");
        sb.append(String.format("║ 文件名: %-45s ║\n", truncate(fileName, 45)));
        sb.append(String.format("║ 类型:   %-10s 大小: %-25s ║\n",
                type.getExtension(), String.format("%.2f KB", size / 1024.0)));
        sb.append(String.format("║ URL:    %-45s ║\n", truncate(url, 45)));
        sb.append("╠════════════════════════════════════════════════════════╣\n");
        sb.append("║  ████████████████████████████████████████████████     ║\n");
        sb.append("║  ██                                                ██  ║\n");
        sb.append("║  ██              ").append(centerText(type.getIcon(), 30)).append("              ██  ║\n");
        sb.append("║  ██                                                ██  ║\n");
        sb.append("║  ██              ").append(centerText("图片内容", 30)).append("              ██  ║\n");
        sb.append("║  ██                                                ██  ║\n");
        sb.append("║  ████████████████████████████████████████████████     ║\n");
        sb.append("╚════════════════════════════════════════════════════════╝\n");

        System.out.println(sb.toString());
    }

    private String truncate(String text, int maxLength) {
        if (text.length() <= maxLength) {
            return text;
        }
        return text.substring(0, maxLength - 3) + "...";
    }

    private String centerText(String text, int width) {
        if (text.length() >= width) {
            return text.substring(0, width);
        }
        int padding = (width - text.length()) / 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < padding; i++) {
            sb.append(" ");
        }
        sb.append(text);
        while (sb.length() < width) {
            sb.append(" ");
        }
        return sb.toString();
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public long getSize() {
        return loaded ? size : -1;
    }

    @Override
    public boolean isLoaded() {
        return loaded;
    }

    @Override
    public ImageType getType() {
        return type;
    }

    /**
     * 获取图片数据
     */
    public byte[] getImageData() {
        return imageData;
    }
}
