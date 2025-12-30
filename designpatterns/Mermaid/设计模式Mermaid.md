# 设计模式 Mermaid 类图

本文档包含项目中已实现的设计模式的 Mermaid 类图。

---

## 1. 简单工厂模式 (Simple Factory)

严格来说它不属于 GoF 23种模式，但它是学习工厂模式的基础。由一个工厂对象决定创建出哪一种产品类的实例。

### 类图


```mermaid
classDiagram
    class Shape {
        <<interface>>
        +draw() void
        +erase() void
    }

    class Circle {
        -double radius
        +Circle(double radius)
        +draw() void
        +erase() void
        +getRadius() double
        +setRadius(double radius) void
    }

    class Square {
        -double side
        +Square(double side)
        +draw() void
        +erase() void
    }

    class Triangle {
        -double base
        -double height
        +Triangle(double base, double height)
        +draw() void
        +erase() void
    }

    class ShapeFactory {
        +createShape(String shapeType, double... parameters) Shape
        +getSupportedShapes() String[]
    }

    class DrawingTool {
        +main(String[] args) void
    }

    class UnSupportedShapeException {
        +UnSupportedShapeException(String message)
    }

    Shape <|.. Circle
    Shape <|.. Square
    Shape <|.. Triangle
    ShapeFactory ..> Shape : creates
    ShapeFactory ..> Circle : creates
    ShapeFactory ..> Square : creates
    ShapeFactory ..> Triangle : creates
    DrawingTool ..> ShapeFactory : uses
    ShapeFactory ..> UnSupportedShapeException : throws
```

---

## 2. 工厂方法模式 (Factory Method)

定义一个用于创建对象的接口，让子类决定实例化哪一个类。工厂方法使一个类的实例化延迟到其子类。

### 类图


```mermaid
classDiagram
    class ImageReader {
        <<interface>>
        +readImage(String filePath) String
        +getSupportedFormat() String
        +isFormatSupported(String filePath) boolean
    }

    class ImageReaderFactory {
        <<interface>>
        +createImageReader() ImageReader
        +getSupportedFormat() String
        +canHandle(String filePath) boolean
    }

    class PngReader {
        +readImage(String filePath) String
        +getSupportedFormat() String
        -hasTransparency(String filePath) boolean
        -extractBitDepth(String filePath) int
        -extractCompressionType(String filePath) String
    }

    class GifReader {
        +readImage(String filePath) String
        +getSupportedFormat() String
    }

    class JpgReader {
        +readImage(String filePath) String
        +getSupportedFormat() String
    }

    class BmpReader {
        +readImage(String filePath) String
        +getSupportedFormat() String
    }

    class PngReaderFactory {
        +createImageReader() ImageReader
        +getSupportedFormat() String
        +createPngReader(boolean preserveTransparency) ImageReader
    }

    class GifReaderFactory {
        +createImageReader() ImageReader
        +getSupportedFormat() String
        +createGifReader(boolean supportAnimation) ImageReader
    }

    class JpgReaderFactory {
        +createImageReader() ImageReader
        +getSupportedFormat() String
        +createJpgReader(int quality) ImageReader
    }

    class BmpReaderFactory {
        +createImageReader() ImageReader
        +getSupportedFormat() String
    }

    class ImageProcessor {
        +main(String[] args) void
        -createFactories() List~ImageReaderFactory~
        -demonstrateBasicFactoryMethod(List~ImageReaderFactory~) void
        -findSuitableFactory(List~ImageReaderFactory~, String) ImageReaderFactory
    }

    ImageReader <|.. PngReader
    ImageReader <|.. GifReader
    ImageReader <|.. JpgReader
    ImageReader <|.. BmpReader
    ImageReaderFactory <|.. PngReaderFactory
    ImageReaderFactory <|.. GifReaderFactory
    ImageReaderFactory <|.. JpgReaderFactory
    ImageReaderFactory <|.. BmpReaderFactory
    ImageReaderFactory ..> ImageReader : creates
    PngReaderFactory ..> PngReader : creates
    GifReaderFactory ..> GifReader : creates
    JpgReaderFactory ..> JpgReader : creates
    BmpReaderFactory ..> BmpReader : creates
    ImageProcessor ..> ImageReaderFactory : uses
    ImageProcessor ..> ImageReader : uses
```

---

## 3. 抽象工厂模式 (Abstract Factory)

定义一个用于创建对象的接口，让子类决定实例化哪一个类。工厂方法使一个类的实例化延迟到其子类。

### 类图

```mermaid
classDiagram
    class ControllerFactory {
        <<interface>>
        +createOperationController() OperationController
        +createInterfaceController() InterfaceController
    }

    class OperationController {
        <<interface>>
        +init() void
        +handleOperation() void
        +getType() String
    }

    class InterfaceController {
        <<interface>>
        +init() void
        +displayInterface() void
        +getType() String
    }

    class AndroidControllerFactory {
        +createOperationController() OperationController
        +createInterfaceController() InterfaceController
    }

    class iOSControllerFactory {
        +createOperationController() OperationController
        +createInterfaceController() InterfaceController
    }

    class AndroidOperationController {
        +init() void
        +handleOperation() void
        +getType() String
    }

    class AndroidInterfaceController {
        +init() void
        +displayInterface() void
        +getType() String
    }

    class iOSOperationController {
        +init() void
        +handleOperation() void
        +getType() String
    }

    class iOSInterfaceController {
        +init() void
        +displayInterface() void
        +getType() String
    }

    class GameClient {
        -ControllerFactory factory
        -OperationController operationController
        -InterfaceController interfaceController
        +GameClient(ControllerFactory factory)
        +runGame() void
    }

    ControllerFactory <|.. AndroidControllerFactory
    ControllerFactory <|.. iOSControllerFactory
    OperationController <|.. AndroidOperationController
    OperationController <|.. iOSOperationController
    InterfaceController <|.. AndroidInterfaceController
    InterfaceController <|.. iOSInterfaceController
    ControllerFactory ..> OperationController : creates
    ControllerFactory ..> InterfaceController : creates
    AndroidControllerFactory ..> AndroidOperationController : creates
    AndroidControllerFactory ..> AndroidInterfaceController : creates
    iOSControllerFactory ..> iOSOperationController : creates
    iOSControllerFactory ..> iOSInterfaceController : creates
    GameClient --> ControllerFactory : uses
```

---

## 4. 原型模式 (Prototype)

用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。

### 类图

```mermaid
classDiagram
    class Customer {
        <<Cloneable>>
        <<Serializable>>
        -String name
        -int age
        -String phone
        -Address address
        +Customer()
        +Customer(String name, int age, String phone, Address address)
        +clone() Customer
        +deepClone() Customer
        +deepCloneBySerialization() Customer
        +getName() String
        +setName(String name) void
        +getAge() int
        +setAge(int age) void
        +getPhone() String
        +setPhone(String phone) void
        +getAddress() Address
        +setAddress(Address address) void
        +toString() String
        +contentEquals(Customer other) boolean
    }

    class Address {
        <<Cloneable>>
        <<Serializable>>
        -String province
        -String city
        -String street
        -String zipCode
        +Address()
        +Address(String province, String city, String street, String zipCode)
        +clone() Address
        +getProvince() String
        +setProvince(String province) void
        +getCity() String
        +setCity(String city) void
        +getStreet() String
        +setStreet(String street) void
        +getZipCode() String
        +setZipCode(String zipCode) void
        +toString() String
        +equals(Object obj) boolean
    }

    class PrototypeClient {
        +main(String[] args) void
        -demonstrateShallowClone() void
        -demonstrateDeepClone() void
        -demonstrateDeepCloneBySerialization() void
    }

    Customer --> Address : contains
    PrototypeClient ..> Customer : uses
```

---

## 5. 建造者模式 (Builder)

将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。

### 类图

```mermaid
classDiagram
    class VideoPlayerBuilder {
        <<interface>>
        +buildMenu() void
        +buildPlayList() void
        +buildMainWindow() void
        +buildControlBar() void
        +buildFavoriteList() void
        +buildStatusBar() void
        +getVideoPlayer() VideoPlayer
        +reset() void
    }

    class VideoPlayer {
        -Menu menu
        -PlayList playList
        -MainWindow mainWindow
        -ControlBar controlBar
        -FavoriteList favoriteList
        -StatusBar statusBar
        +setMenu(Menu menu) void
        +setPlayList(PlayList playList) void
        +setMainWindow(MainWindow mainWindow) void
        +setControlBar(ControlBar controlBar) void
        +setFavoriteList(FavoriteList favoriteList) void
        +setStatusBar(StatusBar statusBar) void
        +display() void
    }

    class VideoPlayerDirector {
        -VideoPlayerBuilder builder
        +VideoPlayerDirector(VideoPlayerBuilder builder)
        +construct() void
        +setBuilder(VideoPlayerBuilder builder) void
    }

    class SimpleModeBuilder {
        +buildMenu() void
        +buildPlayList() void
        +buildMainWindow() void
        +buildControlBar() void
        +buildFavoriteList() void
        +buildStatusBar() void
        +getVideoPlayer() VideoPlayer
        +reset() void
    }

    class FullModeBuilder {
        +buildMenu() void
        +buildPlayList() void
        +buildMainWindow() void
        +buildControlBar() void
        +buildFavoriteList() void
        +buildStatusBar() void
        +getVideoPlayer() VideoPlayer
        +reset() void
    }

    class MemoryModeBuilder {
        +buildMenu() void
        +buildPlayList() void
        +buildMainWindow() void
        +buildControlBar() void
        +buildFavoriteList() void
        +buildStatusBar() void
        +getVideoPlayer() VideoPlayer
        +reset() void
    }

    class NetworkModeBuilder {
        +buildMenu() void
        +buildPlayList() void
        +buildMainWindow() void
        +buildControlBar() void
        +buildFavoriteList() void
        +buildStatusBar() void
        +getVideoPlayer() VideoPlayer
        +reset() void
    }

    class Menu {
        +display() void
    }

    class PlayList {
        +display() void
    }

    class MainWindow {
        +display() void
    }

    class ControlBar {
        +display() void
    }

    class FavoriteList {
        +display() void
    }

    class StatusBar {
        +display() void
    }

    class BuilderClient {
        +main(String[] args) void
    }

    VideoPlayerBuilder <|.. SimpleModeBuilder
    VideoPlayerBuilder <|.. FullModeBuilder
    VideoPlayerBuilder <|.. MemoryModeBuilder
    VideoPlayerBuilder <|.. NetworkModeBuilder
    VideoPlayerBuilder ..> VideoPlayer : builds
    VideoPlayerBuilder ..> Menu : creates
    VideoPlayerBuilder ..> PlayList : creates
    VideoPlayerBuilder ..> MainWindow : creates
    VideoPlayerBuilder ..> ControlBar : creates
    VideoPlayerBuilder ..> FavoriteList : creates
    VideoPlayerBuilder ..> StatusBar : creates
    VideoPlayer *-- Menu : contains
    VideoPlayer *-- PlayList : contains
    VideoPlayer *-- MainWindow : contains
    VideoPlayer *-- ControlBar : contains
    VideoPlayer *-- FavoriteList : contains
    VideoPlayer *-- StatusBar : contains
    VideoPlayerDirector --> VideoPlayerBuilder : uses
    BuilderClient ..> VideoPlayerDirector : uses
    BuilderClient ..> VideoPlayerBuilder : uses
```

---

## 6. 适配器模式 (Adapter)

### 类图 - 对象适配器

```mermaid
classDiagram
    class Encryptor {
        <<interface>> <<target>>
        +encrypt(String data) String
        +decrypt(String encryptedData) String
    }

    class AESEncryptor {
        <<adaptee>>
        -String secretKey
        +AESEncryptor(String secretKey)
        +aesEncode(String plaintext) String
        +aesDecode(String ciphertext) String
        +getKeyInfo() String
    }

    class DESEncrypt {
        <<adaptee>>
        -String key
        +DESEncrypt(String key)
        +desEncrypt(String plainText) String
        +desDecrypt(String cipherText) String
    }

    class MD5EncryptUtil {
        <<adaptee>>
        +md5Encrypt(String data) String
    }

    class AESObjectAdapter {
        <<adapter>>
        -AESEncryptor aesEncryptor
        +AESObjectAdapter(String secretKey)
        +encrypt(String data) String
        +decrypt(String encryptedData) String
        +getKeyInfo() String
    }

    class DESObjectAdapter {
        <<adapter>>
        -DESEncrypt desEncrypt
        +DESEncryptAdapter(String key)
        +encrypt(String data) String
        +decrypt(String encryptedData) String
    }

    class MD5ObjectAdapter {
        <<adapter>>
        +encrypt(String data) String
        +decrypt(String encryptedData) String
    }

    class AESClassAdapter {
        <<adapter>>
        +encrypt(String data) String
        +decrypt(String encryptedData) String
    }

    class DESClassAdapter {
        <<adapter>>
        +encrypt(String data) String
        +decrypt(String encryptedData) String
    }

    class DatabaseManager {
        +saveData(String data) void
        +loadData() String
    }

    class AdapterClient {
        +main(String[] args) void
    }

    Encryptor <|.. AESObjectAdapter
    Encryptor <|.. DESObjectAdapter
    Encryptor <|.. MD5ObjectAdapter
    Encryptor <|.. AESClassAdapter
    Encryptor <|.. DESClassAdapter
    AESObjectAdapter o-- AESEncryptor : wraps
    DESObjectAdapter o-- DESEncrypt : wraps
    AESClassAdapter --|> AESEncryptor : extends
    DESClassAdapter --|> DESEncrypt : extends
    DatabaseManager ..> Encryptor : uses
    AdapterClient ..> Encryptor : uses
```

---

## 7. 桥接模式 (Bridge)

### 类图

```mermaid
classDiagram
    class DataConverter {
        <<abstract>> <<abstraction>>
        #Database database
        +DataConverter(Database database)
        +convertData(String tableName) String
        #formatData(String data) String*
        #saveFile(String tableName, String formattedData) String*
    }

    class Database {
        <<interface>> <<implementor>>
        +connect() void
        +getData(String tableName) String
        +disconnect() void
        +getDatabaseType() String
        +getVersion() String
    }

    class TXTConverter {
        #formatData(String data) String
        #saveFile(String tableName, String formattedData) String
    }

    class XMLConverter {
        #formatData(String data) String
        #saveFile(String tableName, String formattedData) String
    }

    class PDFConverter {
        #formatData(String data) String
        #saveFile(String tableName, String formattedData) String
    }

    class MySQLDatabase {
        +connect() void
        +getData(String tableName) String
        +disconnect() void
        +getDatabaseType() String
        +getVersion() String
    }

    class OracleDatabase {
        +connect() void
        +getData(String tableName) String
        +disconnect() void
        +getDatabaseType() String
        +getVersion() String
    }

    class SQLServerDatabase {
        +connect() void
        +getData(String tableName) String
        +disconnect() void
        +getDatabaseType() String
        +getVersion() String
    }

    class BridgeClient {
        +main(String[] args) void
    }

    Database <|.. MySQLDatabase
    Database <|.. OracleDatabase
    Database <|.. SQLServerDatabase
    DataConverter <|-- TXTConverter
    DataConverter <|-- XMLConverter
    DataConverter <|-- PDFConverter
    DataConverter o-- Database : bridge
    BridgeClient ..> DataConverter : uses
```

---

## 8. 组合模式 (Composite)

### 类图

```mermaid
classDiagram
    class Component {
        <<abstract>> <<component>>
        #String name
        +Component(String name)
        +add(Component component) void
        +remove(Component component) void
        +getChild(int index) Component
        +getChildren() List~Component~
        +display() void*
        +getName() String
        +setName(String name) void
    }

    class Panel {
        <<composite>> <<container>>
        -List~Component~ children
        -String layout
        -String backgroundColor
        +Panel(String name)
        +Panel(String name, String layout)
        +add(Component component) void
        +remove(Component component) void
        +getChild(int index) Component
        +getChildren() List~Component~
        +display() void
        +clear() void
        +getChildCount() int
    }

    class Window {
        <<composite>> <<container>>
        -List~Component~ children
        -String title
        -boolean resizable
        +Window(String title)
        +add(Component component) void
        +remove(Component component) void
        +getChild(int index) Component
        +getChildren() List~Component~
        +display() void
    }

    class Button {
        <<leaf>>
        -String label
        -String color
        +Button(String name, String label)
        +display() void
        +click() void
    }

    class Label {
        <<leaf>>
        -String text
        -String fontSize
        +Label(String name, String text)
        +display() void
    }

    class TextBox {
        <<leaf>>
        -String placeholder
        -int maxLength
        +TextBox(String name, String placeholder)
        +display() void
    }

    class CheckBox {
        <<leaf>>
        -boolean checked
        +CheckBox(String name, String label)
        +display() void
        +toggle() void
    }

    class CompositeClient {
        +main(String[] args) void
    }

    Component <|-- Panel
    Component <|-- Window
    Component <|-- Button
    Component <|-- Label
    Component <|-- TextBox
    Component <|-- CheckBox
    Panel o-- Component : contains
    Window o-- Component : contains
    CompositeClient ..> Component : uses
```

---

## 9. 装饰模式 (Decorator)

### 类图

```mermaid
classDiagram
    class Cipher {
        <<interface>> <<component>>
        +encrypt(String plainText) String
        +getDescription() String
    }

    class SimpleShiftCipher {
        <<concrete component>>
        +encrypt(String plainText) String
        +getDescription() String
    }

    class CipherDecorator {
        <<abstract>> <<decorator>>
        #Cipher decoratedCipher
        +CipherDecorator(Cipher cipher)
        +encrypt(String plainText) String
        +getDescription() String
    }

    class ReverseCipher {
        <<concrete decorator>>
        +ReverseCipher(Cipher cipher)
        +encrypt(String plainText) String
        +getDescription() String
    }

    class ModulusCipher {
        <<concrete decorator>>
        +ModulusCipher(Cipher cipher)
        +encrypt(String plainText) String
        +getDescription() String
    }

    class DecoratorClient {
        +main(String[] args) void
    }

    Cipher <|.. SimpleShiftCipher
    Cipher <|.. CipherDecorator
    CipherDecorator <|-- ReverseCipher
    CipherDecorator <|-- ModulusCipher
    CipherDecorator o-- Cipher : decorates
    DecoratorClient ..> Cipher : uses
```

---

## 10. 外观模式 (Facade)

### 类图

```mermaid
classDiagram
    class BackupFacade {
        <<facade>>
        -ContactManager contactManager
        -MessageManager messageManager
        -PhotoManager photoManager
        -MusicManager musicManager
        -StorageMedia storageMedia
        +BackupFacade(StorageMedia storageMedia)
        +oneClickBackup() BackupResult
        +backupContacts() boolean
        +backupMessages() boolean
        +backupPhotos() boolean
        +backupMusic() boolean
        +selectiveBackup(boolean, boolean, boolean, boolean) BackupResult
        +getDataStatistics() DataStatistics
    }

    class ContactManager {
        <<subsystem>>
        +readContacts() List~Contact~
        +backupContacts(List~Contact~, String) boolean
        +getContactCount() int
    }

    class MessageManager {
        <<subsystem>>
        +readMessages() List~Message~
        +backupMessages(List~Message~, String) boolean
        +getMessageCount() int
    }

    class PhotoManager {
        <<subsystem>>
        +readPhotos() List~Photo~
        +backupPhotos(List~Photo~, String) boolean
        +getPhotoCount() int
        +getTotalSize() long
    }

    class MusicManager {
        <<subsystem>>
        +readSongs() List~Song~
        +backupSongs(List~Song~, String) boolean
        +getSongCount() int
        +getTotalSize() long
        +getTotalDuration() int
    }

    class StorageMedia {
        <<subsystem>>
        +connect() boolean
        +disconnect() void
        +getBackupPath(String type) String
        +getStorageInfo() String
    }

    class BackupResult {
        <<inner class>>
        -boolean success
        -boolean contactsBackedUp
        -boolean messagesBackedUp
        -boolean photosBackedUp
        -boolean musicBackedUp
        -String errorMessage
        +isSuccess() boolean
        +setSuccess(boolean success) void
    }

    class DataStatistics {
        <<inner class>>
        -int contactCount
        -int messageCount
        -int photoCount
        -int songCount
        -long photoSize
        -long musicSize
        -int musicDuration
    }

    class FacadeClient {
        +main(String[] args) void
    }

    BackupFacade --> ContactManager : uses
    BackupFacade --> MessageManager : uses
    BackupFacade --> PhotoManager : uses
    BackupFacade --> MusicManager : uses
    BackupFacade --> StorageMedia : uses
    BackupResult --|> BackupFacade : inner class
    DataStatistics --|> BackupFacade : inner class
    FacadeClient ..> BackupFacade : uses
```

---

## 11. 享元模式 (Flyweight)

### 类图

```mermaid
classDiagram
    class MultimediaElement {
        <<interface>> <<flyweight>>
        +display(ElementState externalState) void
        +getType() String
        +getId() String
        +getFilePath() String
        +getFileSize() long
        +getInternalStateInfo() String
    }

    class AbstractMultimediaElement {
        <<abstract>> <<flyweight>>
        #String id
        #String filePath
        #long fileSize
        +AbstractMultimediaElement(String id, String filePath)
        +getId() String
        +getFilePath() String
        +getFileSize() long
        -loadFileSize() void
    }

    class ImageElement {
        <<concrete flyweight>>
        -int width
        -int height
        -String format
        +ImageElement(String id, String filePath)
        +display(ElementState externalState) void
        +getType() String
        +getInternalStateInfo() String
    }

    class AnimationElement {
        <<concrete flyweight>>
        -int frameCount
        -double frameRate
        +AnimationElement(String id, String filePath)
        +display(ElementState externalState) void
        +getType() String
        +getInternalStateInfo() String
    }

    class VideoElement {
        <<concrete flyweight>>
        -int duration
        -String resolution
        +VideoElement(String id, String filePath)
        +display(ElementState externalState) void
        +getType() String
        +getInternalStateInfo() String
    }

    class MultimediaFactory {
        <<flyweight factory>>
        -Map~String, MultimediaElement~ elementPool
        -int totalCreated
        -int totalRequested
        +MultimediaFactory()
        +getElement(String id, String filePath, ElementType type) MultimediaElement
        +removeElement(String id) boolean
        +clear() void
        +getPoolSize() int
        +getStatistics() String
        +displayPoolContents() void
        -createElement(String id, String filePath, ElementType type) MultimediaElement
    }

    class ElementState {
        <<external state>>
        -int x
        -int y
        -int width
        -int height
        -int zIndex
        -double opacity
        -double rotation
        -String caption
        -String borderStyle
        +ElementState(int x, int y, int width, int height)
        +getPositionInfo() String
        +getSizeInfo() String
        +getFullInfo() String
        +clone() ElementState
    }

    class FlyweightClient {
        +main(String[] args) void
    }

    MultimediaElement <|.. AbstractMultimediaElement
    AbstractMultimediaElement <|-- ImageElement
    AbstractMultimediaElement <|-- AnimationElement
    AbstractMultimediaElement <|-- VideoElement
    MultimediaFactory o-- MultimediaElement : manages pool
    MultimediaFactory ..> ImageElement : creates
    MultimediaFactory ..> AnimationElement : creates
    MultimediaFactory ..> VideoElement : creates
    FlyweightClient ..> MultimediaFactory : uses
    FlyweightClient ..> ElementState : uses
```

---

## 附录：设计模式分类

### 创建型模式 (Creational Patterns)
1. 简单工厂模式 (Simple Factory)
2. 工厂方法模式 (Factory Method)
3. 抽象工厂模式 (Abstract Factory)
4. 原型模式 (Prototype)
5. 建造者模式 (Builder)

### 结构型模式 (Structural Patterns)
6. 适配器模式 (Adapter)
7. 桥接模式 (Bridge)
8. 组合模式 (Composite)
9. 装饰模式 (Decorator)
10. 外观模式 (Facade)

### 行为型模式 (Behavioral Patterns)
11. 享元模式 (Flyweight)

---

*本文档由 Mermaid 语法生成，支持在 GitHub、GitLab 等平台直接渲染。*
