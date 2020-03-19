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
@TableName("tb_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 订单编号
     */
    @TableField("order_id")
    private String orderId;
    /**
     * 会员ID
     */
    @TableField("member_id")
    private Long memberId;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 车牌号
     */
    private String license;
    /**
     * 车库ID
     */
    @TableField("garage_id")
    private Long garageId;
    /**
     * 车库名称
     */
    @TableField("garage_name")
    private String garageName;
    /**
     * 车位编码
     */
    @TableField("car_id")
    private String carId;
    /**
     * 单价
     */
    private BigDecimal price;
    /**
     * 合计
     */
    private BigDecimal amount;
    /**
     * 交易状态(0：未付款；1：已付款；2：交易关闭)
     */
    private Integer status;
    /**
     * 支付方式(0：微信；1：钱包)
     */
    @TableField("pay_type")
    private Integer payType;
    /**
     * 备注
     */
    private String remark;
    /**
     * 停车时间
     */
    @TableField("start_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;
    /**
     * 取车时间
     */
    @TableField("end_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Long getGarageId() {
        return garageId;
    }

    public void setGarageId(Long garageId) {
        this.garageId = garageId;
    }

    public String getGarageName() {
        return garageName;
    }

    public void setGarageName(String garageName) {
        this.garageName = garageName;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", memberId=" + memberId +
                ", nickname=" + nickname +
                ", license=" + license +
                ", garageId=" + garageId +
                ", garageName=" + garageName +
                ", carId=" + carId +
                ", price=" + price +
                ", amount=" + amount +
                ", status=" + status +
                ", payType=" + payType +
                ", remark=" + remark +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                "}";
    }
}
