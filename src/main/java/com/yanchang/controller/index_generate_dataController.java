package com.yanchang.controller;


import com.yanchang.service.main_score;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/index_three_level_original")
public class index_generate_dataController {
//    url: '/index_three_level_original/index_generate_data',

    @Resource
    main_score main_score;

    @PostMapping("index_generate_data")
    public String index_generate_data(Integer year){
        System.out.println(year);
        main_score.computeEfficients(year);

        return "success";

    }







}
