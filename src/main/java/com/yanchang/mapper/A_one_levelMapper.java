package com.yanchang.mapper;



import com.yanchang.entity.One_Level_Data;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface A_one_levelMapper {


    @Insert("INSERT INTO index_one_level (index_num,index_name,year,month,data) VALUES(#{index_num},#{index_name},#{year},#{month},#{data})")
    int insertA_one_level(One_Level_Data data);
}
