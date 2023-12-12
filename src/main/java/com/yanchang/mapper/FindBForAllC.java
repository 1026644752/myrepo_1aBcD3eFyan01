package com.yanchang.mapper;

import com.yanchang.entity.Three_Level_Data;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FindBForAllC {
    //该mapper为了找到所有B级指标对应的C级指标
    @Select("SELECT id, index_num, index_name, department, data_sources, cycle, type, measurement_unit, year, month, data, parent_id\n" +
            "FROM index_three_level\n" +
            "WHERE year = #{year}\n" +
            "AND parent_id = #{parent_id} ORDER BY index_num, month\n")
    List<Three_Level_Data> selectChart(@Param("year")int year, @Param("parent_id")String parent_id);
}
