package com.yanchang.mapper;

import com.yanchang.entity.Two_Level_Data;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GetTwoYearBLevelDataMapper {

    @Select("SELECT id, index_num, index_name, year, month, data\n" +
            "FROM `index_two_level`\n" +
            "WHERE year >= (\n" +
            "  SELECT DISTINCT year\n" +
            "  FROM `index_two_level`\n" +
            "  WHERE index_num = #{index_num}\n" +
            "  ORDER BY year DESC\n" +
            "  LIMIT 1 OFFSET 1\n" +
            ") AND index_num = #{index_num}\n" +
            "ORDER BY year, month")
    List<Two_Level_Data> selectChart(@Param("index_num") String index_num);
}
