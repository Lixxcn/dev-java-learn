# 桥接模式 - Sunny软件公司数据转换工具

## 项目背景

Sunny软件公司欲开发一个数据转换工具，可以将数据库中的数据转换成多种文件格式，例如txt、xml、pdf等格式，同时该工具需要支持多种不同的数据库。

## 设计方案

使用桥接模式进行设计，将数据转换系统分为两个独立的变化维度：
- **抽象部分**：文件格式转换器
- **实现部分**：数据库连接和操作

通过桥接模式，可以使这两个维度独立变化，灵活组合。

## 类图结构

```
                 ┌──────────────────┐
                 │    DataConverter │◄───────── 抽象部分（Abstraction）
                 │    <<抽象类>>     │
                 ├──────────────────┤
                 │ - database       │
                 ├──────────────────┤
                 │ + DataConverter()│
                 │ + convertData()  │
                 │ # formatData()   │
                 │ # saveFile()     │
                 └──────────────────┘
                          ▲
                          │
           ┌──────────────┼──────────────┐
           │              │              │
    ┌─────────────┐ ┌─────────────┐ ┌─────────────┐
    │ TXTConverter│ │ XMLConverter│ │ PDFConverter│
    └─────────────┘ └─────────────┘ └─────────────┘
    扩展抽象部分          扩展抽象部分          扩展抽象部分
（RefinedAbstraction） （RefinedAbstraction） （RefinedAbstraction）

                          ▲ 桥接
                          │
                 ┌──────────────────┐
                 │    Database      │◄───────── 实现部分（Implementor）
                 │    <<接口>>       │
                 ├──────────────────┤
                 │ + connect()      │
                 │ + getData()      │
                 │ + disconnect()   │
                 │ + getDatabaseType()│
                 └──────────────────┘
                          ▲
                          │
           ┌──────────────┼──────────────┐
           │              │              │
    ┌─────────────┐ ┌─────────────┐ ┌─────────────┐
    │MySQLDatabase│ │OracleDatabase│ │SQLServerDB  │
    └─────────────┘ └─────────────┘ └─────────────┘
    具体实现            具体实现            具体实现
（ConcreteImplementor）（ConcreteImplementor）（ConcreteImplementor）
```

## 核心组件说明

### 1. 抽象部分（Abstraction）

#### DataConverter（抽象类）
- **职责**：定义数据转换的控制流，持有数据库接口的引用
- **核心方法**：
  - `convertData()`: 模板方法，定义数据转换流程
  - `formatData()`: 抽象方法，由子类实现具体格式化逻辑
  - `saveFile()`: 抽象方法，由子类实现具体文件保存逻辑

#### 具体转换器类（RefinedAbstraction）
- **TXTConverter**: 将数据转换为TXT格式
- **XMLConverter**: 将数据转换为XML格式
- **PDFConverter**: 将数据转换为PDF格式

### 2. 实现部分（Implementor）

#### Database（接口）
- **职责**：定义数据库操作的抽象接口
- **核心方法**：
  - `connect()`: 连接数据库
  - `getData()`: 获取表数据
  - `disconnect()`: 断开连接

#### 具体数据库实现类（ConcreteImplementor）
- **MySQLDatabase**: MySQL数据库实现
- **OracleDatabase**: Oracle数据库实现
- **SQLServerDatabase**: SQL Server数据库实现

## 使用示例

### 基本使用
```java
// 1. 创建数据库实例（实现部分）
Database mysql = new MySQLDatabase("localhost:3306/sunny_db");

// 2. 创建转换器实例（抽象部分）
DataConverter converter = new TXTConverter(mysql);

// 3. 执行数据转换
converter.convertData("users");
```

### 动态组合
```java
// 任意组合数据库和文件格式
Database[] databases = {new MySQLDatabase(...), new OracleDatabase(...)};
DataConverter[] converters = {new TXTConverter(...), new XMLConverter(...)};

// 运行时动态选择组合
DataConverter selectedConverter = new PDFConverter(databases[1]);
selectedConverter.convertData("products");
```

## 桥接模式的优势

### 1. 分离抽象与实现
- 将文件格式转换和数据库操作两个维度解耦
- 各自可以独立扩展和变化

### 2. 提高扩展性
- **新增数据库**：只需实现Database接口
- **新增文件格式**：只需继承DataConverter类
- 无需修改现有代码

### 3. 符合设计原则
- **开闭原则**：对扩展开放，对修改关闭
- **合成/聚合复用原则**：优先使用组合而非继承
- **依赖倒置原则**：依赖抽象而非具体实现

### 4. 运行时灵活性
- 可以在运行时动态切换数据库和文件格式
- 客户端代码无需关心具体实现细节

## 实际应用场景

1. **多格式导出工具**：支持多种数据源和多种导出格式
2. **跨平台UI框架**：分离窗口系统（实现）和UI控件（抽象）
3. **支付系统**：分离支付方式（实现）和支付流程（抽象）
4. **消息系统**：分离消息协议（实现）和消息处理（抽象）

## 扩展示例

### 添加新的数据库支持
```java
public class PostgreSQLDatabase implements Database {
    // 实现PostgreSQL的连接和数据操作
}
// 无需修改任何转换器代码
```

### 添加新的文件格式
```java
public class ExcelConverter extends DataConverter {
    // 实现Excel格式的转换逻辑
}
// 无需修改任何数据库代码
```

## 运行方式

```bash
# 编译
javac -cp src/main/java src/main/java/cn/lixx/designpatterns/bridge/BridgeClient.java

# 运行
java -cp src/main/java cn.lixx.designpatterns.bridge.BridgeClient
```

## 组合矩阵

桥接模式支持以下组合：

| 数据库 \ 格式 | TXT | XML | PDF |
|--------------|-----|-----|-----|
| MySQL        | ✓   | ✓   | ✓   |
| Oracle       | ✓   | ✓   | ✓   |
| SQL Server   | ✓   | ✓   | ✓   |

总共支持 **3 × 3 = 9** 种组合，而只需要实现 **3 + 3 = 6** 个类。

## 总结

通过桥接模式，Sunny软件公司的数据转换工具实现了：
1. **高内聚低耦合**：各部分职责单一，相互独立
2. **易于维护**：修改一个维度不影响另一个维度
3. **灵活扩展**：方便添加新的数据库或文件格式
4. **代码复用**：转换器和数据库可以在不同组合中重复使用

桥接模式成功地将系统的多维变化问题转化为两个独立的变化维度，使系统更加灵活、可维护和可扩展。