package cn.lixx.designpatterns.flyweight;

/**
 * 元素状态类（外部状态）
 * 存储多媒体元素在文档中的位置、大小等可变化的信息
 * 这些信息不属于对象本身，而是由外部环境提供
 */
public class ElementState {
    private int x;              // X坐标
    private int y;              // Y坐标
    private int width;          // 宽度
    private int height;         // 高度
    private int zIndex;         // 层级（Z轴）
    private double opacity;     // 不透明度（0.0-1.0）
    private double rotation;    // 旋转角度（度）
    private String caption;     // 标题文字
    private String borderStyle; // 边框样式

    public ElementState(int x, int y, int width, int height) {
        this(x, y, width, height, 0, 1.0, 0.0, "", "none");
    }

    public ElementState(int x, int y, int width, int height, int zIndex,
                       double opacity, double rotation, String caption, String borderStyle) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.zIndex = zIndex;
        this.opacity = opacity;
        this.rotation = rotation;
        this.caption = caption;
        this.borderStyle = borderStyle;
    }

    /**
     * 获取位置信息
     * @return 位置字符串
     */
    public String getPositionInfo() {
        return String.format("位置: (%d, %d)", x, y);
    }

    /**
     * 获取尺寸信息
     * @return 尺寸字符串
     */
    public String getSizeInfo() {
        return String.format("尺寸: %d × %d", width, height);
    }

    /**
     * 获取完整状态信息
     * @return 完整状态信息
     */
    public String getFullInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(getPositionInfo()).append(", ");
        sb.append(getSizeInfo()).append(", ");
        sb.append("层级: ").append(zIndex).append(", ");
        sb.append("不透明度: ").append(String.format("%.1f", opacity)).append(", ");
        if (rotation != 0) {
            sb.append("旋转: ").append(String.format("%.1f°", rotation)).append(", ");
        }
        if (!caption.isEmpty()) {
            sb.append("标题: \"").append(caption).append("\", ");
        }
        if (!borderStyle.equals("none")) {
            sb.append("边框: ").append(borderStyle).append(", ");
        }
        // 移除最后的逗号和空格
        if (sb.charAt(sb.length() - 2) == ',') {
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }

    /**
     * 克隆状态对象
     * @return 克隆的状态对象
     */
    public ElementState clone() {
        return new ElementState(x, y, width, height, zIndex, opacity, rotation, caption, borderStyle);
    }

    /**
     * 创建一个新位置的状态副本
     * @param newX 新的X坐标
     * @param newY 新的Y坐标
     * @return 新的状态对象
     */
    public ElementState withPosition(int newX, int newY) {
        return new ElementState(newX, newY, width, height, zIndex, opacity, rotation, caption, borderStyle);
    }

    /**
     * 创建一个新尺寸的状态副本
     * @param newWidth 新宽度
     * @param newHeight 新高度
     * @return 新的状态对象
     */
    public ElementState withSize(int newWidth, int newHeight) {
        return new ElementState(x, y, newWidth, newHeight, zIndex, opacity, rotation, caption, borderStyle);
    }

    // Getter和Setter方法
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getzIndex() {
        return zIndex;
    }

    public void setzIndex(int zIndex) {
        this.zIndex = zIndex;
    }

    public double getOpacity() {
        return opacity;
    }

    public void setOpacity(double opacity) {
        this.opacity = opacity;
    }

    public double getRotation() {
        return rotation;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getBorderStyle() {
        return borderStyle;
    }

    public void setBorderStyle(String borderStyle) {
        this.borderStyle = borderStyle;
    }

    @Override
    public String toString() {
        return getFullInfo();
    }
}