package com.park.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author scorpio
 * @since 2020-01-16
 */
@TableName("tb_garage_car")
public class GarageCar implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 车位编号
     */
    @TableField("car_id")
    private String carId;
    /**
     * 状态(0：空闲；1：使用)
     */
    private Boolean status;
    /**
     * 所属车库ID
     */
    @TableField("garage_id")
    private Long garageId;
    /**
     * 所属车库
     */
    @TableField("garage_name")
    private String garageName;
    /**
     * 行
     */
    private Integer rows;
    /**
     * 列
     */
    private Integer cols;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "GarageCar{" +
                "id=" + id +
                ", carId=" + carId +
                ", status=" + status +
                ", garageId=" + garageId +
                ", garageName=" + garageName +
                ", rows=" + rows +
                ", cols=" + cols +
                "}";
    }
}
