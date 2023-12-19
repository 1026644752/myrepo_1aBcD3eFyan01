package com.yanchang.controller;

import com.yanchang.entity.Data_01;
import com.yanchang.service.Main_test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping
public class xiangxi_testController {

    @Resource
    Main_test mainTest;

    @GetMapping("/getTest")
    public List<Data_01> getxiangqing(){


        return mainTest.Search();
    }
}
