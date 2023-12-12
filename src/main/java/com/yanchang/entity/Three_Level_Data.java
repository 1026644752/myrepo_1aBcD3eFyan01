package com.yanchang.entity;

import lombok.Data;

@Data
public class Three_Level_Data {
    private Integer     id;
    private String      index_num;
    private String      index_name;

    private String      department;

    private String      data_sources;

    private String      cycle;

    private String      type;

    private String      measurement_unit;
    private Integer     year;
    private Integer     month;
    private double      data;

    private String      parent_id;
}
