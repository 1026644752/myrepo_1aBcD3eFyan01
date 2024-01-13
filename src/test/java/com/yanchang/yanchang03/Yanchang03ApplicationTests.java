package com.yanchang.yanchang03;

import com.yanchang.service.LSDShouy;
import com.yanchang.service.Main;
import com.yanchang.service.data_analysis_code;
import com.yanchang.service.main_score;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class Yanchang03ApplicationTests {

    @Resource
    main_score main_score;


    @Test
    void getConnection()  {
        main_score.computeEfficients(2021);
    }


    @Resource
    Main main;


    @Resource
    data_analysis_code data_analysis_code;
    @Test
    void Main_test()  {
        main_score.Compute(2021);
        main.Search();
    }


    @Test
    void Main_test01()  {
//        data_analysis_code.main();
    }






}
