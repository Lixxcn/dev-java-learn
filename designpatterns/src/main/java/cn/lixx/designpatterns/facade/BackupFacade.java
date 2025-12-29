package cn.lixx.designpatterns.facade;

import java.util.List;

import cn.lixx.designpatterns.facade.subsystem.ContactManager;
import cn.lixx.designpatterns.facade.subsystem.MessageManager;
import cn.lixx.designpatterns.facade.subsystem.MusicManager;
import cn.lixx.designpatterns.facade.subsystem.PhotoManager;
import cn.lixx.designpatterns.facade.subsystem.StorageMedia;

/**
 * 备份外观类（外观）
 * 为一键备份功能提供统一接口
 * 屏蔽了子系统的复杂性，降低了客户端与子系统的耦合度
 */
public class BackupFacade {
    // 持有对各个子系统的引用
    private ContactManager contactManager;
    private MessageManager messageManager;
    private PhotoManager photoManager;
    private MusicManager musicManager;
    private StorageMedia storageMedia;

    /**
     * 构造函数，初始化所有子系统
     * 
     * @param storageMedia 存储介质
     */
    public BackupFacade(StorageMedia storageMedia) {
        this.contactManager = new ContactManager();
        this.messageManager = new MessageManager();
        this.photoManager = new PhotoManager();
        this.musicManager = new MusicManager();
        this.storageMedia = storageMedia;
    }

    /**
     * 一键备份所有数据（核心方法）
     * 这是外观模式的关键方法，为复杂的子系统操作提供简单接口
     * 
     * @return 备份结果
     */
    public BackupResult oneClickBackup() {
        System.out.println("\n╔════════════════════════════════════════════════════╗");
        System.out.println("║          一键备份功能启动                          ║");
        System.out.println("╚════════════════════════════════════════════════════╝\n");

        BackupResult result = new BackupResult();

        // 1. 连接存储介质
        if (!storageMedia.connect()) {
            result.setSuccess(false);
            result.setErrorMessage("存储介质连接失败");
            return result;
        }

        System.out.println("\n" + storageMedia.getStorageInfo());
        System.out.println("----------------------------------------");

        try {
            // 2. 备份通讯录
            System.out.println("\n【1/4】备份通讯录");
            boolean contactBackup = backupContacts();
            result.setContactsBackedUp(contactBackup);

            // 3. 备份短信
            System.out.println("\n【2/4】备份短信");
            boolean messageBackup = backupMessages();
            result.setMessagesBackedUp(messageBackup);

            // 4. 备份照片
            System.out.println("\n【3/4】备份照片");
            boolean photoBackup = backupPhotos();
            result.setPhotosBackedUp(photoBackup);

            // 5. 备份音乐
            System.out.println("\n【4/4】备份音乐");
            boolean musicBackup = backupMusic();
            result.setMusicBackedUp(musicBackup);

            // 所有备份完成
            result.setSuccess(true);

            System.out.println("\n========================================");
            System.out.println("备份摘要:");
            System.out.println("- 通讯录: " + (contactBackup ? "✓ 成功" : "✗ 失败"));
            System.out.println("- 短信: " + (messageBackup ? "✓ 成功" : "✗ 失败"));
            System.out.println("- 照片: " + (photoBackup ? "✓ 成功" : "✗ 失败"));
            System.out.println("- 音乐: " + (musicBackup ? "✓ 成功" : "✗ 失败"));
            System.out.println("========================================\n");

        } catch (Exception e) {
            result.setSuccess(false);
            result.setErrorMessage("备份过程中发生错误: " + e.getMessage());
        } finally {
            // 6. 断开存储介质
            storageMedia.disconnect();
        }

        return result;
    }

    /**
     * 备份通讯录
     * 
     * @return 是否成功
     */
    public boolean backupContacts() {
        System.out.println("----------------------------------------");
        List<ContactManager.Contact> contacts = contactManager.readContacts();
        return contactManager.backupContacts(
                contacts,
                storageMedia.getBackupPath("Contacts"));
    }

    /**
     * 备份短信
     * 
     * @return 是否成功
     */
    public boolean backupMessages() {

        System.out.println("----------------------------------------");
        List<MessageManager.Message> messages = messageManager.readMessages();
        return messageManager.backupMessages(
                messages,
                storageMedia.getBackupPath("Messages"));
    }

    /**
     * 备份照片
     * 
     * @return 是否成功
     */
    public boolean backupPhotos() {

        System.out.println("----------------------------------------");
        List<PhotoManager.Photo> photos = photoManager.readPhotos();
        return photoManager.backupPhotos(
                photos,
                storageMedia.getBackupPath("Photos"));
    }

    /**
     * 备份音乐
     * 
     * @return 是否成功
     */
    public boolean backupMusic() {
        System.out.println("----------------------------------------");
        List<MusicManager.Song> songs = musicManager.readSongs();
        return musicManager.backupSongs(
                songs,
                storageMedia.getBackupPath("Music"));
    }

    /**
     * 选择性备份
     * 
     * @param backupContacts 是否备份通讯录
     * @param backupMessages 是否备份短信
     * @param backupPhotos   是否备份照片
     * @param backupMusic    是否备份音乐
     * @return 备份结果
     */
    public BackupResult selectiveBackup(boolean backupContacts, boolean backupMessages,
            boolean backupPhotos, boolean backupMusic) {
        System.out.println("\n╔════════════════════════════════════════════════════╗");
        System.out.println("║          选择性备份功能启动                      ║");
        System.out.println("╚════════════════════════════════════════════════════╝\n");

        BackupResult result = new BackupResult();

        // 连接存储介质
        if (!storageMedia.connect()) {
            result.setSuccess(false);
            result.setErrorMessage("存储介质连接失败");
            return result;
        }

        System.out.println("\n" + storageMedia.getStorageInfo());
        System.out.println("----------------------------------------");

        try {
            int count = 0;
            int total = (backupContacts ? 1 : 0) +
                    (backupMessages ? 1 : 0) +
                    (backupPhotos ? 1 : 0) +
                    (backupMusic ? 1 : 0);

            if (backupContacts) {
                count++;
                System.out.println("\n【" + count + "/" + total + "】备份通讯录");
                result.setContactsBackedUp(backupContacts());
            }

            if (backupMessages) {
                count++;
                System.out.println("\n【" + count + "/" + total + "】备份短信");
                result.setMessagesBackedUp(backupMessages());
            }

            if (backupPhotos) {
                count++;
                System.out.println("\n【" + count + "/" + total + "】备份照片");
                result.setPhotosBackedUp(backupPhotos());
            }

            if (backupMusic) {
                count++;
                System.out.println("\n【" + count + "/" + total + "】备份音乐");
                result.setMusicBackedUp(backupMusic());
            }

            result.setSuccess(true);

        } catch (Exception e) {
            result.setSuccess(false);
            result.setErrorMessage("备份过程中发生错误: " + e.getMessage());
        } finally {
            storageMedia.disconnect();
        }

        return result;
    }

    /**
     * 获取数据统计信息
     * 
     * @return 统计信息
     */
    public DataStatistics getDataStatistics() {
        DataStatistics stats = new DataStatistics();
        stats.setContactCount(contactManager.getContactCount());
        stats.setMessageCount(messageManager.getMessageCount());
        stats.setPhotoCount(photoManager.getPhotoCount());
        stats.setSongCount(musicManager.getSongCount());
        stats.setPhotoSize(photoManager.getTotalSize());
        stats.setMusicSize(musicManager.getTotalSize());
        stats.setMusicDuration(musicManager.getTotalDuration());
        return stats;
    }

    /**
     * 备份结果类
     */
    public static class BackupResult {
        private boolean success;
        private boolean contactsBackedUp;
        private boolean messagesBackedUp;
        private boolean photosBackedUp;
        private boolean musicBackedUp;
        private String errorMessage;

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public boolean isContactsBackedUp() {
            return contactsBackedUp;
        }

        public void setContactsBackedUp(boolean contactsBackedUp) {
            this.contactsBackedUp = contactsBackedUp;
        }

        public boolean isMessagesBackedUp() {
            return messagesBackedUp;
        }

        public void setMessagesBackedUp(boolean messagesBackedUp) {
            this.messagesBackedUp = messagesBackedUp;
        }

        public boolean isPhotosBackedUp() {
            return photosBackedUp;
        }

        public void setPhotosBackedUp(boolean photosBackedUp) {
            this.photosBackedUp = photosBackedUp;
        }

        public boolean isMusicBackedUp() {
            return musicBackedUp;
        }

        public void setMusicBackedUp(boolean musicBackedUp) {
            this.musicBackedUp = musicBackedUp;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("备份结果:\n");
            sb.append("状态: ").append(success ? "成功" : "失败").append("\n");
            sb.append("- 通讯录: ").append(contactsBackedUp ? "✓" : "✗").append("\n");
            sb.append("- 短信: ").append(messagesBackedUp ? "✓" : "✗").append("\n");
            sb.append("- 照片: ").append(photosBackedUp ? "✓" : "✗").append("\n");
            sb.append("- 音乐: ").append(musicBackedUp ? "✓" : "✗");
            if (errorMessage != null) {
                sb.append("\n错误信息: ").append(errorMessage);
            }
            return sb.toString();
        }
    }

    /**
     * 数据统计类
     */
    public static class DataStatistics {
        private int contactCount;
        private int messageCount;
        private int photoCount;
        private int songCount;
        private long photoSize;
        private long musicSize;
        private int musicDuration;

        // Getter和Setter方法
        public int getContactCount() {
            return contactCount;
        }

        public void setContactCount(int contactCount) {
            this.contactCount = contactCount;
        }

        public int getMessageCount() {
            return messageCount;
        }

        public void setMessageCount(int messageCount) {
            this.messageCount = messageCount;
        }

        public int getPhotoCount() {
            return photoCount;
        }

        public void setPhotoCount(int photoCount) {
            this.photoCount = photoCount;
        }

        public int getSongCount() {
            return songCount;
        }

        public void setSongCount(int songCount) {
            this.songCount = songCount;
        }

        public long getPhotoSize() {
            return photoSize;
        }

        public void setPhotoSize(long photoSize) {
            this.photoSize = photoSize;
        }

        public long getMusicSize() {
            return musicSize;
        }

        public void setMusicSize(long musicSize) {
            this.musicSize = musicSize;
        }

        public int getMusicDuration() {
            return musicDuration;
        }

        public void setMusicDuration(int musicDuration) {
            this.musicDuration = musicDuration;
        }

        @Override
        public String toString() {
            return String.format(
                    "数据统计:\n" +
                            "- 通讯录: %d 个联系人\n" +
                            "- 短信: %d 条\n" +
                            "- 照片: %d 张 (%.2f MB)\n" +
                            "- 音乐: %d 首 (%.2f MB, %d分%d秒)",
                    contactCount,
                    messageCount,
                    photoCount,
                    photoSize / (1024.0 * 1024),
                    songCount,
                    musicSize / (1024.0 * 1024),
                    musicDuration / 60,
                    musicDuration % 60);
        }
    }
}