# 外观模式 - Sunny软件公司一键备份功能

## 项目背景

Sunny软件公司为新开发的智能手机控制与管理软件提供了一键备份功能。通过该功能可以将原本存储在手机中的通讯录、短信、照片、歌曲等资料一次性地全部复制到移动存储介质（如MMC卡或SD卡）中。在实现过程中需要与多个已有的类进行交互，例如通讯录管理类、短信管理类等。为了降低系统的耦合性，使用外观模式来设计并实现该一键备份功能。

## 设计方案

使用外观模式为复杂的子系统提供简单的接口，降低客户端与子系统之间的耦合度。

## 类图结构

```
                    ┌─────────────────────────────┐
                    │       BackupFacade          │ ◄──── 外观类（Facade）
                    │  <<外观类>>                  │
                    ├─────────────────────────────┤
                    │ - contactManager            │
                    │ - messageManager            │
                    │ - photoManager              │
                    │ - musicManager              │
                    │ - storageMedia              │
                    ├─────────────────────────────┤
                    │ + oneClickBackup()          │
                    │ + selectiveBackup()         │
                    │ + backupContacts()          │
                    │ + backupMessages()          │
                    │ + backupPhotos()            │
                    │ + backupMusic()             │
                    │ + getDataStatistics()       │
                    └─────────────────────────────┘
                                    │
                    ┌───────────────┼───────────────┐
                    │               │               │               │
        ┌───────────────┐ ┌───────────────┐ ┌───────────────┐ ┌───────────────┐
        │ ContactManager│ │ MessageManager│ │ PhotoManager  │ │ MusicManager  │
        │   <<子系统>>   │ │   <<子系统>>   │ │   <<子系统>>   │ │   <<子系统>>   │
        └───────────────┘ └───────────────┘ └───────────────┘ └───────────────┘
                    │               │               │               │
                    └───────────────┼───────────────┴───────────────┘
                                    │
                        ┌───────────────────┐
                        │  StorageMedia     │ ◄── 子系统
                        │   <<子系统>>       │
                        └───────────────────┘
```

## 核心组件说明

### 1. 子系统（Subsystem）

子系统是实现具体功能的类，彼此之间可能存在复杂的依赖关系。

#### ContactManager - 通讯录管理
```java
// 读取通讯录
List<Contact> contacts = contactManager.readContacts();

// 备份通讯录
contactManager.backupContacts(contacts, path);
```

#### MessageManager - 短信管理
```java
// 读取短信
List<Message> messages = messageManager.readMessages();

// 备份短信
messageManager.backupMessages(messages, path);
```

#### PhotoManager - 照片管理
```java
// 读取照片
List<Photo> photos = photoManager.readPhotos();

// 备份照片
photoManager.backupPhotos(photos, path);
```

#### MusicManager - 音乐管理
```java
// 读取音乐
List<Song> songs = musicManager.readSongs();

// 备份音乐
musicManager.backupSongs(songs, path);
```

#### StorageMedia - 存储介质
```java
// 连接存储介质
storageMedia.connect();

// 获取备份路径
String path = storageMedia.getBackupPath("Contacts");

// 断开存储介质
storageMedia.disconnect();
```

### 2. 外观类（Facade）

**BackupFacade** - 备份外观类

为复杂的子系统操作提供简单、统一的接口，隐藏子系统的复杂性。

#### 核心方法

**一键备份所有数据：**
```java
BackupFacade facade = new BackupFacade(sdCard);
BackupResult result = facade.oneClickBackup();
```

**选择性备份：**
```java
BackupResult result = facade.selectiveBackup(
    true,   // 备份通讯录
    false,  // 不备份短信
    true,   // 备份照片
    false   // 不备份音乐
);
```

**单独备份某类数据：**
```java
facade.backupContacts();   // 只备份通讯录
facade.backupMessages();   // 只备份短信
facade.backupPhotos();     // 只备份照片
facade.backupMusic();      // 只备份音乐
```

**获取数据统计：**
```java
DataStatistics stats = facade.getDataStatistics();
System.out.println(stats);
```

## 使用示例

### 示例1：不使用外观模式（客户端代码复杂）

```java
// 客户端需要直接与多个子系统交互
ContactManager contactManager = new ContactManager();
MessageManager messageManager = new MessageManager();
PhotoManager photoManager = new PhotoManager();
MusicManager musicManager = new MusicManager();
StorageMedia sdCard = new StorageMedia(...);

// 客户端需要处理复杂的流程
sdCard.connect();

List<Contact> contacts = contactManager.readContacts();
contactManager.backupContacts(contacts, sdCard.getBackupPath("Contacts"));

List<Message> messages = messageManager.readMessages();
messageManager.backupMessages(messages, sdCard.getBackupPath("Messages"));

List<Photo> photos = photoManager.readPhotos();
photoManager.backupPhotos(photos, sdCard.getBackupPath("Photos"));

List<Song> songs = musicManager.readSongs();
musicManager.backupSongs(songs, sdCard.getBackupPath("Music"));

sdCard.disconnect();

// 还需要处理各种异常情况...
```

### 示例2：使用外观模式（客户端代码简洁）

```java
// 创建外观对象
StorageMedia sdCard = new StorageMedia("SanDisk 32GB",
    StorageMedia.StorageType.SD_CARD, 32L * 1024 * 1024 * 1024, "/mnt/sdcard");

BackupFacade facade = new BackupFacade(sdCard);

// 一键备份所有数据
BackupResult result = facade.oneClickBackup();

if (result.isSuccess()) {
    System.out.println("备份成功！");
} else {
    System.out.println("备份失败：" + result.getErrorMessage());
}
```

## 外观模式的优势

### 1. 简化客户端代码
- 客户端不需要知道子系统的细节
- 提供简单、统一的接口
- 减少客户端需要处理的类数量

### 2. 降低耦合度
- 客户端与子系统解耦
- 客户端只依赖外观类
- 子系统的变化不会影响客户端

### 3. 提高灵活性
- 可以修改子系统而不影响客户端
- 可以在不改变客户端代码的情况下调整内部实现
- 支持多种备份方式（一键备份、选择性备份等）

### 4. 封装复杂性
- 隐藏复杂的交互逻辑
- 管理子系统的生命周期
- 统一异常处理

### 5. 分层设计
- 在客户端和子系统之间建立清晰的层次
- 遵循"迪米特法则"（最少知识原则）

## 代码对比

| 方面 | 不使用外观模式 | 使用外观模式 |
|------|--------------|------------|
| 客户端代码行数 | ~50行 | ~5行 |
| 需要了解的类数量 | 5个 | 1个 |
| 代码复杂度 | 高 | 低 |
| 耦合度 | 高（与多个子系统耦合） | 低（只与外观类耦合） |
| 可维护性 | 差 | 好 |
| 易用性 | 差 | 好 |

## 备份流程

```
【一键备份流程】
┌─────────────┐
│  客户端     │
└──────┬──────┘
       │ 调用 oneClickBackup()
       ▼
┌─────────────────────────────────────────┐
│           BackupFacade                  │
│  (外观类 - 协调所有子系统)               │
└───────┬─────────────────────────────────┘
        │
        ├──> 连接存储介质
        │
        ├──> 备份通讯录
        │        ContactManager
        │
        ├──> 备份短信
        │        MessageManager
        │
        ├──> 备份照片
        │        PhotoManager
        │
        ├──> 备份音乐
        │        MusicManager
        │
        └──> 断开存储介质
```

## 运行方式

```bash
# 编译
javac -cp src/main/java src/main/java/cn/lixx/designpatterns/facade/FacadeClient.java

# 运行
java -cp src/main/java cn.lixx.designpatterns.facade.FacadeClient
```

## 实际应用场景

1. **API网关**：为多个微服务提供统一入口
2. **数据库访问层**：简化复杂的数据库操作
3. **日志系统**：统一多个日志框架的使用
4. **支付系统**：封装多种支付方式的复杂性
5. **文件压缩工具**：统一多种压缩格式的使用

## 设计原则

外观模式体现了以下设计原则：
- **迪米特法则**：最少知识原则，客户端只需要知道外观类
- **单一职责原则**：外观类负责协调子系统，子系统负责具体功能
- **开闭原则**：对扩展开放，可以添加新的备份方式
- **依赖倒置原则**：客户端依赖抽象（外观接口）而非具体实现

## 扩展示例

### 添加新的备份类型

```java
// 1. 创建新的子系统类
public class VideoManager {
    public List<Video> readVideos() { ... }
    public boolean backupVideos(List<Video> videos, String path) { ... }
}

// 2. 在BackupFacade中添加新的字段和方法
public class BackupFacade {
    private VideoManager videoManager;

    public boolean backupVideos() {
        List<Video> videos = videoManager.readVideos();
        return videoManager.backupVideos(videos, storageMedia.getBackupPath("Videos"));
    }
}

// 3. 修改oneClickBackup()方法，添加视频备份
public BackupResult oneClickBackup() {
    // ... 现有代码 ...
    boolean videoBackup = backupVideos();
    result.setVideosBackedUp(videoBackup);
    // ...
}
```

## 总结

通过外观模式，Sunny软件公司的一键备份功能实现了：
1. **简化的客户端代码**：只需一行代码即可完成复杂备份
2. **低耦合度**：客户端不需要了解子系统的实现细节
3. **高灵活性**：支持一键备份、选择性备份等多种方式
4. **易于维护**：子系统的变化不会影响客户端代码
5. **良好的封装性**：复杂的备份逻辑被封装在外观类中

外观模式成功地简化了复杂系统的使用，提高了系统的可维护性和可扩展性。