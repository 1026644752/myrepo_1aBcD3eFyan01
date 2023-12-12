package com.yanchang.mapper;

import com.yanchang.entity.Three_Level_Data;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface C_three_levelMapper {
    @Select("SELECT id, index_num, index_name, department, data_sources, cycle, type, measurement_unit, year, month, data, parent_id\n" +
            "FROM `index_three_level`\n" +
            "WHERE index_num = #{index_num} AND year = #{year};\n")
    List<Three_Level_Data> selectChart(@Param("index_num")String index_num, @Param("year")int year);

    @Select("SELECT id, index_num, index_name, department, data_sources, cycle, type, measurement_unit, year, month, data, parent_id\n" +
            "FROM `index_three_level_original`\n" +
            "WHERE index_num = #{index_num} AND year = #{year};\n")
    List<Three_Level_Data> selectOriginal(@Param("index_num")String index_num, @Param("year")int year);

    @Insert("INSERT INTO index_three_level (index_num,index_name,department,data_sources,cycle,type,measurement_unit,year,month,data,parent_id) VALUES(#{index_num},#{index_name},#{department},#{data_sources},#{cycle},#{type},#{measurement_unit},#{year},#{month},#{data},#{parent_id})")
    int insertC_three_level(Three_Level_Data data);


}
