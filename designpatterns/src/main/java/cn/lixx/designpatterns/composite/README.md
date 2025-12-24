# 组合模式 - Sunny软件公司界面控件库

## 项目背景

Sunny软件公司欲开发一个界面控件库。界面控件分为两大类：
- **单元控件**：例如按钮、文本框、标签等（叶子节点）
- **容器控件**：例如窗体、面板等（组合节点）

试使用组合模式设计该界面控件库。

## 设计方案

使用组合模式将控件组织成树形结构，使得客户端可以一致地处理单个控件和控件组合。

## 类图结构

```
                    ┌──────────────────────┐
                    │     Component        │ ◄──── 抽象构件
                    │    <<抽象类>>         │
                    ├──────────────────────┤
                    │ # name: String       │
                    ├──────────────────────┤
                    │ + add()              │
                    │ + remove()           │
                    │ + getChild()         │
                    │ + getChildren()      │
                    │ + display()          │
                    └──────────────────────┘
                             △
                             │
           ┌─────────────────┴─────────────────┐
           │                                   │
    ┌─────────────┐                   ┌─────────────┐
    │   Leaf      │                   │ Composite   │
    │ <<叶子>>     │                   │ <<容器>>     │
    ├─────────────┤                   ├─────────────┤
    │ + display() │                   │ - children  │
    └─────────────┘                   ├─────────────┤
             △                         │ + add()     │
             │                         │ + remove()  │
     ┌───────┴────────┐               │ + display() │
     │                │               └─────────────┘
┌─────────┐  ┌─────────┐                    △
│ Button  │  │ TextBox │                    │
└─────────┘  └─────────┘            ┌────────┴────────┐
┌─────────┐  ┌─────────┐            │                 │
│  Label  │  │ CheckBox│       ┌─────────┐    ┌─────────┐
└─────────┘  └─────────┘       │  Panel  │    │ Window  │
                              └─────────┘    └─────────┘
```

## 核心组件说明

### 1. 抽象构件（Component）

**Component.java** - 所有控件的抽象基类
- 定义了控件的公共接口
- 提供默认的add/remove/getChild方法（抛出异常）
- 声明抽象方法display()供子类实现

### 2. 叶子构件（Leaf）

叶子构件是不可再分的单元控件，不能包含子控件。

#### Button（按钮）
```java
Button btn = new Button("loginBtn", "登录", "100", "30");
btn.click(); // 点击按钮
```

#### TextBox（文本框）
```java
TextBox txt = new TextBox("username", "请输入用户名");
txt.setValue("admin"); // 设置值
String value = txt.getValue(); // 获取值
```

#### Label（标签）
```java
Label lbl = new Label("titleLabel", "欢迎", "16", true);
lbl.setText("新标题"); // 设置文本
```

#### CheckBox（复选框）
```java
CheckBox chk = new CheckBox("remember", "记住密码");
chk.setChecked(true); // 设置选中状态
boolean checked = chk.isChecked(); // 获取状态
```

### 3. 容器构件（Composite）

容器构件可以包含其他控件（包括叶子控件和其他容器控件）。

#### Panel（面板）
```java
Panel panel = new Panel("mainPanel", "GridLayout");
panel.add(new Button("btn1", "按钮1"));
panel.add(new Label("lbl1", "标签1"));
```

#### Window（窗口）
```java
Window wnd = new Window("loginWnd", "用户登录", 400, 300);
wnd.add(panel);
wnd.show(); // 显示窗口
```

## 使用示例

### 示例1：简单登录窗口
```java
// 创建窗口
Window loginWindow = new Window("loginWnd", "用户登录", 400, 300);

// 创建控件
Label userLabel = new Label("lblUser", "用户名：");
TextBox userTextBox = new TextBox("txtUser", "请输入用户名");
Button loginButton = new Button("btnLogin", "登录");

// 添加到窗口
loginWindow.add(userLabel);
loginWindow.add(userTextBox);
loginWindow.add(loginButton);

// 显示
loginWindow.display();
```

### 示例2：嵌套面板结构
```java
Window window = new Window("mainWnd", "主窗口", 800, 600);

// 创建面板
Panel basicPanel = new Panel("basicPanel", "GridLayout");
Panel buttonPanel = new Panel("buttonPanel", "Horizontal");

// 添加控件到面板
basicPanel.add(new TextBox("username", "用户名"));
buttonPanel.add(new Button("submit", "提交"));
buttonPanel.add(new Button("cancel", "取消"));

// 将面板添加到窗口
window.add(basicPanel);
window.add(buttonPanel);

// 显示整个控件树
window.display();
```

### 示例3：统一处理控件
```java
// 组合模式允许统一处理不同类型的控件
Component[] controls = {
    new Button("btn", "按钮"),
    new Label("lbl", "标签"),
    new Panel("panel", "Flow"),
    new Window("wnd", "窗口", 300, 200)
};

// 统一调用display，无需区分类型
for (Component control : controls) {
    control.display();
}
```

## 组合模式的优势

### 1. 一致性
- 客户端可以一致地使用组合结构和单个对象
- 无需区分处理的是叶子控件还是容器控件

### 2. 层次化
- 清晰地定义了分层次的层次结构
- 容易表示"部分-整体"的树形结构

### 3. 扩展性
- 方便添加新的控件类型（只需继承Component）
- 符合开闭原则

### 4. 简化客户端
- 客户端不需要知道处理的是组合对象还是单个对象
- 统一的接口简化了代码

## 控件树示例

```
Window (主窗口)
├─ Label (标题)
├─ Panel (基本信息面板)
│   ├─ Label (用户名)
│   ├─ TextBox (用户名输入框)
│   ├─ Label (邮箱)
│   └─ TextBox (邮箱输入框)
├─ Panel (密码面板)
│   ├─ Label (密码)
│   └─ TextBox (密码输入框)
└─ Panel (按钮面板)
    ├─ Button (提交)
    └─ Button (取消)
```

## 透明方式 vs 安全方式

本实现采用**透明方式**：
- Component中声明所有管理子对象的方法（add、remove、getChild）
- 叶子节点也需要实现这些方法（通常抛出异常）
- 优点：客户端完全一致地对待所有对象
- 缺点：不够安全，叶子节点调用这些方法会报错

**安全方式**的实现：
- 只在Composite中声明管理子对象的方法
- 优点：安全
- 缺点：客户端需要区分类型，不够一致

## 运行方式

```bash
# 编译
javac -cp src/main/java src/main/java/cn/lixx/designpatterns/composite/CompositeClient.java

# 运行
java -cp src/main/java cn.lixx.designpatterns.composite.CompositeClient
```

## 实际应用场景

1. **图形用户界面**：如本例的控件库
2. **文件系统**：文件和文件夹的树形结构
3. **组织架构**：公司和部门的层级结构
4. **菜单系统**：菜单和菜单项的层次结构
5. **XML/JSON处理**：节点的递归结构

## 设计原则

组合模式体现了以下设计原则：
- **单一职责原则**：每个控件只负责自己的显示和交互
- **开闭原则**：易于添加新的控件类型，无需修改现有代码
- **里氏替换原则**：可以用Composite替换Component
- **依赖倒置原则**：依赖抽象Component而非具体实现

## 总结

通过组合模式，Sunny软件公司的界面控件库实现了：
1. **清晰的层次结构**：控件树形结构清晰表达"部分-整体"关系
2. **统一的操作接口**：客户端无需区分叶子节点和容器节点
3. **高扩展性**：可以方便地添加新的控件类型
4. **代码复用**：容器控件可以包含任意类型的控件
5. **递归处理**：支持递归遍历和操作整个控件树

组合模式成功地构建了灵活、可扩展的界面控件库框架。