# 享元模式 - Sunny软件公司多功能文档编辑器

## 项目背景

Sunny软件公司欲开发一个多功能文档编辑器，在文本文档中可以插入图片、动画、视频等多媒体资料。为了节约系统资源，相同的图片、动画和视频在同一个文档中只需保存一份，但是可以多次重复出现，而且它们每次出现时位置和大小均可不同。试使用享元模式设计该文档编辑器。

## 设计方案

使用享元模式运用共享技术有效地支持大量细粒度的对象，通过共享对象来减少内存占用。

## 类图结构

```
                ┌──────────────────────┐
                │ MultimediaElement   │ ◄──── 抽象享元（Flyweight）
                │   <<接口>>           │
                ├──────────────────────┤
                │ + display(state)    │
                │ + getType()         │
                │ + getId()           │
                │ + getFilePath()     │
                │ + getFileSize()     │
                │ + getInternal...()  │
                └──────────────────────┘
                         △
                         │
        ┌────────────────┴────────────────┐
        │                                  │
 ┌───────────────────┐          ┌──────────────────┐
 │ ImageElement      │          │AnimationElement  │
 │   (具体享元)      │          │   (具体享元)      │
 └───────────────────┘          └──────────────────┘
        │                                  │
        └────────────────┬─────────────────┘
                         │
                ┌───────────────────┐
                │  VideoElement     │
                │   (具体享元)      │
                └───────────────────┘

                ┌──────────────────────┐
                │ ElementState        │ ◄──── 外部状态（Extrinsic State）
                │   <<外部状态>>       │
                ├──────────────────────┤
                │ - x, y              │
                │ - width, height     │
                │ - opacity, rotation │
                │ - caption, border   │
                └──────────────────────┘

                ┌──────────────────────┐
                │ MultimediaFactory   │ ◄──── 享元工厂（Flyweight Factory）
                │   <<工厂>>           │
                ├──────────────────────┤
                │ - elementPool       │
                │ - totalCreated      │
                ├──────────────────────┤
                │ + getElement()      │
                │ + removeElement()   │
                │ + getStatistics()   │
                └──────────────────────┘
```

## 核心组件说明

### 1. 抽象享元（Flyweight）

**MultimediaElement.java** - 多媒体元素接口
- 定义了多媒体元素的公共操作
- `display(ElementState)` 方法接收外部状态作为参数

### 2. 具体享元（Concrete Flyweight）

实现抽象享元接口，包含内部状态。

#### 内部状态 vs 外部状态

| 内部状态（可共享） | 外部状态（不可共享） |
|-----------------|-----------------|
| 文件路径 | 位置（X, Y） |
| 文件大小 | 尺寸（宽, 高） |
| 格式类型 | 不透明度 |
| 分辨率/比特率 | 旋转角度 |
| 时长 | 标题文字 |
| 编码格式 | 边框样式 |
| 层级（Z-Index） | |

#### ImageElement - 图片元素
```java
ImageElement logo = factory.getElement("logo", "/images/logo.png", ElementType.IMAGE);
logo.display(new ElementState(100, 100, 200, 80)); // 在(100,100)位置显示200x80
logo.display(new ElementState(300, 200, 300, 120)); // 在(300,200)位置显示300x120
// 相同的图片对象，不同的显示状态
```

#### AnimationElement - 动画元素
```java
AnimationElement anim = factory.getElement("anim", "/anim/intro.gif", ElementType.ANIMATION);
anim.display(new ElementState(50, 50, 400, 300, 1, 1.0, 0, "开场动画", "solid"));
```

#### VideoElement - 视频元素
```java
VideoElement video = factory.getElement("video", "/video/demo.mp4", ElementType.VIDEO);
video.display(new ElementState(0, 0, 1920, 1080));
```

### 3. 外部状态（Extrinsic State）

**ElementState.java** - 元素状态类
- 存储元素在文档中的位置、大小等可变信息
- 不属于对象本身，由客户端在使用时提供
- 每次显示时可以不同

```java
ElementState state = new ElementState(100, 100, 200, 80); // x, y, width, height
state.setOpacity(0.8);  // 设置不透明度
state.setRotation(45);  // 设置旋转角度
state.setCaption("图片标题");  // 设置标题
```

### 4. 享元工厂（Flyweight Factory）

**MultimediaFactory.java** - 多媒体元素工厂
- 管理享元池（对象池）
- 提供获取共享对象的接口
- 如果请求的对象已存在，返回池中的对象；否则创建新对象并加入池

```java
MultimediaFactory factory = new MultimediaFactory();

// 第一次请求：创建新对象
MultimediaElement logo1 = factory.getElement("logo", "/images/logo.png", ElementType.IMAGE);

// 第二次请求：返回共享对象
MultimediaElement logo2 = factory.getElement("logo", "/images/logo.png", ElementType.IMAGE);

// logo1 == logo2  true（同一个对象）
```

## 使用示例

### 示例1：基本使用

```java
// 创建工厂
MultimediaFactory factory = new MultimediaFactory();

// 获取图片（第一次，创建新对象）
MultimediaElement logo = factory.getElement("logo", "/images/logo.png", ElementType.IMAGE);

// 使用不同的外部状态显示
logo.display(new ElementState(100, 100, 200, 80));   // 位置1
logo.display(new ElementState(300, 200, 300, 120)); // 位置2
logo.display(new ElementState(500, 100, 150, 60));  // 位置3

// 再次获取相同图片（返回共享对象）
MultimediaElement logo2 = factory.getElement("logo", "/images/logo.png", ElementType.IMAGE);
// logo == logo2  true，内存中只有一份
```

### 示例2：多页文档场景

```java
// 10页文档，每页都有相同的logo和水印
for (int page = 1; page <= 10; page++) {
    MultimediaElement logo = factory.getElement("logo", "/images/logo.png", ElementType.IMAGE);
    MultimediaElement watermark = factory.getElement("watermark", "/images/watermark.png", ElementType.IMAGE);

    // 每页显示在不同的位置
    logo.display(new ElementState(50, 50, 150, 60));
    watermark.display(new ElementState(200, 800, 400, 200, 0, 0.3, 0, "", "none"));
}

// 只创建了2个对象，而不是20个！
```

### 示例3：获取统计信息

```java
System.out.println(factory.getStatistics());
// 输出：
// 享元池统计:
// - 池中对象数: 5
// - 总请求数: 25
// - 实际创建数: 5
// - 节省对象数: 20
// - 节省率: 80.0%
```

## 享元模式的优势

### 1. 减少内存占用
- 相同对象只创建一次
- 多次引用共享同一对象
- 大幅降低内存消耗

### 2. 提高性能
- 减少对象创建和销毁的开销
- 降低垃圾回收压力
- 提高系统响应速度

### 3. 集中管理
- 所有共享对象由工厂统一管理
- 便于监控和调试
- 支持动态添加/删除

### 4. 内部状态与外部状态分离
- 内部状态可共享
- 外部状态独立变化
- 提高了对象的灵活性

## 内存使用对比

### 场景：10页文档，每页有logo和水印

| 方式 | 对象数量 | 内存占用（每对象5MB） |
|------|---------|-------------------|
| 不使用享元模式 | 20个 | 100MB |
| 使用享元模式 | 2个 | 10MB |
| **节省** | **18个** | **90MB (90%)** |

### 更大规模场景

| 文档页数 | 每页元素数 | 不使用享元 | 使用享元 | 节省率 |
|---------|-----------|-----------|---------|--------|
| 10 | 2 | 20个 | 2个 | 90% |
| 100 | 5 | 500个 | 5个 | 99% |
| 1000 | 10 | 10000个 | 10个 | 99.9% |

## 适用场景

享元模式适用于以下情况：

1. **一个系统有大量相同或相似的对象**
   - 如：文档编辑器中的图片、视频

2. **对象的大部分状态可以外部化**
   - 内部状态少，外部状态多

3. **多次使用共享对象**
   - 同一资源在多处使用

4. **需要缓存对象**
   - 如：字符串常量池、数据库连接池

## 实际应用场景

1. **Java String常量池**
   ```java
   String s1 = "hello";
   String s2 = "hello";
   // s1 == s2  true，共享同一个String对象
   ```

2. **Integer缓存**
   ```java
   Integer i1 = Integer.valueOf(127);
   Integer i2 = Integer.valueOf(127);
   // i1 == i2  true（-128到127之间缓存）
   ```

3. **数据库连接池**
   ```java
   Connection conn = connectionPool.getConnection();
   // 使用完后归还到池中，而不是销毁
   ```

4. **游戏开发**
   - 相同的树木、石头、敌人等对象共享

5. **文字处理**
   - 相同的字体、颜色共享

## 设计原则

享元模式体现了以下设计原则：
- **单一职责原则**：工厂负责管理对象池，享元负责具体功能
- **开闭原则**：可以添加新的享元类型
- **里氏替换原则**：客户端可以一致地使用享元对象
- **迪米特法则**：客户端只与工厂交互，不直接管理享元

## 运行方式

```bash
# 编译
javac -cp src/main/java src/main/java/cn/lixx/designpatterns/flyweight/FlyweightClient.java

# 运行
java -cp src/main/java cn.lixx.designpatterns.flyweight.FlyweightClient
```

## 扩展示例

### 添加新的多媒体类型

```java
// 1. 在ElementType枚举中添加新类型
public enum ElementType {
    IMAGE("图片"),
    ANIMATION("动画"),
    VIDEO("视频"),
    AUDIO("音频");  // 新增
    ...
}

// 2. 创建新的具体享元类
public class AudioElement extends AbstractMultimediaElement {
    public AudioElement(String id, String filePath) {
        super(id, filePath);
    }

    @Override
    public void display(ElementState externalState) {
        // 实现音频显示逻辑
    }

    @Override
    public String getType() {
        return "音频";
    }
}

// 3. 在工厂中添加创建逻辑
private MultimediaElement createElement(String id, String filePath, ElementType type) {
    switch (type) {
        case AUDIO:
            return new AudioElement(id, filePath);
        // ...
    }
}
```

## 总结

通过享元模式，Sunny软件公司的多功能文档编辑器实现了：
1. **大幅减少内存占用**：相同资源只保存一份
2. **灵活显示**：同一资源可在不同位置、不同大小多次显示
3. **集中管理**：所有多媒体元素由工厂统一管理
4. **提高性能**：减少对象创建和销毁的开销
5. **可扩展性**：方便添加新的多媒体类型

享元模式成功地解决了文档中多媒体资源重复使用时的内存浪费问题，在保持功能灵活性的同时，大大节约了系统资源。