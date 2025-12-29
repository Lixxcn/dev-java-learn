package cn.lixx.designpatterns.facade.subsystem;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 照片管理类（子系统）
 * 负责照片的读取和备份
 */
public class PhotoManager {
    private List<Photo> photos;

    public PhotoManager() {
        this.photos = new ArrayList<>();
        initSamplePhotos();
    }

    /**
     * 初始化示例照片数据
     */
    private void initSamplePhotos() {
        photos.add(new Photo("/DCIM/Camera/IMG_001.jpg", "风景照片", (long)(2.5 * 1024 * 1024), new Date()));
        photos.add(new Photo("/DCIM/Camera/IMG_002.jpg", "人物照片", (long)(3.1 * 1024 * 1024), new Date()));
        photos.add(new Photo("/DCIM/Camera/IMG_003.jpg", "美食照片", (long)(2.8 * 1024 * 1024), new Date()));
        photos.add(new Photo("/DCIM/Screenshots/Screenshot_001.png", "截图", 800 * 1024, new Date()));
        photos.add(new Photo("/DCIM/Screenshots/Screenshot_002.png", "截图", 750 * 1024, new Date()));
        photos.add(new Photo("/Downloads/Photo_001.jpg", "下载图片", (long)(1.5 * 1024 * 1024), new Date()));
    }

    /**
     * 读取照片
     * @return 照片列表
     */
    public List<Photo> readPhotos() {
        System.out.println("正在扫描手机照片...");
        simulateDelay(1000);
        System.out.println("成功扫描 " + photos.size() + " 张照片");
        return new ArrayList<>(photos);
    }

    /**
     * 备份照片到指定路径
     * @param photos 照片列表
     * @param path 备份路径
     * @return 是否成功
     */
    public boolean backupPhotos(List<Photo> photos, String path) {
        if (photos == null || photos.isEmpty()) {
            System.out.println("照片为空，无需备份");
            return false;
        }

        System.out.println("正在备份照片到: " + path);
        long totalSize = photos.stream().mapToLong(Photo::getSize).sum();
        System.out.println("总大小: " + formatSize(totalSize));

        simulateDelay(2000);
        System.out.println("照片备份完成！共备份 " + photos.size() + " 张照片");
        return true;
    }

    /**
     * 获取照片数量
     * @return 数量
     */
    public int getPhotoCount() {
        return photos.size();
    }

    /**
     * 获取照片总大小
     * @return 总大小（字节）
     */
    public long getTotalSize() {
        return photos.stream().mapToLong(Photo::getSize).sum();
    }

    /**
     * 格式化文件大小
     * @param size 字节
     * @return 格式化后的字符串
     */
    private String formatSize(long size) {
        if (size < 1024) {
            return size + " B";
        } else if (size < 1024 * 1024) {
            return String.format("%.2f KB", size / 1024.0);
        } else if (size < 1024 * 1024 * 1024) {
            return String.format("%.2f MB", size / (1024.0 * 1024));
        } else {
            return String.format("%.2f GB", size / (1024.0 * 1024 * 1024));
        }
    }

    /**
     * 模拟延迟
     * @param ms 毫秒
     */
    private void simulateDelay(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * 照片类
     */
    public static class Photo {
        private String path;
        private String description;
        private long size; // 字节
        private Date date;

        public Photo(String path, String description, long size, Date date) {
            this.path = path;
            this.description = description;
            this.size = size;
            this.date = date;
        }

        public String getPath() {
            return path;
        }

        public String getDescription() {
            return description;
        }

        public long getSize() {
            return size;
        }

        public Date getDate() {
            return date;
        }

        @Override
        public String toString() {
            return new File(path).getName() + " (" + description + ")";
        }
    }
}