package com.yanchang.mapper;

import com.yanchang.domain.DomainData;
import com.yanchang.domain.DomainTest;
import com.yanchang.entity.Two_Level_Data;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface B_two_levelMapper {
    @Select("SELECT `id`, `index_num`, `index_name`, `year`, `month`, `data`\n" +
            "FROM `index_two_level`\n" +
            "WHERE `index_num` = #{index_num} AND `year` = #{year};\n")
    List<Two_Level_Data> selectChart(@Param("index_num")String index_num, @Param("year")int year);

    @Insert("INSERT INTO index_two_level (index_num,index_name,year,month,data) VALUES(#{index_num},#{index_name},#{year},#{month},#{data})")
    int insertB_two_level(Two_Level_Data data);

}
