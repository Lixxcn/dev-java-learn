package cn.lixx.designpatterns.facade.subsystem;

import java.util.ArrayList;
import java.util.List;

/**
 * 通讯录管理类（子系统）
 * 负责通讯录的读取和备份
 */
public class ContactManager {
    private List<Contact> contacts;

    public ContactManager() {
        this.contacts = new ArrayList<>();
        initSampleContacts();
    }

    /**
     * 初始化示例通讯录数据
     */
    private void initSampleContacts() {
        contacts.add(new Contact("张三", "13800138000", "zhangsan@email.com"));
        contacts.add(new Contact("李四", "13900139000", "lisi@email.com"));
        contacts.add(new Contact("王五", "13700137000", "wangwu@email.com"));
        contacts.add(new Contact("赵六", "13600136000", "zhaoliu@email.com"));
    }

    /**
     * 读取通讯录
     * @return 通讯录列表
     */
    public List<Contact> readContacts() {
        System.out.println("正在读取手机通讯录...");
        simulateDelay(500);
        System.out.println("成功读取 " + contacts.size() + " 个联系人");
        return new ArrayList<>(contacts);
    }

    /**
     * 备份通讯录到指定路径
     * @param contacts 通讯录列表
     * @param path 备份路径
     * @return 是否成功
     */
    public boolean backupContacts(List<Contact> contacts, String path) {
        if (contacts == null || contacts.isEmpty()) {
            System.out.println("通讯录为空，无需备份");
            return false;
        }

        System.out.println("正在备份通讯录到: " + path);
        simulateDelay(800);
        System.out.println("通讯录备份完成！共备份 " + contacts.size() + " 个联系人");
        return true;
    }

    /**
     * 获取通讯录数量
     * @return 数量
     */
    public int getContactCount() {
        return contacts.size();
    }

    /**
     * 添加联系人
     * @param contact 联系人
     */
    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("已添加联系人: " + contact.getName());
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
     * 联系人类
     */
    public static class Contact {
        private String name;
        private String phone;
        private String email;

        public Contact(String name, String phone, String email) {
            this.name = name;
            this.phone = phone;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public String getPhone() {
            return phone;
        }

        public String getEmail() {
            return email;
        }

        @Override
        public String toString() {
            return name + " (" + phone + ")";
        }
    }
}