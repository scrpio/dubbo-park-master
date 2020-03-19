package com.park.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class Marker implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private Double latitude;

    private Double longitude;

    private String title;

    private String address;

    private Integer sum;

    private Integer leisure;

    private BigDecimal price;

    private String telephone;

    private String manager;

    private String iconPath;

    private Integer height;

    private Integer distance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Integer getLeisure() {
        return leisure;
    }

    public void setLeisure(Integer leisure) {
        this.leisure = leisure;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Marker{" +
                "id=" + id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", sum=" + sum +
                ", leisure=" + leisure +
                ", price=" + price +
                ", telephone='" + telephone + '\'' +
                ", manager='" + manager + '\'' +
                ", iconPath='" + iconPath + '\'' +
                ", height=" + height +
                ", distance=" + distance +
                '}';
    }
}
