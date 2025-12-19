package cn.lixx.designpatterns.abstractfactory;

import cn.lixx.designpatterns.abstractfactory.factory.ControllerFactory;
import cn.lixx.designpatterns.abstractfactory.factory.AndroidControllerFactory;
import cn.lixx.designpatterns.abstractfactory.factory.iOSControllerFactory;
import cn.lixx.designpatterns.abstractfactory.controller.InterfaceController;
import cn.lixx.designpatterns.abstractfactory.controller.OperationController;

/**
 * 游戏客户端（客户端类）
 */
public class GameClient {
    private ControllerFactory factory;
    private OperationController operationController;
    private InterfaceController interfaceController;

    public GameClient(ControllerFactory factory) {
        this.factory = factory;
        this.operationController = factory.createOperationController();
        this.interfaceController = factory.createInterfaceController();
    }

    /**
     * 运行游戏
     */
    public void runGame() {
        System.out.println("========== 启动游戏 ==========");

        System.out.println("\n1. 初始化控制器:");
        operationController.init();
        interfaceController.init();

        System.out.println("\n2. 显示游戏界面:");
        interfaceController.displayInterface();

        System.out.println("\n3. 处理游戏操作:");
        operationController.handleOperation();

        System.out.println("\n4. 当前平台信息:");
        System.out.println("操作控制器平台: " + operationController.getType());
        System.out.println("界面控制器平台: " + interfaceController.getType());

        System.out.println("========== 游戏运行结束 ==========\n");
    }

    public static void main(String[] args) {
        System.out.println("🎮 Sunny软件公司手机游戏演示");
        System.out.println("=====================================\n");

        // iOS平台游戏
        System.out.println("📱 iOS平台游戏:");
        ControllerFactory iOSFactory = new iOSControllerFactory();
        GameClient iOSGame = new GameClient(iOSFactory);
        iOSGame.runGame();

        // Android平台游戏
        System.out.println("🤖 Android平台游戏:");
        ControllerFactory androidFactory = new AndroidControllerFactory();
        GameClient androidGame = new GameClient(androidFactory);
        androidGame.runGame();

        System.out.println("✨ 抽象工厂模式优势:");
        System.out.println("1. 保证了产品族的一致性 - iOS的控制器都是iOS风格");
        System.out.println("2. 易于扩展新平台 - 只需添加新的工厂和产品类");
        System.out.println("3. 符合开闭原则 - 不需修改已有代码");
        System.out.println("4. 将产品创建细节与客户端分离");
    }
}