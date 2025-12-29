package cn.lixx.designpatterns.facade.subsystem;

import java.util.ArrayList;
import java.util.List;

/**
 * 音乐管理类（子系统）
 * 负责音乐文件的读取和备份
 */
public class MusicManager {
    private List<Song> songs;

    public MusicManager() {
        this.songs = new ArrayList<>();
        initSampleSongs();
    }

    /**
     * 初始化示例音乐数据
     */
    private void initSampleSongs() {
        songs.add(new Song("夜曲", "周杰伦", "七里香", (int)(4.5 * 60), (long)(4.2 * 1024 * 1024)));
        songs.add(new Song("稻香", "周杰伦", "魔杰座", (int)(3.8 * 60), (long)(3.5 * 1024 * 1024)));
        songs.add(new Song("告白气球", "周杰伦", "周杰伦的床边故事", (int)(3.3 * 60), (long)(3.1 * 1024 * 1024)));
        songs.add(new Song("演员", "薛之谦", "意外", (int)(4.2 * 60), (long)(3.9 * 1024 * 1024)));
        songs.add(new Song("体面", "于文文", "体面", (int)(4.0 * 60), (long)(3.7 * 1024 * 1024)));
        songs.add(new Song("起风了", "买辣椒也用券", "起风了", (int)(5.2 * 60), (long)(4.8 * 1024 * 1024)));
    }

    /**
     * 读取音乐
     * @return 音乐列表
     */
    public List<Song> readSongs() {
        System.out.println("正在扫描手机音乐...");
        simulateDelay(800);
        System.out.println("成功扫描 " + songs.size() + " 首歌曲");
        return new ArrayList<>(songs);
    }

    /**
     * 备份音乐到指定路径
     * @param songs 歌曲列表
     * @param path 备份路径
     * @return 是否成功
     */
    public boolean backupSongs(List<Song> songs, String path) {
        if (songs == null || songs.isEmpty()) {
            System.out.println("音乐为空，无需备份");
            return false;
        }

        System.out.println("正在备份音乐到: " + path);
        long totalSize = songs.stream().mapToLong(Song::getSize).sum();
        int totalDuration = songs.stream().mapToInt(Song::getDuration).sum();

        System.out.println("总大小: " + formatSize(totalSize));
        System.out.println("总时长: " + formatDuration(totalDuration));

        simulateDelay(1500);
        System.out.println("音乐备份完成！共备份 " + songs.size() + " 首歌曲");
        return true;
    }

    /**
     * 获取歌曲数量
     * @return 数量
     */
    public int getSongCount() {
        return songs.size();
    }

    /**
     * 获取音乐总大小
     * @return 总大小（字节）
     */
    public long getTotalSize() {
        return songs.stream().mapToLong(Song::getSize).sum();
    }

    /**
     * 获取音乐总时长
     * @return 总时长（秒）
     */
    public int getTotalDuration() {
        return songs.stream().mapToInt(Song::getDuration).sum();
    }

    /**
     * 格式化文件大小
     * @param size 字节
     * @return 格式化后的字符串
     */
    private String formatSize(long size) {
        if (size < 1024) {
            return size + " B";
        } else if (size < 1024 * 1024) {
            return String.format("%.2f KB", size / 1024.0);
        } else if (size < 1024 * 1024 * 1024) {
            return String.format("%.2f MB", size / (1024.0 * 1024));
        } else {
            return String.format("%.2f GB", size / (1024.0 * 1024 * 1024));
        }
    }

    /**
     * 格式化时长
     * @param seconds 秒
     * @return 格式化后的字符串
     */
    private String formatDuration(int seconds) {
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int secs = seconds % 60;

        if (hours > 0) {
            return String.format("%d:%02d:%02d", hours, minutes, secs);
        } else {
            return String.format("%d:%02d", minutes, secs);
        }
    }

    /**
     * 模拟延迟
     * @param ms 毫秒
     */
    private void simulateDelay(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * 歌曲类
     */
    public static class Song {
        private String title;
        private String artist;
        private String album;
        private int duration; // 秒
        private long size; // 字节

        public Song(String title, String artist, String album, int duration, long size) {
            this.title = title;
            this.artist = artist;
            this.album = album;
            this.duration = duration;
            this.size = size;
        }

        public String getTitle() {
            return title;
        }

        public String getArtist() {
            return artist;
        }

        public String getAlbum() {
            return album;
        }

        public int getDuration() {
            return duration;
        }

        public long getSize() {
            return size;
        }

        @Override
        public String toString() {
            return title + " - " + artist;
        }
    }
}