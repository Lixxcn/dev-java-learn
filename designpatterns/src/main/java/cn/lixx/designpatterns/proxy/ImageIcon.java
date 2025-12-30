package cn.lixx.designpatterns.proxy;

/**
 * 图标类
 * 用于快速显示图片的小图标，无需加载完整图片
 */
public class ImageIcon {

    private final String fileName;
    private final ImageType type;
    private final String iconRepresentation;

    public ImageIcon(String fileName, ImageType type) {
        this.fileName = fileName;
        this.type = type;
        this.iconRepresentation = generateIconRepresentation();
    }

    /**
     * 生成图标的文本表示
     * 在实际GUI应用中，这里会返回实际的图标图片
     */
    private String generateIconRepresentation() {
        StringBuilder sb = new StringBuilder();
        sb.append("┌─────────────────┐\n");
        sb.append("│").append(centerText(type.getIcon(), 17)).append("│\n");
        sb.append("│").append(centerText("图片", 17)).append("│\n");
        sb.append("└─────────────────┘\n");
        sb.append("  ").append(truncateFileName(fileName, 15));
        return sb.toString();
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

    private String truncateFileName(String fileName, int maxLength) {
        if (fileName.length() <= maxLength) {
            return fileName;
        }
        return fileName.substring(0, maxLength - 3) + "...";
    }

    /**
     * 显示图标
     */
    public void displayIcon() {
        System.out.println(iconRepresentation);
    }

    /**
     * 获取图标文本表示
     */
    public String getIconRepresentation() {
        return iconRepresentation;
    }

    public String getFileName() {
        return fileName;
    }

    public ImageType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "ImageIcon{" +
                "fileName='" + fileName + '\'' +
                ", type=" + type +
                '}';
    }
}
