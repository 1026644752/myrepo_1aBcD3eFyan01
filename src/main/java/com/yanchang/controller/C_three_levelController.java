package com.yanchang.controller;

import com.yanchang.entity.Three_Level_Data;
import com.yanchang.entity.Two_Level_Data;
import com.yanchang.mapper.C_three_levelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/index")
public class C_three_levelController {

    @Resource
    C_three_levelMapper c_three_levelMapper;

    @GetMapping("/getCThreeLevelController")
    public List<Three_Level_Data> getchart(@RequestParam("index_num")String index_num, @RequestParam("year")int year){

        //System.out.println( b_two_levelMapper.selectChart(index_num,year));
        return c_three_levelMapper.selectChart(index_num, year);
    }
}
