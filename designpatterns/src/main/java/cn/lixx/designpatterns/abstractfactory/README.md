# 抽象工厂模式 - 跨平台手机游戏设计

## 设计模式说明

抽象工厂模式（Abstract Factory Pattern）是一种创建型设计模式，它提供一个接口用于创建一系列相关或相互依赖的对象，而无需指定它们的具体类。

## 问题背景

Sunny软件公司需要开发一款支持iOS和Android等多个智能手机操作系统平台的手机游戏软件。针对不同的手机操作系统，需要提供不同的游戏操作控制类和游戏界面控制类。

## 解决方案

### 类结构

```
ControllerFactory (抽象工厂)
├── iOSControllerFactory (具体工厂1)
└── AndroidControllerFactory (具体工厂2)

OperationController (抽象产品A)
├── iOSOperationController (具体产品A1)
└── AndroidOperationController (具体产品A2)

InterfaceController (抽象产品B)
├── iOSInterfaceController (具体产品B1)
└── AndroidInterfaceController (具体产品B2)
```

### 角色说明

1. **AbstractFactory (抽象工厂)**: `ControllerFactory` 接口
   - 声明了创建操作控制器和界面控制器的方法

2. **ConcreteFactory (具体工厂)**: `iOSControllerFactory`, `AndroidControllerFactory`
   - 实现了创建具体产品对象的方法
   - 每个工厂负责创建一个产品族

3. **AbstractProduct (抽象产品)**: `OperationController`, `InterfaceController`
   - 定义了产品对象的接口

4. **ConcreteProduct (具体产品)**: 各平台的具体控制器实现
   - 实现了抽象产品接口
   - 同一个工厂创建的产品属于同一个产品族

5. **Client (客户端)**: `GameClient`
   - 使用抽象工厂和抽象产品进行开发
   - 不需要关心具体产品的创建细节

## 优势

1. **保证产品族一致性**: 同一个工厂创建的产品对象属于同一个产品族，风格一致
2. **易于扩展新平台**: 要支持新的操作系统，只需添加新的工厂和产品类
3. **符合开闭原则**: 对扩展开放，对修改关闭
4. **分离关注点**: 将产品创建细节与客户端代码分离

## 使用示例

```java
// iOS平台
ControllerFactory iOSFactory = new iOSControllerFactory();
GameClient iOSGame = new GameClient(iOSFactory);

// Android平台
ControllerFactory androidFactory = new AndroidControllerFactory();
GameClient androidGame = new GameClient(androidFactory);
```

## 扩展性

如需支持新的操作系统平台（如Windows Phone），只需：

1. 实现 `OperationController` 接口
2. 实现 `InterfaceController` 接口
3. 实现 `ControllerFactory` 接口
4. 在客户端中使用新的工厂

无需修改现有代码，符合开闭原则。