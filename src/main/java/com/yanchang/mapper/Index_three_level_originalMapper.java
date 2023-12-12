package com.yanchang.mapper;

import com.yanchang.entity.Index_three_level_original;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface Index_three_level_originalMapper {

    @Select("select * from index_three_level_original")
    List<Index_three_level_original> findAll();

    @Insert("INSERT INTO `index_three_level_original` (`index_num`, `index_name`, `department`, `data_sources`, `cycle`, `type`, `measurement_unit`,`year`,`month`,`data`,`parent_id`) "
            + "VALUES (#{index_num}, #{index_name}, #{department}, #{data_sources}, #{cycle}, #{type}, #{measurement_unit}, #{year}, #{month}, #{data}, #{parent_id})")
    @Transactional
    void save(String index_num, String index_name,String department,String data_sources,String cycle,String type,String measurement_unit,Integer year,Integer month,Double data,String parent_id);

    @Update("update index_three_level_original set year = #{year}, month = #{month}, data = #{data} where index_num = #{index_num}")
    @Transactional
    void updateById(Index_three_level_original index_three_level);

    @Delete("delete from index_three_level_original where index_num = #{index_num} AND year = #{year} AND month = #{month}")
    void deleteById(String index_num, Integer year, Integer month);

    @Select("select * from index_three_level_original where index_num = #{index_num} AND year = #{year} AND month = #{month}")
    Index_three_level_original findById(String index_num, Integer year, Integer month);

    @Select("select * from index_three_level_original where index_num = #{index_num} ")
    List<Index_three_level_original>  findByIndex(@Param("index_num") String index_num);

    @Select("select * from index_three_level_original limit #{offset},#{pageSize}")
    List<Index_three_level_original> findByPage(Integer offset, Integer pageSize);


    @Select("select count(id) from index_three_level_original")
    Integer countUser();
}
