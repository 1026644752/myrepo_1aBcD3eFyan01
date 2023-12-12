package com.yanchang.mapper;

import com.yanchang.entity.Three_Level_Data;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GetAllYearsMapper {
    @Select("SELECT DISTINCT `year`\n" +
            "FROM `index_three_level`\n" +
            "ORDER BY `year` DESC;")
    int[] selectAllYears();
}
