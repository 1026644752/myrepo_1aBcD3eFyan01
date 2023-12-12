package com.yanchang.controller;
import lombok.Data;

@Data
public class IndexAddRequest {
    private String index_num;
    private String index_name;
    private String department;
    private String data_sources;
    private String cycle;
    private String type;
    private String measurement_unit;
    private Integer year;
    private Integer month;
    private Double data;
    private String parent_id;
}
