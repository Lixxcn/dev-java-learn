package cn.lixx.designpatterns.builder.builder;

import cn.lixx.designpatterns.builder.product.VideoPlayer;

/**
 * 抽象建造者接口
 */
public interface VideoPlayerBuilder {
    /**
     * 构建菜单
     */
    void buildMenu();

    /**
     * 构建播放列表
     */
    void buildPlayList();

    /**
     * 构建主窗口
     */
    void buildMainWindow();

    /**
     * 构建控制条
     */
    void buildControlBar();

    /**
     * 构建收藏列表
     */
    void buildFavoriteList();

    /**
     * 构建状态栏
     */
    void buildStatusBar();

    /**
     * 返回构建的视频播放器对象
     * @return 视频播放器实例
     */
    VideoPlayer getVideoPlayer();

    /**
     * 重置建造者，准备新的构建
     */
    void reset();
}