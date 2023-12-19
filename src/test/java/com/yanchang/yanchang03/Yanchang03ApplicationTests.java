package com.yanchang.yanchang03;

import com.yanchang.service.Main;
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

    @Test
    void Main_test()  {
        main_score.Compute(2021);
        main.Search();
    }




}
