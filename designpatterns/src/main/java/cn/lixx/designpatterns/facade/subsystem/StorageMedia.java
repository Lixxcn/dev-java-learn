package cn.lixx.designpatterns.facade.subsystem;

/**
 * 存储介质类（子系统）
 * 代表移动存储介质（MMC卡或SD卡）
 */
public class StorageMedia {
    private String name;
    private StorageType type;
    private long totalCapacity;
    private long usedCapacity;
    private boolean isConnected;
    private String mountPath;

    public StorageMedia(String name, StorageType type, long totalCapacity, String mountPath) {
        this.name = name;
        this.type = type;
        this.totalCapacity = totalCapacity;
        this.mountPath = mountPath;
        this.usedCapacity = 0;
        this.isConnected = false;
    }

    /**
     * 连接存储介质
     * @return 是否连接成功
     */
    public boolean connect() {
        System.out.println("正在连接存储介质: " + name);
        simulateDelay(300);
        this.isConnected = true;
        System.out.println("存储介质连接成功！类型: " + type.getDescription());
        return true;
    }

    /**
     * 断开存储介质
     */
    public void disconnect() {
        if (isConnected) {
            System.out.println("正在断开存储介质: " + name);
            simulateDelay(200);
            this.isConnected = false;
            System.out.println("存储介质已安全移除");
        }
    }

    /**
     * 获取可用空间
     * @return 可用空间（字节）
     */
    public long getAvailableSpace() {
        return totalCapacity - usedCapacity;
    }

    /**
     * 检查是否有足够空间
     * @param requiredSpace 需要的空间（字节）
     * @return 是否足够
     */
    public boolean hasEnoughSpace(long requiredSpace) {
        return getAvailableSpace() >= requiredSpace;
    }

    /**
     * 分配空间
     * @param size 大小（字节）
     * @return 是否成功
     */
    public boolean allocateSpace(long size) {
        if (!hasEnoughSpace(size)) {
            System.out.println("空间不足！需要: " + formatSize(size) +
                             ", 可用: " + formatSize(getAvailableSpace()));
            return false;
        }

        usedCapacity += size;
        System.out.println("已分配空间: " + formatSize(size) +
                         ", 剩余可用: " + formatSize(getAvailableSpace()));
        return true;
    }

    /**
     * 释放空间
     * @param size 大小（字节）
     */
    public void freeSpace(long size) {
        usedCapacity = Math.max(0, usedCapacity - size);
    }

    /**
     * 获取备份路径
     * @param fileType 文件类型
     * @return 备份路径
     */
    public String getBackupPath(String fileType) {
        return mountPath + "/Backup/" + fileType + "/";
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
     * 获取存储信息
     * @return 存储信息
     */
    public String getStorageInfo() {
        return String.format("存储介质: %s [%s]\n总容量: %s\n已使用: %s\n可用: %s",
            name,
            type.getDescription(),
            formatSize(totalCapacity),
            formatSize(usedCapacity),
            formatSize(getAvailableSpace())
        );
    }

    // Getter和Setter方法
    public String getName() {
        return name;
    }

    public StorageType getType() {
        return type;
    }

    public long getTotalCapacity() {
        return totalCapacity;
    }

    public long getUsedCapacity() {
        return usedCapacity;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public String getMountPath() {
        return mountPath;
    }

    /**
     * 存储介质类型枚举
     */
    public enum StorageType {
        MMC_CARD("MMC卡"),
        SD_CARD("SD卡"),
        USB_FLASH("U盘"),
        EXTERNAL_HDD("移动硬盘");

        private String description;

        StorageType(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
}