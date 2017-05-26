package com.dfz.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/** 
* @author   dfz
* 作者 E-mail:  dfz@jkinvest.cn
* @date 创建时间：2017年4月28日 下午6:01:40 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
@SpringBootApplication
@MapperScan(basePackages="com.dfz.springboot.mapper")
public class RootController{


	
    public static void main(String[] args) throws Exception {
    	SpringApplication  ap=new SpringApplication(RootController.class);  	
    	// ap.setBannerMode(Banner.Mode.OFF);
    	ap.run(args);
    }

}
