package com.yanchang.controller;

import com.yanchang.domain.DomainData;
import com.yanchang.domain.DomainTest;
import com.yanchang.mapper.ChartMapper;
import com.yanchang.mapper.IndexAllChartsMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/index")
public class IndexAllChartsController {
//    @Resource
//    IndexAllChartsMapper indexAllChartsMapper;
//
//    @GetMapping("/getIndexAllCharts")
//    public List<DomainData> getchart(@RequestParam("tableName")String tableName){
//
//    return indexAllChartsMapper.selectALLCharts(tableName);
//    }
}
