package com.yanchang.controller;

import com.yanchang.domain.DomainData;
import com.yanchang.entity.One_Level_Data;
import com.yanchang.mapper.IndexAllChartsMapper;
import com.yanchang.mapper.ZongHeNengXiaoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/index")
public class ZongHeNengXiaoChartsController {
    @Resource
    ZongHeNengXiaoMapper zongHeNengXiaoMapper;
    @GetMapping("/getZongHeNengXiaoCharts")
    public List<One_Level_Data> getchart(){

        return zongHeNengXiaoMapper.selectZongHeNengXiaoCharts();
    }
}
