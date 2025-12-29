package cn.lixx.designpatterns.flyweight.concreteflyweight;

import cn.lixx.designpatterns.flyweight.ElementState;
import cn.lixx.designpatterns.flyweight.MultimediaElement;

/**
 * 抽象多媒体元素类（抽象享元）
 * 实现了部分公共功能
 */
public abstract class AbstractMultimediaElement implements MultimediaElement {
    protected String id;            // 元素唯一标识
    protected String filePath;      // 文件路径（内部状态）
    protected long fileSize;        // 文件大小（内部状态）
    protected String fileName;      // 文件名（内部状态）
    protected String format;        // 格式（内部状态）

    public AbstractMultimediaElement(String id, String filePath) {
        this.id = id;
        this.filePath = filePath;
        this.fileName = extractFileName(filePath);
        this.format = extractFormat(filePath);
        this.fileSize = calculateFileSize();
    }

    @Override
    public void display(ElementState externalState) {
        System.out.printf("显示 %s: %s [%s]%n", getType(), fileName, externalState.getFullInfo());
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getFilePath() {
        return filePath;
    }

    @Override
    public long getFileSize() {
        return fileSize;
    }

    @Override
    public String getInternalStateInfo() {
        return String.format("ID: %s, 文件: %s, 大小: %s, 格式: %s",
            id, fileName, formatSize(), format);
    }

    /**
     * 提取文件名
     * @param filePath 文件路径
     * @return 文件名
     */
    protected String extractFileName(String filePath) {
        int lastSlash = Math.max(filePath.lastIndexOf('/'), filePath.lastIndexOf('\\'));
        return lastSlash >= 0 ? filePath.substring(lastSlash + 1) : filePath;
    }

    /**
     * 提取文件格式
     * @param filePath 文件路径
     * @return 格式
     */
    protected String extractFormat(String filePath) {
        int lastDot = filePath.lastIndexOf('.');
        return lastDot >= 0 ? filePath.substring(lastDot + 1).toUpperCase() : "";
    }

    /**
     * 计算文件大小（模拟）
     * @return 文件大小
     */
    protected long calculateFileSize() {
        // 模拟计算文件大小，实际应该从文件系统获取
        return (long)(Math.random() * 10 * 1024 * 1024); // 0-10MB
    }

    /**
     * 格式化文件大小
     * @return 格式化后的字符串
     */
    protected String formatSize() {
        if (fileSize < 1024) {
            return fileSize + " B";
        } else if (fileSize < 1024 * 1024) {
            return String.format("%.2f KB", fileSize / 1024.0);
        } else if (fileSize < 1024 * 1024 * 1024) {
            return String.format("%.2f MB", fileSize / (1024.0 * 1024));
        } else {
            return String.format("%.2f GB", fileSize / (1024.0 * 1024 * 1024));
        }
    }

    @Override
    public String toString() {
        return String.format("%s[%s]", getType(), id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AbstractMultimediaElement that = (AbstractMultimediaElement) obj;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}