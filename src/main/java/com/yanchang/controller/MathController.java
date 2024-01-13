package com.yanchang.controller;

import com.yanchang.entity.Data_01;
import com.yanchang.service.Main;
import com.yanchang.service.main_score;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping
public class MathController {

    @Resource
    Main main;

    @Resource
    main_score mainScore;

    @RequestMapping("/getMathResult")
    public List<Data_01> math_result(){


        return main.Search();

    }
}
