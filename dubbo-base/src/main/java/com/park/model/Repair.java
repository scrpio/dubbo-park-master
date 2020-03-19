package com.park.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author scorpio
 * @since 2020-01-16
 */
@TableName("tb_repair")
public class Repair implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 故障类型(0：机械故障，1：电气故障)
     */
    private Integer type;
    /**
     * 故障名
     */
    private String name;
    /**
     * 故障时间
     */
    @TableField("error_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date errorTime;
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
     * 维修员
     */
    private String repairer;
    /**
     * 维修员手机号
     */
    private String phone;
    /**
     * 状态(0：待处理；1：已报修；2：维修中；3：恢复运行)
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建时间
     */
    @TableField("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getErrorTime() {
        return errorTime;
    }

    public void setErrorTime(Date errorTime) {
        this.errorTime = errorTime;
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

    public String getRepairer() {
        return repairer;
    }

    public void setRepairer(String repairer) {
        this.repairer = repairer;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Repair{" +
                "id=" + id +
                ", type=" + type +
                ", name=" + name +
                ", errorTime=" + errorTime +
                ", garageId=" + garageId +
                ", garageName=" + garageName +
                ", repairer=" + repairer +
                ", phone=" + phone +
                ", status=" + status +
                ", remark=" + remark +
                ", createTime=" + createTime +
                "}";
    }
}
