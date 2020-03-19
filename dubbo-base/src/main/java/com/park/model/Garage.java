package com.park.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author scorpio
 * @since 2020-01-16
 */
@TableName("tb_garage")
public class Garage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 车库名称
     */
    private String name;
    /**
     * 联系电话
     */
    private String telephone;
    /**
     * 负责人
     */
    private String manager;
    /**
     * 纬度
     */
    private Double latitude;
    /**
     * 经度
     */
    private Double longitude;
    /**
     * 地址
     */
    private String address;
    /**
     * 车位总数
     */
    private Integer sum;
    /**
     * 行
     */
    private Integer rows;
    /**
     * 列
     */
    private Integer cols;
    /**
     * 单价
     */
    private BigDecimal price;
    /**
     * 图片
     */
    private String img;
    /**
     * 创建时间
     */
    @TableField("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @TableField(exist = false)
    private Integer leisure;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getCols() {
        return cols;
    }

    public void setCols(Integer cols) {
        this.cols = cols;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getLeisure() {
        return leisure;
    }

    public void setLeisure(Integer leisure) {
        this.leisure = leisure;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "id=" + id +
                ", name=" + name +
                ", telephone=" + telephone +
                ", manager=" + manager +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", address=" + address +
                ", sum=" + sum +
                ", rows=" + rows +
                ", cols=" + cols +
                ", price=" + price +
                ", img=" + img +
                ", createTime=" + createTime +
                "}";
    }
}
