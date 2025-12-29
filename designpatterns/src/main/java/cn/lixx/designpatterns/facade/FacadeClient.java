package cn.lixx.designpatterns.facade;

import cn.lixx.designpatterns.facade.subsystem.StorageMedia;

/**
 * 外观模式客户端测试类
 * 演示如何使用外观模式实现一键备份功能
 */
public class FacadeClient {

    public static void main(String[] args) {
        System.out.println("======== Sunny软件公司一键备份功能测试 ========\n");

        // 创建存储介质（32GB SD卡）
        StorageMedia sdCard = new StorageMedia(
            "SanDisk 32GB",
            StorageMedia.StorageType.SD_CARD,
            32L * 1024 * 1024 * 1024, // 32GB
            "/mnt/sdcard"
        );

        // 创建外观对象
        BackupFacade backupFacade = new BackupFacade(sdCard);

        // ========== 测试1：查看数据统计 ==========
        System.out.println("【测试1：查看手机数据统计】");
        System.out.println("========================================");
        BackupFacade.DataStatistics stats = backupFacade.getDataStatistics();
        System.out.println(stats);
        System.out.println("\n");

        // ========== 测试2：一键备份所有数据 ==========
        System.out.println("\n\n【测试2：一键备份所有数据】");
        System.out.println("========================================");
        BackupFacade.BackupResult result = backupFacade.oneClickBackup();

        // 打印备份结果
        System.out.println("\n" + result);

        System.out.println("\n\n");

        // ========== 测试3：选择性备份 ==========
        System.out.println("\n\n【测试3：选择性备份（只备份通讯录和照片）】");
        System.out.println("========================================");

        // 创建新的存储介质
        StorageMedia mmcCard = new StorageMedia(
            "Kingston 16GB",
            StorageMedia.StorageType.MMC_CARD,
            16L * 1024 * 1024 * 1024, // 16GB
            "/mnt/mmcard"
        );

        BackupFacade selectiveBackupFacade = new BackupFacade(mmcCard);
        BackupFacade.BackupResult selectiveResult = selectiveBackupFacade.selectiveBackup(
            true,   // 备份通讯录
            false,  // 不备份短信
            true,   // 备份照片
            false   // 不备份音乐
        );

        System.out.println("\n" + selectiveResult);

        System.out.println("\n\n");

        // ========== 测试4：只备份音乐 ==========
        System.out.println("\n\n【测试4：只备份音乐到U盘】");
        System.out.println("========================================");

        StorageMedia usbFlash = new StorageMedia(
            "Sony 64GB U盘",
            StorageMedia.StorageType.USB_FLASH,
            64L * 1024 * 1024 * 1024, // 64GB
            "/mnt/usb"
        );

        BackupFacade musicBackupFacade = new BackupFacade(usbFlash);
        BackupFacade.BackupResult musicResult = musicBackupFacade.selectiveBackup(
            false,  // 不备份通讯录
            false,  // 不备份短信
            false,  // 不备份照片
            true    // 备份音乐
        );

        System.out.println("\n" + musicResult);

        System.out.println("\n\n");

        // ========== 对比：不使用外观模式 vs 使用外观模式 ==========
        System.out.println("【对比：不使用外观模式 vs 使用外观模式】");
        System.out.println("========================================");

        System.out.println("\n不使用外观模式（直接与多个子系统交互）：");
        System.out.println("----------------------------------------");
        System.out.println("客户端代码需要：");
        System.out.println("1. 创建并管理ContactManager");
        System.out.println("2. 创建并管理MessageManager");
        System.out.println("3. 创建并管理PhotoManager");
        System.out.println("4. 创建并管理MusicManager");
        System.out.println("5. 创建并管理StorageMedia");
        System.out.println("6. 调用每个子系统的read方法");
        System.out.println("7. 调用每个子系统的backup方法");
        System.out.println("8. 处理各种异常情况");
        System.out.println("9. 管理备份流程的顺序");
        System.out.println("10. 处理存储介质的连接和断开");
        System.out.println("\n客户端代码复杂度高，与子系统强耦合！");

        System.out.println("\n\n使用外观模式（通过BackupFacade）：");
        System.out.println("----------------------------------------");
        System.out.println("客户端代码只需：");
        System.out.println("1. 创建BackupFacade对象");
        System.out.println("2. 调用oneClickBackup()方法");
        System.out.println("\n客户端代码简洁，与子系统解耦！");

        System.out.println("\n\n");

        // ========== 总结 ==========
        System.out.println("【总结】");
        System.out.println("========================================");
        System.out.println("外观模式的优势：");
        System.out.println("1. 简化客户端代码：提供简单的接口");
        System.out.println("2. 降低耦合度：客户端不需要知道子系统的细节");
        System.out.println("3. 提高灵活性：可以修改子系统而不影响客户端");
        System.out.println("4. 分层设计：在客户端和子系统之间建立层次");
        System.out.println("5. 封装复杂性：隐藏复杂的交互逻辑");
        System.out.println("\n在本一键备份系统中：");
        System.out.println("- 子系统：ContactManager、MessageManager、");
        System.out.println("         PhotoManager、MusicManager、StorageMedia");
        System.out.println("- 外观类：BackupFacade");
        System.out.println("- 客户端：只需调用BackupFacade的方法即可完成备份");
        System.out.println("\n外观模式成功地简化了复杂系统的使用！");
    }
}