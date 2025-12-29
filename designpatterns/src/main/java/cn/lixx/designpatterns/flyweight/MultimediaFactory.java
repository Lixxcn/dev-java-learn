package cn.lixx.designpatterns.flyweight;

import cn.lixx.designpatterns.flyweight.concreteflyweight.AnimationElement;
import cn.lixx.designpatterns.flyweight.concreteflyweight.ImageElement;
import cn.lixx.designpatterns.flyweight.concreteflyweight.VideoElement;

import java.util.HashMap;
import java.util.Map;

/**
 * 多媒体元素工厂类（享元工厂）
 * 负责创建和管理多媒体元素对象池
 * 当请求的对象已经存在时，直接返回；否则创建新对象并加入池中
 */
public class MultimediaFactory {
    // 享元池（使用Map存储，键为元素ID）
    private Map<String, MultimediaElement> elementPool;

    // 统计信息
    private int totalCreated = 0;   // 总创建对象数
    private int totalRequested = 0; // 总请求数

    public MultimediaFactory() {
        this.elementPool = new HashMap<>();
    }

    /**
     * 获取多媒体元素（核心方法）
     * 如果池中已存在相同ID的元素，直接返回；否则创建新元素并加入池中
     * @param id 元素ID
     * @param filePath 文件路径
     * @param type 元素类型
     * @return 多媒体元素
     */
    public MultimediaElement getElement(String id, String filePath, ElementType type) {
        totalRequested++;

        // 检查池中是否已存在
        MultimediaElement element = elementPool.get(id);

        if (element != null) {
            System.out.println("♻️  从享元池获取: " + type.getDescription() + " [" + id + "]");
            return element;
        }

        // 池中不存在，创建新对象
        System.out.println("🔨 创建新对象: " + type.getDescription() + " [" + id + "]");
        element = createElement(id, filePath, type);
        elementPool.put(id, element);
        totalCreated++;

        return element;
    }

    /**
     * 根据类型创建具体的多媒体元素
     * @param id 元素ID
     * @param filePath 文件路径
     * @param type 元素类型
     * @return 多媒体元素
     */
    private MultimediaElement createElement(String id, String filePath, ElementType type) {
        switch (type) {
            case IMAGE:
                return new ImageElement(id, filePath);
            case ANIMATION:
                return new AnimationElement(id, filePath);
            case VIDEO:
                return new VideoElement(id, filePath);
            default:
                throw new IllegalArgumentException("不支持的元素类型: " + type);
        }
    }

    /**
     * 移除指定的享元对象
     * @param id 元素ID
     * @return 是否移除成功
     */
    public boolean removeElement(String id) {
        MultimediaElement removed = elementPool.remove(id);
        if (removed != null) {
            System.out.println("🗑️  从享元池移除: " + removed.getType() + " [" + id + "]");
            return true;
        }
        return false;
    }

    /**
     * 清空享元池
     */
    public void clear() {
        int size = elementPool.size();
        elementPool.clear();
        System.out.println("🧹 已清空享元池，释放了 " + size + " 个对象");
    }

    /**
     * 获取享元池大小
     * @return 池中对象数量
     */
    public int getPoolSize() {
        return elementPool.size();
    }

    /**
     * 获取统计信息
     * @return 统计信息
     */
    public String getStatistics() {
        double savingRate = totalRequested > 0 ?
            (1 - (double) totalCreated / totalRequested) * 100 : 0;

        return String.format(
            "享元池统计:\n" +
            "- 池中对象数: %d\n" +
            "- 总请求数: %d\n" +
            "- 实际创建数: %d\n" +
            "- 节省对象数: %d\n" +
            "- 节省率: %.1f%%",
            getPoolSize(), totalRequested, totalCreated,
            totalRequested - totalCreated, savingRate
        );
    }

    /**
     * 显示池中所有对象
     */
    public void displayPoolContents() {
        System.out.println("\n========== 享元池内容 ==========");
        if (elementPool.isEmpty()) {
            System.out.println("（空）");
        } else {
            elementPool.forEach((id, element) -> {
                System.out.printf("- %s [%s]: %s%n",
                    element.getType(), id, element.getInternalStateInfo());
            });
        }
        System.out.println("==================================\n");
    }

    /**
     * 获取指定ID的元素
     * @param id 元素ID
     * @return 多媒体元素，如果不存在返回null
     */
    public MultimediaElement getElementById(String id) {
        return elementPool.get(id);
    }

    /**
     * 检查指定ID的元素是否在池中
     * @param id 元素ID
     * @return 是否存在
     */
    public boolean containsElement(String id) {
        return elementPool.containsKey(id);
    }

    /**
     * 元素类型枚举
     */
    public enum ElementType {
        IMAGE("图片"),
        ANIMATION("动画"),
        VIDEO("视频");

        private String description;

        ElementType(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
}