package cn.lixx.designpatterns.proxy;

/**
 * 虚拟代理：图片代理类
 * 延迟加载真实图片，先显示图标
 * 结合多线程机制，后台加载原图
 */
public class ImageProxy implements Image {

    private final String url;
    private final String fileName;
    private final ImageType type;
    private final ImageIcon icon;
    private RealImage realImage;
    private boolean backgroundLoadingStarted;

    public ImageProxy(String url, String fileName) {
        this.url = url;
        this.fileName = fileName;
        this.type = ImageType.fromFileName(fileName);
        this.icon = new ImageIcon(fileName, type);
        this.realImage = null;
        this.backgroundLoadingStarted = false;
    }

    /**
     * 显示图片
     * 首次调用时只显示图标，并启动后台加载
     * 再次调用时显示完整图片
     */
    @Override
    public void display() {
        if (realImage == null) {
            // 首次显示：显示图标并启动后台加载
            System.out.println("\n--- 显示图片图标 ---");
            icon.displayIcon();
            startBackgroundLoading();
        } else {
            // 已有真实图片：显示完整图片
            System.out.println("\n--- 显示完整图片 ---");
            realImage.display();
        }
    }

    /**
     * 用户点击图片时调用
     * 如果还未加载，会等待加载完成然后显示
     */
    public void onClick() {
        System.out.println("\n[用户点击] 点击了图片: " + fileName);

        if (realImage == null) {
            ensureRealImage();
        }

        if (realImage != null) {
            realImage.display();
        }
    }

    /**
     * 启动后台加载线程
     */
    private void startBackgroundLoading() {
        if (!backgroundLoadingStarted) {
            backgroundLoadingStarted = true;
            System.out.println("  [后台加载] 已启动后台线程，开始下载原图...");

            // 启动后台线程加载真实图片
            new Thread(() -> {
                ensureRealImage();
            }, "BackgroundLoader-" + fileName).start();
        }
    }

    /**
     * 确保真实图片已创建
     * 如果还未创建，则创建真实图片对象并等待加载完成
     */
    private synchronized void ensureRealImage() {
        if (realImage == null) {
            System.out.println("  [加载] 创建真实图片对象: " + fileName);
            realImage = new RealImage(url, fileName);
        }
    }

    /**
     * 预加载图片
     * 可以提前调用以在后台开始加载
     */
    public void preload() {
        if (!backgroundLoadingStarted) {
            System.out.println("  [预加载] 开始预加载: " + fileName);
            startBackgroundLoading();
        }
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
        return realImage != null ? realImage.getSize() : -1;
    }

    @Override
    public boolean isLoaded() {
        return realImage != null && realImage.isLoaded();
    }

    @Override
    public ImageType getType() {
        return type;
    }

    /**
     * 获取加载进度（0-100）
     */
    public int getLoadProgress() {
        if (realImage == null) {
            return 0;
        }
        if (realImage.isLoaded()) {
            return 100;
        }
        return 50; // 简化处理，实际中应该有精确的进度
    }

    @Override
    public String toString() {
        return "ImageProxy{" +
                "fileName='" + fileName + '\'' +
                ", type=" + type +
                ", loaded=" + isLoaded() +
                ", size=" + (isLoaded() ? String.format("%.2fKB", getSize() / 1024.0) : "未知") +
                '}';
    }
}
