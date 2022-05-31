package com.spring.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("mydata")
public class MyData {
    @TableId(type = IdType.AUTO)
    private Integer dataId;
    @TableField(value = "time")
    private String datetime;
    private Double temperature;
    private Double humidity;
    private Double pressure;
}
