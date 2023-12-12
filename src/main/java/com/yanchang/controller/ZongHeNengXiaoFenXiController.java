package com.yanchang.controller;

import com.yanchang.entity.Two_Level_Data;
import com.yanchang.mapper.B_two_levelMapper;
import com.yanchang.mapper.ZongHeNengXiaoFenXiMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/index")
public class ZongHeNengXiaoFenXiController {
    @Resource
    ZongHeNengXiaoFenXiMapper zongHeNengXiaoFenXiMapper;

    @GetMapping("/getZongHeNengXiaoFenXiChart")
    public List<Two_Level_Data> getchart(@RequestParam("year")int year){

        //System.out.println( b_two_levelMapper.selectChart(index_num,year));

        return zongHeNengXiaoFenXiMapper.selectZongHeNengXiaoFenXi(year);

    }

}
