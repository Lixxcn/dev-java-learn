# 适配器模式 - Sunny软件公司OA系统加密模块

## 项目背景

Sunny软件公司OA系统需要提供一个加密模块，将用户机密信息（例如口令、邮箱等）加密之后再存储在数据库中。系统已经定义好了数据库操作类，但需要重用已有的第三方加密算法。这些算法封装在一些由第三方提供的类中，有些甚至没有源代码。

## 设计方案

使用适配器模式设计该加密模块，实现在不修改现有类的基础上重用第三方加密方法。提供了**对象适配器模式**和**类适配器模式**两套实现方案。

## 类图结构

### 对象适配器模式
```
      ┌─────────────┐         ┌──────────────────┐
      │  Encryptor  │         │ MD5EncryptUtil   │
      │  <<接口>>    │         │  (第三方类)       │
      ├─────────────┤         ├──────────────────┤
      │ +encrypt()  │         │ +encode()        │
      │ +decrypt()  │         │ +getSalt()       │
      └─────────────┘         └──────────────────┘
              ▲                         ▲
              │                         │
      ┌─────────────┐         ┌──────────────────┐
      │DatabaseMgr  │         │ AESEncryptor     │
      └─────────────┘         │  (第三方类)       │
              │               ├──────────────────┤
              │               │ +aesEncode()     │
              └───────────────▶│ +aesDecode()     │
                              └──────────────────┘
                                       ▲
                                       │
                              ┌──────────────────┐
                              │MD5ObjectAdapter  │
                              ├──────────────────┤
                              │ -md5Util         │
                              ├──────────────────┤
                              │ +encrypt()       │
                              │ +decrypt()       │
                              └──────────────────┘
```

### 类适配器模式
```
      ┌─────────────┐         ┌──────────────────┐
      │  Encryptor  │         │ AESEncryptor     │
      │  <<接口>>    │         │  (第三方类)       │
      ├─────────────┤         ├──────────────────┤
      │ +encrypt()  │         │ +aesEncode()     │
      │ +decrypt()  │         │ +aesDecode()     │
      └─────────────┘         └──────────────────┘
              ▲                         ▲
              │                         │
              └───────────────┬─────────┘
                              │
                     ┌──────────────────┐
                     │AESClassAdapter   │
                     ├──────────────────┤
                     │ +encrypt()       │
                     │ +decrypt()       │
                     └──────────────────┘
```

## 核心组件说明

### 1. 目标接口（Target）
- **Encryptor.java**: 系统标准加密接口，定义了encrypt()和decrypt()方法

### 2. 第三方加密类（Adaptee）
- **MD5EncryptUtil.java**: 第三方MD5加密工具类（单向加密）
- **AESEncryptor.java**: 第三方AES加密器类（双向加密）
- **DESEncrypt.java**: 第三方DES加密工具类（双向加密）

### 3. 适配器类（Adapter）

#### 对象适配器实现
- **MD5ObjectAdapter.java**: MD5对象适配器
- **AESObjectAdapter.java**: AES对象适配器
- **DESObjectAdapter.java**: DES对象适配器

#### 类适配器实现
- **AESClassAdapter.java**: AES类适配器
- **DESClassAdapter.java**: DES类适配器

### 4. 客户端类
- **DatabaseManager.java**: 数据库操作类，使用Encryptor接口
- **AdapterClient.java**: 测试客户端，演示两种适配器模式的使用

## 使用示例

### 对象适配器模式使用
```java
// 使用AES对象适配器
Encryptor aesAdapter = new AESObjectAdapter("mySecretKey");
DatabaseManager dbManager = new DatabaseManager(aesAdapter);
dbManager.storeUserInfo("张三", "password123", "zhangsan@email.com");
```

### 类适配器模式使用
```java
// 使用AES类适配器
Encryptor aesAdapter = new AESClassAdapter("mySecretKey");
DatabaseManager dbManager = new DatabaseManager(aesAdapter);
dbManager.storeUserInfo("张三", "password123", "zhangsan@email.com");
```

## 两种适配器模式对比

### 对象适配器模式
- **优点**：
  - 通过组合实现，符合"组合优于继承"原则
  - 一个适配器可以适配多个Adaptee
  - 灵活性高，易于扩展

- **缺点**：
  - 需要额外的对象引用

### 类适配器模式
- **优点**：
  - 可以重写父类的方法，更加灵活
  - 简化了适配器的实现

- **缺点**：
  - 由于Java单继承特性，限制了灵活性
  - 与Adaptee耦合度较高

## 运行方式

```bash
# 编译
javac -cp src/main/java src/main/java/cn/lixx/designpatterns/adapter/AdapterClient.java

# 运行
java -cp src/main/java cn.lixx.designpatterns.adapter.AdapterClient
```

## 设计要点

1. **开闭原则**: 对扩展开放，对修改关闭。通过适配器模式，无需修改原有代码即可使用新的加密算法。

2. **单一职责原则**: 每个适配器只负责将一个特定的第三方类适配到目标接口。

3. **接口隔离原则**: Encryptor接口只包含必要的加密和解密方法。

4. **依赖倒置原则**: DatabaseManager依赖于Encryptor抽象接口，而不是具体的加密实现。

## 实际应用场景

1. **集成第三方库**: 当需要使用第三方功能但接口不兼容时
2. **旧系统改造**: 重用旧系统的功能，但需要适配新的接口
3. **多版本兼容**: 同一功能的多个版本需要统一接口
4. **功能扩展**: 为现有类添加新的功能，但不修改原有代码

## 总结

通过适配器模式，Sunny软件公司OA系统成功地在不修改第三方加密类的基础上，将其功能无缝集成到系统中。对象适配器和类适配器两种实现方案各有优劣，可以根据具体需求选择合适的实现方式。这种设计模式提高了系统的灵活性和可维护性，降低了系统与第三方组件的耦合度。