# 虚拟代理模式 (Virtual Proxy) - 网络图片查看器

## 模式简介
虚拟代理 (Virtual Proxy) 是代理模式的一种，用于创建开销很大的对象。它会把对象的创建延迟到真正需要使用它的时候。在加载完成之前，代理对象可以充当占位符。

## 场景描述
Sunny软件公司欲开发一款基于C/S的网络图片查看器。
- 输入网页URL，下载所有图片。
- 先显示小图标（占位符）。
- 单击图标后，后台线程下载并显示原图。

## 实现方案
1.  **ImageProxy (代理类)**: 实现 `Icon` 接口。
    - 维护一个状态（未加载、加载中、已加载）。
    - `paintIcon` 方法中：
        - 若未加载：绘制文件类型图标（如显示 "JPG", "PNG" 字样）。
        - 若加载中：显示 "Loading..."。
        - 若已加载：调用真实 `ImageIcon` 进行绘制。
    - `loadRealImage` 方法：启动后台线程下载图片。

2.  **VirtualProxyClient (客户端)**: Swing 应用程序。
    - 模拟网页解析，生成包含 Proxy 的列表。
    - 为每个 Proxy 绑定点击事件，点击触发 `loadRealImage`。

## 类图结构
- **Subject**: `javax.swing.Icon`
- **Proxy**: `ImageProxy`
- **RealSubject**: `javax.swing.ImageIcon` (Java原生)
- **Client**: `VirtualProxyClient`

## 关键代码
```java
// 代理逻辑
public void paintIcon(Component c, Graphics g, int x, int y) {
    if (realIcon != null) {
         realIcon.paintIcon(c, g, x, y);
    } else {
         // 绘制占位符
         g.drawString("Loading/Icon", ...);
    }
}

// 多线程加载
new Thread(() -> {
    URL url = new URL(imageUrl);
    realIcon = new ImageIcon(url);
    c.repaint();
}).start();
```
