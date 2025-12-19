package cn.lixx.designpatterns.prototype;

import java.io.Serializable;

/**
 * 客户地址类
 */
public class Address implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;

    private String province; // 省份
    private String city; // 城市
    private String street; // 街道
    private String zipCode; // 邮编

    public Address() {
    }

    public Address(String province, String city, String street, String zipCode) {
        this.province = province;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
    }

    /**
     * 实现浅克隆 - 复制基本类型数据
     */
    @Override
    public Address clone() {
        try {
            return (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    // Getter和Setter方法
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Address address = (Address) obj;
        return province.equals(address.province) &&
                city.equals(address.city) &&
                street.equals(address.street) &&
                zipCode.equals(address.zipCode);
    }
}