package com.yanchang.controller;

import com.yanchang.domain.DomainTest;
import com.yanchang.entity.Three_Level_Data;
import com.yanchang.entity.Two_Level_Data;
import com.yanchang.mapper.ChartMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/index")
public class ChartController {

   @Resource
    ChartMapper chartMapper;

    @GetMapping("/gettest")
    public List<Two_Level_Data> getchart(){


      //  System.out.println(chartMapper.selectChart());
        return chartMapper.selectChart();

    }


}
