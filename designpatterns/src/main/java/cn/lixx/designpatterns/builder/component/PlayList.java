package cn.lixx.designpatterns.builder.component;

/**
 * 播放列表组件
 */
public class PlayList {
    private String name;  // 播放列表名称
    private int count;    // 视频数量

    public PlayList(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public void display() {
        System.out.println("  📺 显示" + name + " (" + count + "个视频)");
        System.out.println("     ├─ 1. 电影片段.mp4");
        System.out.println("     ├─ 2. 音乐视频.mp4");
        System.out.println("     ├─ 3. 教学视频.mp4");
        System.out.println("     └─ " + count + ". 更多...");
    }

    @Override
    public String toString() {
        return name + "(" + count + "个视频)";
    }
}