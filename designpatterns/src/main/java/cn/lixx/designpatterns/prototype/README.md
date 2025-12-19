# 原型模式 - 客户对象复制设计

## 设计模式说明

原型模式（Prototype Pattern）是一种创建型设计模式，它使用原型实例指定创建对象的种类，并通过拷贝这些原型创建新的对象。

## 问题背景

Sunny软件公司在销售管理系统中有一个客户类Customer，包含客户地址（Address）这个成员变量。需要实现Customer对象的复制功能。

## 解决方案

### 类结构

```
Customer（原型类）
├── 实现Cloneable接口
├── 浅克隆方法：clone()
├── 深克隆方法：deepClone()
└── 序列化深克隆：deepCloneBySerialization()

Address（引用类型成员变量）
├── 实现Cloneable接口
└── 实现clone()方法
```

### 核心代码

#### 1. 浅克隆实现

```java
@Override
public Customer clone() {
    try {
        return (Customer) super.clone();
    } catch (CloneNotSupportedException e) {
        throw new RuntimeException(e);
    }
}
```

#### 2. 深克隆实现 - 方式1：手动实现

```java
public Customer deepClone() {
    Customer customer = null;
    try {
        customer = (Customer) super.clone();
        // 手动克隆address对象
        customer.address = this.address.clone();
    } catch (CloneNotSupportedException e) {
        throw new RuntimeException(e);
    }
    return customer;
}
```

#### 3. 深克隆实现 - 方式2：使用序列化

```java
public Customer deepCloneBySerialization() {
    try {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (Customer) ois.readObject();
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}
```

## 浅克隆 vs 深克隆

### 浅克隆（Shallow Clone）

**特点：**
- 只复制基本数据类型和String类型的值
- 引用类型只复制引用，不创建新的对象
- 克隆对象和原对象共享引用类型的成员变量
- 实现简单，性能较好

**内存示意图：**
```
原对象          克隆对象
  |               |
  |--基本类型--->|--基本类型（独立）
  |               |
  |--引用----->|--引用（指向同一个地址对象）
                 |
                 V
              共享的Address对象
```

### 深克隆（Deep Clone）

**特点：**
- 复制所有数据，包括引用类型的对象
- 克隆对象和原对象完全独立，互不影响
- 需要手动实现或使用序列化技术
- 实现相对复杂，性能开销较大

**内存示意图：**
```
原对象          克隆对象
  |               |
  |--基本类型--->|--基本类型（独立）
  |               |
  |--引用----->|--引用（指向不同的地址对象）
  |               |
  V               V
独立的Address对象   独立的Address对象
```

## 使用场景

1. **创建新对象成本较大**：如初始化需要占用较多时间或资源
2. **需要大量相似对象**：通过原型复制比new创建更高效
3. **保护原始对象**：使用副本进行操作，避免修改原对象

## 优缺点

### 优点

1. **性能提升**：比直接创建对象更高效
2. **简化创建**：避免了复杂的构造函数调用
3. **保护原型**：可以在不修改原型的情况下修改副本

### 缺点

1. **实现复杂**：深克隆需要处理所有引用类型
2. **克隆限制**：final类型的成员变量无法被克隆
3. **维护困难**：添加新成员变量时需要更新克隆方法

## 测试验证

运行PrototypeClient可以看到：

1. **浅克隆测试**：修改克隆对象的地址会影响原对象
2. **深克隆测试**：修改克隆对象的地址不会影响原对象
3. **序列化深克隆**：另一种实现深克隆的方式

## 注意事项

1. 实现Cloneable接口只是标识，clone()方法仍需重写
2. 深克隆需要递归克隆所有引用类型
3. 使用序列化需要确保所有类都实现Serializable接口
4. 对于不可变对象（如String），浅克隆和深克隆效果相同