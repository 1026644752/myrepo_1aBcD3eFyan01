package com.yanchang.mapper;

import com.yanchang.domain.DomainTest;
import com.yanchang.entity.Three_Level_Data;
import com.yanchang.entity.Two_Level_Data;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;



public interface ChartMapper {

    @Select("SELECT *\n" +
            "FROM `index_two_level`\n" +
            "WHERE year >= (\n" +
            "  SELECT DISTINCT year\n" +
            "  FROM `index_two_level`\n" +
            "  ORDER BY year DESC\n" +
            "  LIMIT 1 OFFSET 1\n" +
            ")\n" +
            "ORDER BY year, month\n")
    List<Two_Level_Data> selectChart();

}
