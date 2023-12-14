package com.yanchang.entity;

//该实体类用于
//用来给前端发送 最大值 最小值 相应月份
//对综合能效 a 影响最大的 b

import lombok.Data;

@Data
public class Data_01 {
    private  String id;//用来判断是那个指标的
    private String information; //存储传递的信息

}
