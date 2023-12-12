package com.yanchang.controller;

import com.yanchang.entity.Three_Level_Data;
import com.yanchang.mapper.GetAllYearsMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/index")
public class GetAllYearsController {
    @Resource
    GetAllYearsMapper getAllYearsMapper;

    @GetMapping("/getAllYears")
    public int[] getchart() {

        //System.out.println( b_two_levelMapper.selectChart(index_num,year));
        return getAllYearsMapper.selectAllYears();

    }
}
