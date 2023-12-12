package com.yanchang.controller;

import com.yanchang.entity.Two_Level_Data;
import com.yanchang.mapper.GetTwoYearBLevelDataMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;



@RestController
@RequestMapping("/index")
public class GetTwoYearBLevelDataController {

    @Resource
    GetTwoYearBLevelDataMapper getTwoYearBLevelDataMapper;

    @GetMapping("/getTwoYearBLevel")
    public List<Two_Level_Data> getchart(@RequestParam("index_num") String index_num){


        //System.out.println(getTwoYearBLevelDataMapper.selectChart());
        return getTwoYearBLevelDataMapper.selectChart(index_num);

    }

}
