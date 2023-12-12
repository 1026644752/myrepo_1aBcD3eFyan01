package com.yanchang.mapper;

import com.yanchang.entity.Two_Level_Data;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ZongHeNengXiaoFenXiMapper {
    @Select("SELECT id, index_num, index_name, year, month, data\n" +
            "FROM index_two_level\n" +
            "WHERE index_num LIKE 'B%'\n" +
            "  AND year = #{year}\n" +
            "ORDER BY index_num;")
    List<Two_Level_Data> selectZongHeNengXiaoFenXi(@Param("year")int year);
}
