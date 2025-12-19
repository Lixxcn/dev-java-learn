# 建造者模式 - 视频播放器界面设计

## 设计模式说明

建造者模式（Builder Pattern）是一种创建型设计模式，它将一个复杂对象的构建过程与其表示分离，使得同样的构建过程可以创建不同的表示。

## 问题背景

Sunny软件公司需要开发一个视频播放软件，该软件需要提供多种界面显示模式：
- 完整模式：显示所有组件
- 精简模式：只显示主窗口和控制条
- 记忆模式：显示主窗口、控制条、收藏列表等
- 网络模式：显示网络相关的组件

## 解决方案

### 类结构

```
产品类（Product）
└── VideoPlayer - 视频播放器（复杂对象）
    ├── Menu 菜单
    ├── PlayList 播放列表
    ├── MainWindow 主窗口
    ├── ControlBar 控制条
    ├── FavoriteList 收藏列表
    └── StatusBar 状态栏

抽象建造者（AbstractBuilder）
└── VideoPlayerBuilder - 定义构建步骤

具体建造者（ConcreteBuilder）
├── FullModeBuilder - 完整模式建造者
├── SimpleModeBuilder - 精简模式建造者
├── MemoryModeBuilder - 记忆模式建造者
└── NetworkModeBuilder - 网络模式建造者

指挥者（Director）
└── VideoPlayerDirector - 控制构建流程
```

### 核心角色

1. **产品（Product）**：VideoPlayer
   - 包含多个组件的复杂对象
   - 提供setter方法供Builder设置组件

2. **抽象建造者（Builder）**：VideoPlayerBuilder接口
   - 定义创建产品各个部分的抽象方法
   - 定义返回产品的接口

3. **具体建造者（ConcreteBuilder）**：
   - 实现Builder接口
   - 完成各个组件的具体创建
   - 管理最终产品的创建过程

4. **指挥者（Director）**：VideoPlayerDirector
   - 封装构建逻辑
   - 提供预定义的构建流程
   - 隔离客户与建造过程

### 实现示例

#### 1. 定义建造者接口

```java
public interface VideoPlayerBuilder {
    void buildMenu();
    void buildPlayList();
    void buildMainWindow();
    void buildControlBar();
    void buildFavoriteList();
    void buildStatusBar();
    VideoPlayer getVideoPlayer();
}
```

#### 2. 实现具体建造者

```java
public class SimpleModeBuilder implements VideoPlayerBuilder {
    private VideoPlayer videoPlayer = new VideoPlayer();

    public void buildMainWindow() {
        videoPlayer.setMainWindow(new MainWindow("精简模式", 800, 600));
    }

    public void buildControlBar() {
        videoPlayer.setControlBar(new ControlBar("精简"));
    }

    // 其他方法留空，精简模式不需要这些组件

    public VideoPlayer getVideoPlayer() {
        return videoPlayer;
    }
}
```

#### 3. 使用指挥者

```java
VideoPlayerDirector director = new VideoPlayerDirector(new SimpleModeBuilder());
VideoPlayer player = director.constructSimplePlayer();
```

## 不同显示模式的组件对比

| 模式 | 菜单 | 播放列表 | 主窗口 | 控制条 | 收藏列表 | 状态栏 |
|------|------|----------|---------|---------|----------|---------|
| 完整模式 | ✓ | ✓ | ✓ | ✓ | ✓ | ✓ |
| 精简模式 | ✗ | ✗ | ✓ | ✓ | ✗ | ✗ |
| 记忆模式 | ✓ | ✗ | ✓ | ✓ | ✓ | ✓ |
| 网络模式 | ✓ | ✓ | ✓ | ✓ | ✓ | ✓ |

## 优缺点分析

### 优点

1. **分离构建和表示**：将复杂对象的构建过程与表示分离
2. **灵活控制**：可以精细控制对象的构建过程
3. **易于扩展**：新增建造者不影响现有代码
4. **复用构建逻辑**：指挥者可以复用构建逻辑

### 缺点

1. **代码复杂性**：增加了类和接口的数量
2. **适用范围有限**：适合创建复杂对象，简单对象不值得使用
3. **依赖关系**：产品类与建造者需要紧密配合

## 使用场景

1. **需要生成的产品对象有复杂的内部结构**
   - 如视频播放器包含多个界面组件

2. **需要生成的产品对象的内部属性相互依赖**
   - 如某些组件依赖其他组件的存在

3. **需要隔离复杂对象的创建和使用**
   - 让用户不需要知道内部的构建细节

4. **需要控制对象的构建过程**
   - 按照特定顺序创建组件

## 与其他模式的区别

### vs 抽象工厂模式
- **建造者模式**：注重一步步构建复杂对象
- **抽象工厂**：注重产品族，支持多种系列产品

### vs 工厂方法模式
- **建造者模式**：创建复杂对象，多个步骤
- **工厂方法**：创建简单对象，一个步骤

## 实际应用

1. **StringBuilder/StringBuffer**：Java中的字符串构建器
2. **DocumentBuilder**：XML文档构建器
3. **AlertDialog.Builder**：Android对话框构建器
4. **OkHttpClient.Builder**：HTTP客户端配置构建器

建造者模式在需要创建具有多个组件的复杂对象时特别有用，它能够提供清晰的构建过程和灵活的组合方式。