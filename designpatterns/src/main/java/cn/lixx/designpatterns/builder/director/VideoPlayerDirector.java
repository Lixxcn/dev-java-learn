package cn.lixx.designpatterns.builder.director;

import cn.lixx.designpatterns.builder.builder.VideoPlayerBuilder;
import cn.lixx.designpatterns.builder.product.VideoPlayer;

/**
 * 指挥者类
 * 负责控制建造流程
 */
public class VideoPlayerDirector {
    private VideoPlayerBuilder builder;

    public VideoPlayerDirector(VideoPlayerBuilder builder) {
        this.builder = builder;
    }

    /**
     * 构建完整视频播放器
     */
    public VideoPlayer constructFullPlayer() {
        builder.reset();
        builder.buildMenu();
        builder.buildPlayList();
        builder.buildMainWindow();
        builder.buildControlBar();
        builder.buildFavoriteList();
        builder.buildStatusBar();
        return builder.getVideoPlayer();
    }

    /**
     * 构建精简视频播放器
     */
    public VideoPlayer constructSimplePlayer() {
        builder.reset();
        builder.buildMainWindow();
        builder.buildControlBar();
        return builder.getVideoPlayer();
    }

    /**
     * 构建记忆模式视频播放器
     */
    public VideoPlayer constructMemoryPlayer() {
        builder.reset();
        builder.buildMenu();
        builder.buildMainWindow();
        builder.buildControlBar();
        builder.buildFavoriteList();
        builder.buildStatusBar();
        return builder.getVideoPlayer();
    }

    /**
     * 构建网络模式视频播放器
     */
    public VideoPlayer constructNetworkPlayer() {
        builder.reset();
        builder.buildMenu();
        builder.buildPlayList();
        builder.buildMainWindow();
        builder.buildControlBar();
        builder.buildFavoriteList();
        builder.buildStatusBar();
        return builder.getVideoPlayer();
    }

    /**
     * 自定义构建模式
     */
    public VideoPlayer constructCustomPlayer(boolean withMenu, boolean withPlayList,
                                            boolean withMainWindow, boolean withControlBar,
                                            boolean withFavoriteList, boolean withStatusBar) {
        builder.reset();
        if (withMenu) builder.buildMenu();
        if (withPlayList) builder.buildPlayList();
        if (withMainWindow) builder.buildMainWindow();
        if (withControlBar) builder.buildControlBar();
        if (withFavoriteList) builder.buildFavoriteList();
        if (withStatusBar) builder.buildStatusBar();
        return builder.getVideoPlayer();
    }

    /**
     * 更换建造者
     */
    public void setBuilder(VideoPlayerBuilder builder) {
        this.builder = builder;
    }
}