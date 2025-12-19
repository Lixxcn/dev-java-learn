package cn.lixx.designpatterns.builder.builder;

import cn.lixx.designpatterns.builder.component.*;
import cn.lixx.designpatterns.builder.product.VideoPlayer;

/**
 * 精简模式建造者
 */
public class SimpleModeBuilder implements VideoPlayerBuilder {
    private VideoPlayer videoPlayer;

    public SimpleModeBuilder() {
        reset();
    }

    @Override
    public void reset() {
        videoPlayer = new VideoPlayer();
    }

    @Override
    public void buildMenu() {
        // 精简模式不显示菜单
    }

    @Override
    public void buildPlayList() {
        // 精简模式不显示播放列表
    }

    @Override
    public void buildMainWindow() {
        videoPlayer.setMainWindow(new MainWindow("Sunny视频播放器 - 精简模式", 800, 600));
    }

    @Override
    public void buildControlBar() {
        videoPlayer.setControlBar(new ControlBar("精简"));
    }

    @Override
    public void buildFavoriteList() {
        // 精简模式不显示收藏列表
    }

    @Override
    public void buildStatusBar() {
        // 精简模式不显示状态栏
    }

    @Override
    public VideoPlayer getVideoPlayer() {
        VideoPlayer result = videoPlayer;
        reset();
        return result;
    }
}