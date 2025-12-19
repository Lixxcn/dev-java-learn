package cn.lixx.designpatterns.builder.product;

import cn.lixx.designpatterns.builder.component.*;

/**
 * 视频播放器产品类
 */
public class VideoPlayer {
    private Menu menu;               // 菜单
    private PlayList playList;       // 播放列表
    private MainWindow mainWindow;   // 主窗口
    private ControlBar controlBar;   // 控制条
    private FavoriteList favoriteList; // 收藏列表
    private StatusBar statusBar;     // 状态栏

    public VideoPlayer() {
    }

    // Setter方法 - 供Builder使用
    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void setPlayList(PlayList playList) {
        this.playList = playList;
    }

    public void setMainWindow(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    public void setControlBar(ControlBar controlBar) {
        this.controlBar = controlBar;
    }

    public void setFavoriteList(FavoriteList favoriteList) {
        this.favoriteList = favoriteList;
    }

    public void setStatusBar(StatusBar statusBar) {
        this.statusBar = statusBar;
    }

    // 显示视频播放器界面
    public void display() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("🎬 视频播放器界面");
        System.out.println("=".repeat(50));

        // 按照显示顺序展示各个组件
        if (menu != null) {
            menu.display();
        }
        if (playList != null) {
            playList.display();
        }
        if (mainWindow != null) {
            mainWindow.display();
        }
        if (controlBar != null) {
            controlBar.display();
        }
        if (favoriteList != null) {
            favoriteList.display();
        }
        if (statusBar != null) {
            statusBar.display();
        }

        System.out.println("=".repeat(50));
        System.out.println("界面组件列表:");
        System.out.println("  - " + (menu != null ? menu.toString() : "无菜单"));
        System.out.println("  - " + (playList != null ? playList.toString() : "无播放列表"));
        System.out.println("  - " + (mainWindow != null ? mainWindow.toString() : "无主窗口"));
        System.out.println("  - " + (controlBar != null ? controlBar.toString() : "无控制条"));
        System.out.println("  - " + (favoriteList != null ? favoriteList.toString() : "无收藏列表"));
        System.out.println("  - " + (statusBar != null ? statusBar.toString() : "无状态栏"));
        System.out.println("=".repeat(50));
    }
}