# 装饰模式 - Sunny软件公司数据加密模块

## 项目背景

Sunny软件公司欲开发一个数据加密模块，可以对字符串进行加密。最简单的加密算法通过对字母进行移位来实现，同时还提供了稍复杂的逆向输出加密和更为高级的求模加密。用户先使用最简单的加密算法对字符串进行加密，如果觉得还不够，可以对加密之后的结果使用其他加密算法进行二次加密，当然也可以进行第3次加密。

## 设计方案

使用装饰模式设计该多重加密系统，允许动态地给对象添加额外的加密功能，而无需修改原有代码。

## 类图结构

```
                ┌──────────────┐
                │   Cipher     │ ◄──── 抽象构件（Component）
                │  <<接口>>     │
                ├──────────────┤
                │ + encrypt()  │
                │ + getDesc()  │
                └──────────────┘
                       △
                       │
        ┌──────────────┴──────────────┐
        │                             │
┌──────────────────┐        ┌──────────────────┐
│ SimpleShiftCipher│        │ CipherDecorator  │ ◄── 装饰器（Decorator）
│  (具体构件)       │        │  <<抽象类>>       │
└──────────────────┘        ├──────────────────┤
                            │ - decoratedCipher │
                            ├──────────────────┤
                            │ + encrypt()      │
                            │ + getDesc()      │
                            └──────────────────┘
                                      △
                                      │
           ┌──────────────────────────┴──────────────────┐
           │                                             │
    ┌──────────────┐                            ┌──────────────┐
    │ReverseCipher │                            │ModulusCipher │
    │(具体装饰器)   │                            │(具体装饰器)   │
    └──────────────┘                            └──────────────┘
```

## 核心组件说明

### 1. 抽象构件（Component）

**Cipher.java** - 加密器接口
```java
public interface Cipher {
    String encrypt(String plainText);
    String getDescription();
}
```

### 2. 具体构件（ConcreteComponent）

**SimpleShiftCipher.java** - 简单移位加密器
- 最基础的加密实现
- 通过对字母进行移位实现加密
- 可以作为被装饰的核心对象

```java
Cipher cipher = new SimpleShiftCipher(3);
String encrypted = cipher.encrypt("Hello"); // "Khoor"
```

### 3. 装饰器（Decorator）

**CipherDecorator.java** - 加密器装饰器抽象类
- 持有对Cipher接口的引用
- 实现Cipher接口
- 所有具体装饰器的基类

### 4. 具体装饰器（ConcreteDecorator）

#### ReverseCipher - 逆向输出加密
```java
Cipher cipher = new ReverseCipher(new SimpleShiftCipher(3));
// 加密过程: 移位加密 → 逆向输出
String encrypted = cipher.encrypt("Hello"); // "rooK"
```

#### ModulusCipher - 求模加密
```java
Cipher cipher = new ModulusCipher(new SimpleShiftCipher(3), 128);
// 加密过程: 移位加密 → 求模运算
String encrypted = cipher.encrypt("Hello"); // 求模后的结果
```

## 使用示例

### 示例1：单层加密
```java
// 基础移位加密
Cipher cipher = new SimpleShiftCipher(3);
String encrypted = cipher.encrypt("HelloWorld");
```

### 示例2：双层加密
```java
// 移位 + 逆向
Cipher cipher = new ReverseCipher(new SimpleShiftCipher(3));
String encrypted = cipher.encrypt("HelloWorld");

// 移位 + 求模
Cipher cipher = new ModulusCipher(new SimpleShiftCipher(3), 128);
String encrypted = cipher.encrypt("HelloWorld");
```

### 示例3：多层加密（三次加密）
```java
// 移位 → 逆向 → 求模
Cipher cipher = new ModulusCipher(
    new ReverseCipher(
        new SimpleShiftCipher(3)
    ),
    128
);
String encrypted = cipher.encrypt("HelloWorld");
```

### 示例4：超多层加密（五次加密）
```java
// 移位 → 逆向 → 求模 → 逆向 → 求模
Cipher cipher = new ModulusCipher(
    new ReverseCipher(
        new ModulusCipher(
            new ReverseCipher(
                new SimpleShiftCipher(5)
            ),
            64
        )
    ),
    256
);
String encrypted = cipher.encrypt("HelloWorld");
```

### 示例5：动态添加加密层
```java
// 从基础加密开始
Cipher cipher = new SimpleShiftCipher(3);
String result = cipher.encrypt("HelloWorld");

// 动态添加逆向加密
cipher = new ReverseCipher(cipher);
result = cipher.encrypt("HelloWorld");

// 再动态添加求模加密
cipher = new ModulusCipher(cipher, 128);
result = cipher.encrypt("HelloWorld");
```

## 加密流程示意

```
【单层加密 - 移位】
明文: "HelloWorld"
   ↓
移位加密 (+3)
   ↓
密文: "KhoorZruog"

【双层加密 - 移位 + 逆向】
明文: "HelloWorld"
   ↓
移位加密 (+3)
   ↓
中间结果: "KhoorZruog"
   ↓
逆向输出
   ↓
密文: "gourZroohK"

【三层加密 - 移位 + 逆向 + 求模】
明文: "HelloWorld"
   ↓
移位加密 (+3)
   ↓
逆向输出
   ↓
求模运算 (mod 128)
   ↓
密文: [最终结果]
```

## 装饰模式的优势

### 1. 动态扩展功能
- 不修改原有对象，动态添加新功能
- 可以在运行时灵活地组合功能

### 2. 避免类爆炸
- 比继承更灵活
- 不需要为每种组合创建子类

### 3. 符合设计原则
- **单一职责原则**：每个装饰器只关注自己的加密逻辑
- **开闭原则**：对扩展开放，对修改关闭
- **里氏替换原则**：装饰器可以替换被装饰对象
- **依赖倒置原则**：依赖抽象接口而非具体实现

### 4. 灵活组合
- 可以任意组合不同的装饰器
- 可以嵌套多层，实现复杂功能
- 装饰顺序可以自由调整

## 组合可能性

如果有：
- 1种基础加密
- 2种装饰器加密（逆向、求模）

可能的组合：
- 单层：1种（移位）
- 双层：2种（移位+逆向、移位+求模）
- 三层：1种（移位+逆向+求模）
- 更高层级：无限组合

**总计：无需创建额外类，即可实现无限种加密组合！**

## 对比：使用继承的问题

如果使用继承实现相同的加密组合：

```
SimpleShiftCipher (基础类)
├── ReverseSimpleShiftCipher (移位+逆向)
├── ModulusSimpleShiftCipher (移位+求模)
├── ReverseModulusSimpleShiftCipher (移位+逆向+求模)
├── ModulusReverseSimpleShiftCipher (移位+求模+逆向)
├── ReverseModulusReverseSimpleShiftCipher (移位+逆向+求模+逆向)
└── ... (无限增长)
```

类爆炸！而使用装饰模式，只需要：
- 1个基础类
- 1个装饰器抽象类
- 2个具体装饰器类

## 运行方式

```bash
# 编译
javac -cp src/main/java src/main/java/cn/lixx/designpatterns/decorator/DecoratorClient.java

# 运行
java -cp src/main/java cn.lixx.designpatterns.decorator.DecoratorClient
```

## 实际应用场景

1. **Java I/O流**：最经典的装饰模式应用
   ```java
   new BufferedReader(new InputStreamReader(new FileInputStream(...)))
   ```

2. **GUI组件**：为窗口添加滚动条、边框等
3. **数据处理**：为数据添加压缩、加密、编码等功能
4. **日志系统**：为基础日志添加时间戳、级别、格式化等功能
5. **缓存系统**：为基础服务添加缓存层

## 扩展示例

### 添加新的加密算法

```java
// 新增：Base64编码装饰器
public class Base64Cipher extends CipherDecorator {
    public Base64Cipher(Cipher cipher) {
        super(cipher);
    }

    @Override
    public String encrypt(String plainText) {
        String encrypted = decoratedCipher.encrypt(plainText);
        return Base64.encode(encrypted);
    }

    @Override
    public String getDescription() {
        return decoratedCipher.getDescription() + " + Base64编码";
    }
}

// 使用新装饰器
Cipher cipher = new Base64Cipher(
    new ModulusCipher(
        new ReverseCipher(
            new SimpleShiftCipher(3)
        ),
        128
    )
);
```

## 总结

通过装饰模式，Sunny软件公司的数据加密模块实现了：
1. **灵活的加密组合**：用户可以自由组合不同的加密算法
2. **动态功能扩展**：运行时决定加密层级和顺序
3. **代码结构清晰**：每种加密算法独立实现，职责单一
4. **易于维护**：添加新加密算法无需修改现有代码
5. **避免类爆炸**：不需要为每种组合创建新类

装饰模式成功地将静态的继承关系转化为动态的组合关系，使系统更加灵活和可扩展。