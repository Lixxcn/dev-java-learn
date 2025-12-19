package cn.lixx.designpatterns.builder.builder;

import cn.lixx.designpatterns.builder.component.*;
import cn.lixx.designpatterns.builder.product.VideoPlayer;

/**
 * 记忆模式建造者
 */
public class MemoryModeBuilder implements VideoPlayerBuilder {
    private VideoPlayer videoPlayer;

    public MemoryModeBuilder() {
        reset();
    }

    @Override
    public void reset() {
        videoPlayer = new VideoPlayer();
    }

    @Override
    public void buildMenu() {
        // 记忆模式显示精简菜单
        videoPlayer.setMenu(new Menu("记忆模式"));
    }

    @Override
    public void buildPlayList() {
        // 记忆模式不显示完整播放列表
    }

    @Override
    public void buildMainWindow() {
        videoPlayer.setMainWindow(new MainWindow("Sunny视频播放器 - 记忆模式", 1000, 700));
    }

    @Override
    public void buildControlBar() {
        videoPlayer.setControlBar(new ControlBar("记忆增强"));
    }

    @Override
    public void buildFavoriteList() {
        // 记忆模式显示收藏列表
        videoPlayer.setFavoriteList(new FavoriteList("最近播放", 20));
    }

    @Override
    public void buildStatusBar() {
        // 记忆模式显示状态栏，记忆用户偏好
        videoPlayer.setStatusBar(new StatusBar("记忆用户偏好设置"));
    }

    @Override
    public VideoPlayer getVideoPlayer() {
        VideoPlayer result = videoPlayer;
        reset();
        return result;
    }
}