package com.yanchang.controller;

import com.yanchang.domain.DomainData;
import com.yanchang.entity.Two_Level_Data;
import com.yanchang.mapper.B_two_levelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/index")
public class B_two_levelController {
    @Resource
    B_two_levelMapper b_two_levelMapper;

    @GetMapping("/getB_two_levelCharts")
    public List<Two_Level_Data> getchart(@RequestParam("index_num")String index_num, @RequestParam("year")int year){

        //System.out.println( b_two_levelMapper.selectChart(index_num,year));
        return b_two_levelMapper.selectChart(index_num,year);
    }

}
