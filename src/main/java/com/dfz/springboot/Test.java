package com.dfz.springboot;

import com.dfz.springboot.druid.DruidConfig;
import com.dfz.springboot.service.CityService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author dfz
 * @version 1.0
 * @E-mail: dfz@jkinvest.cn
 * @date 创建时间： 10:52  2017/6/16
 * @return
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class Test {


    @Autowired
    private CityService   cityService;


    @org.junit.Test
    public void test(){
        System.out.println("============="+cityService.findAll());
    }
}
