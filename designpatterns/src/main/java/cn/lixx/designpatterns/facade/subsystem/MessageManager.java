package cn.lixx.designpatterns.facade.subsystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 短信管理类（子系统）
 * 负责短信的读取和备份
 */
public class MessageManager {
    private List<Message> messages;

    public MessageManager() {
        this.messages = new ArrayList<>();
        initSampleMessages();
    }

    /**
     * 初始化示例短信数据
     */
    private void initSampleMessages() {
        messages.add(new Message("13800138000", "你好，明天见！", new Date(), true));
        messages.add(new Message("13900139000", "收到，谢谢！", new Date(), true));
        messages.add(new Message("10086", "您的余额不足10元，请及时充值。", new Date(), false));
        messages.add(new Message("10010", "本月流量已使用80%，请注意使用。", new Date(), false));
        messages.add(new Message("13700137000", "周末有空吗？一起打球。", new Date(), true));
    }

    /**
     * 读取短信
     * @return 短信列表
     */
    public List<Message> readMessages() {
        System.out.println("正在读取手机短信...");
        simulateDelay(600);
        System.out.println("成功读取 " + messages.size() + " 条短信");
        return new ArrayList<>(messages);
    }

    /**
     * 备份短信到指定路径
     * @param messages 短信列表
     * @param path 备份路径
     * @return 是否成功
     */
    public boolean backupMessages(List<Message> messages, String path) {
        if (messages == null || messages.isEmpty()) {
            System.out.println("短信为空，无需备份");
            return false;
        }

        System.out.println("正在备份短信到: " + path);
        simulateDelay(1000);
        System.out.println("短信备份完成！共备份 " + messages.size() + " 条短信");
        return true;
    }

    /**
     * 获取短信数量
     * @return 数量
     */
    public int getMessageCount() {
        return messages.size();
    }

    /**
     * 获取收件箱数量
     * @return 收件箱数量
     */
    public int getInboxCount() {
        int count = 0;
        for (Message msg : messages) {
            if (!msg.isSent()) {
                count++;
            }
        }
        return count;
    }

    /**
     * 获取发件箱数量
     * @return 发件箱数量
     */
    public int getSentCount() {
        int count = 0;
        for (Message msg : messages) {
            if (msg.isSent()) {
                count++;
            }
        }
        return count;
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
     * 短信类
     */
    public static class Message {
        private String phoneNumber;
        private String content;
        private Date date;
        private boolean isSent; // true: 已发送, false: 已接收

        public Message(String phoneNumber, String content, Date date, boolean isSent) {
            this.phoneNumber = phoneNumber;
            this.content = content;
            this.date = date;
            this.isSent = isSent;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public String getContent() {
            return content;
        }

        public Date getDate() {
            return date;
        }

        public boolean isSent() {
            return isSent;
        }

        @Override
        public String toString() {
            return (isSent ? "发给: " : "来自: ") + phoneNumber + " - " +
                   content.substring(0, Math.min(20, content.length())) +
                   (content.length() > 20 ? "..." : "");
        }
    }
}