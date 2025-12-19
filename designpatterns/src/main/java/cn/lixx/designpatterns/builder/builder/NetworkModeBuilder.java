package cn.lixx.designpatterns.builder.builder;

import cn.lixx.designpatterns.builder.component.*;
import cn.lixx.designpatterns.builder.product.VideoPlayer;

/**
 * 网络模式建造者
 */
public class NetworkModeBuilder implements VideoPlayerBuilder {
    private VideoPlayer videoPlayer;

    public NetworkModeBuilder() {
        reset();
    }

    @Override
    public void reset() {
        videoPlayer = new VideoPlayer();
    }

    @Override
    public void buildMenu() {
        videoPlayer.setMenu(new Menu("网络模式"));
    }

    @Override
    public void buildPlayList() {
        // 网络模式显示在线播放列表
        videoPlayer.setPlayList(new PlayList("在线视频", 1000));
    }

    @Override
    public void buildMainWindow() {
        videoPlayer.setMainWindow(new MainWindow("Sunny视频播放器 - 网络模式", 1100, 750));
    }

    @Override
    public void buildControlBar() {
        videoPlayer.setControlBar(new ControlBar("网络优化"));
    }

    @Override
    public void buildFavoriteList() {
        // 网络模式显示网络收藏
        videoPlayer.setFavoriteList(new FavoriteList("云收藏", 200));
    }

    @Override
    public void buildStatusBar() {
        // 网络模式显示网络状态
        videoPlayer.setStatusBar(new StatusBar("网络状态: 在线"));
    }

    @Override
    public VideoPlayer getVideoPlayer() {
        VideoPlayer result = videoPlayer;
        reset();
        return result;
    }
}