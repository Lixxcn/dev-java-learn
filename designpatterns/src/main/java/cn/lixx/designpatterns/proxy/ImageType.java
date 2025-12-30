package cn.lixx.designpatterns.proxy;

/**
 * 图片类型枚举
 * 不同类型的图片使用不同的图标显示
 */
public enum ImageType {
    JPG("jpg", "[JPG图标]"),
    JPEG("jpeg", "[JPEG图标]"),
    PNG("png", "[PNG图标]"),
    GIF("gif", "[GIF图标]"),
    BMP("bmp", "[BMP图标]"),
    WEBP("webp", "[WEBP图标]"),
    SVG("svg", "[SVG图标]"),
    UNKNOWN("unknown", "[图片图标]");

    private final String extension;
    private final String icon;

    ImageType(String extension, String icon) {
        this.extension = extension;
        this.icon = icon;
    }

    public String getExtension() {
        return extension;
    }

    public String getIcon() {
        return icon;
    }

    /**
     * 根据文件扩展名获取图片类型
     */
    public static ImageType fromFileName(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            return UNKNOWN;
        }

        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex == -1 || lastDotIndex == fileName.length() - 1) {
            return UNKNOWN;
        }

        String extension = fileName.substring(lastDotIndex + 1).toLowerCase();

        for (ImageType type : values()) {
            if (type.extension.equals(extension)) {
                return type;
            }
        }

        return UNKNOWN;
    }
}
