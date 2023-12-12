package com.yanchang.controller;

import com.yanchang.entity.Three_Level_Data;
import com.yanchang.mapper.C_three_levelMapper;
import com.yanchang.mapper.FindBForAllC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/index")
public class FindBForAllCController {


        @Resource
        FindBForAllC findBForAllC;

        @GetMapping("/getFindBForAllC")
        public List<Three_Level_Data> getchart(@RequestParam("year") int year, @RequestParam("parent_id") String parent_id) {

            //System.out.println( b_two_levelMapper.selectChart(index_num,year));
            return findBForAllC.selectChart(year, parent_id);

    }
}
