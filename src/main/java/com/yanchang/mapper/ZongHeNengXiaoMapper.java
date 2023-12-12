package com.yanchang.mapper;

import com.yanchang.domain.DomainData;
import com.yanchang.entity.One_Level_Data;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ZongHeNengXiaoMapper {
    @Select("SELECT id, index_num, index_name, year, month, data\n" +
            "FROM `index_one_level`\n" +
            "WHERE year >= (\n" +
            "  SELECT DISTINCT year\n" +
            "  FROM `index_one_level`\n" +
            "  ORDER BY year DESC\n" +
            "  LIMIT 1 OFFSET 1\n" +
            ")\n" +
            "ORDER BY year, month;;")
    List<One_Level_Data> selectZongHeNengXiaoCharts();
}
