package com.yanchang.mapper;



import com.yanchang.entity.One_Level_Data;
import com.yanchang.entity.Two_Level_Data;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface A_one_levelMapper {


    @Insert("INSERT INTO index_one_level (index_num,index_name,year,month,data) VALUES(#{index_num},#{index_name},#{year},#{month},#{data})")
    int insertA_one_level(One_Level_Data data);


    @Select("SELECT `id`, `index_num`, `index_name`, `year`, `month`, `data`\n" +
            "FROM `index_one_level`\n" +
            "WHERE `year` = #{year};\n")
    List<One_Level_Data> select( @Param("year")int year);
}
