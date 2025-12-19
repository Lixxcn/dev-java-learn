package cn.lixx.designpatterns.prototype;

import java.io.Serializable;

/**
 * 客户类 - 实现浅克隆
 */
public class Customer implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;

    private String name;            // 客户姓名
    private int age;                // 年龄
    private String phone;           // 电话
    private Address address;        // 客户地址（引用类型）

    public Customer() {
    }

    public Customer(String name, int age, String phone, Address address) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.address = address;
    }

    /**
     * 浅克隆实现
     * 只复制基本数据类型，引用类型只复制引用
     */
    @Override
    public Customer clone() {
        try {
            return (Customer) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 深克隆实现 - 方式1：手动实现
     * 需要克隆所有引用类型的成员变量
     */
    public Customer deepClone() {
        Customer customer = null;
        try {
            customer = (Customer) super.clone();
            // 手动克隆address对象
            customer.address = this.address.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return customer;
    }

    /**
     * 深克隆实现 - 方式2：使用序列化
     */
    public Customer deepCloneBySerialization() {
        try {
            // 注意：Address和Customer都需要实现Serializable接口
            java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();
            java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(bos);
            oos.writeObject(this);

            java.io.ByteArrayInputStream bis = new java.io.ByteArrayInputStream(bos.toByteArray());
            java.io.ObjectInputStream ois = new java.io.ObjectInputStream(bis);
            return (Customer) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Getter和Setter方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", address=" + address +
                '}';
    }

    /**
     * 比较两个Customer对象的内容是否相同（包括address的内容）
     */
    public boolean contentEquals(Customer other) {
        if (this == other) return true;
        if (other == null) return false;

        return age == other.age &&
               name.equals(other.name) &&
               phone.equals(other.phone) &&
               (address == null ? other.address == null : address.equals(other.address));
    }
}