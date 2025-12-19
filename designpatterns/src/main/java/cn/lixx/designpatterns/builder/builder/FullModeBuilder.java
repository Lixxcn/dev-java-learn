package cn.lixx.designpatterns.builder.builder;

import cn.lixx.designpatterns.builder.component.*;
import cn.lixx.designpatterns.builder.product.VideoPlayer;

/**
 * 完整模式建造者
 */
public class FullModeBuilder implements VideoPlayerBuilder {
    private VideoPlayer videoPlayer;

    public FullModeBuilder() {
        reset();
    }

    @Override
    public void reset() {
        videoPlayer = new VideoPlayer();
    }

    @Override
    public void buildMenu() {
        videoPlayer.setMenu(new Menu("完整"));
    }

    @Override
    public void buildPlayList() {
        videoPlayer.setPlayList(new PlayList("完整播放列表", 100));
    }

    @Override
    public void buildMainWindow() {
        videoPlayer.setMainWindow(new MainWindow("Sunny视频播放器 - 完整模式", 1200, 800));
    }

    @Override
    public void buildControlBar() {
        videoPlayer.setControlBar(new ControlBar("完整功能"));
    }

    @Override
    public void buildFavoriteList() {
        videoPlayer.setFavoriteList(new FavoriteList("我的收藏", 50));
    }

    @Override
    public void buildStatusBar() {
        videoPlayer.setStatusBar(new StatusBar("显示全部信息"));
    }

    @Override
    public VideoPlayer getVideoPlayer() {
        VideoPlayer result = videoPlayer;
        reset();  // 重置建造者，准备下一次构建
        return result;
    }
}