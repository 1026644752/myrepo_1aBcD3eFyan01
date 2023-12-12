package com.yanchang.controller;


import com.yanchang.entity.Index_three_level_original;
import com.yanchang.mapper.Index_three_level_originalMapper;
import com.yanchang.vo.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/index_three_level_original")
public class Index_three_level_originalController {

    @Resource
    Index_three_level_originalMapper index_three_levelOriginalMapper;

    @GetMapping("select_all")
    public List<Index_three_level_original> getUser() {
        return index_three_levelOriginalMapper.findAll();
    }

    @PostMapping("index_add")
    @ResponseBody
    public String addUser(@RequestBody IndexAddRequest request) {
        String index_num = request.getIndex_num();
        String index_name = request.getIndex_name();
        String department = request.getDepartment();
        String data_sources = request.getData_sources();
        String cycle = request.getCycle();
        String type = request.getType();
        String measurement_unit = request.getMeasurement_unit();
        Integer year = request.getYear();
        Integer month = request.getMonth();
        Double data = request.getData();
        String parent_id = request.getParent_id();
        index_three_levelOriginalMapper.save(index_num,index_name,department,data_sources,cycle,type,measurement_unit,year,month,data,parent_id);
        System.out.println(index_num + year + month + data);
        return "success";
    }

    @PutMapping
    public String updateUser(@RequestBody Index_three_level_original indexThreeLevelOriginal) {
        index_three_levelOriginalMapper.updateById(indexThreeLevelOriginal);
        return "success";
    }

    @GetMapping ("/index_delete")
    public String deleteUser(String index_num, Integer year, Integer month) {
        index_three_levelOriginalMapper.deleteById(index_num, year, month);
        return "success";
    }

    @GetMapping("/index_select_index")
    public List<Index_three_level_original> findByIndex(String index_num) {
        System.out.println(index_three_levelOriginalMapper.findByIndex(index_num));
        return index_three_levelOriginalMapper.findByIndex(index_num);
    }

    @GetMapping("/page")
    public Page<Index_three_level_original> findByPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                              @RequestParam(defaultValue = "10") Integer pageSize) {
        Integer offset = (pageNum - 1) * pageSize;
        List<Index_three_level_original> indexthreelevelData = index_three_levelOriginalMapper.findByPage(offset, pageSize);
        Page<Index_three_level_original> page = new Page<>();
        page.setData(indexthreelevelData);

        Integer total = index_three_levelOriginalMapper.countUser();
        page.setTotal(total);
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        return page;
    }

}
