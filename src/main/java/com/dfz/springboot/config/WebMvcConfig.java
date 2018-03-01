package com.dfz.springboot.config;

import com.dfz.springboot.interceptor.FrontInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/** 
* @author   dfz
* 作者 E-mail:  dfz@jkinvest.cn
* @date 创建时间：2017年5月4日 下午5:22:57 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    private String[] interceptorUrls = new String[]{
            "/**"
    };

    private String[] excludeUrls = new String[]{
    };


    /**
     * 解决spring mvc拦截器无法使用@Resource依赖注入的问题
     * @return
     */
    @Bean
    public FrontInterceptor userInterceptor() {

        return new FrontInterceptor();
    }

    /**
     * 添加静态资源
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    /**
     * 添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptregistration = registry.addInterceptor(userInterceptor());
        for(int i=0;i<interceptorUrls.length;i++){
            interceptregistration.addPathPatterns(interceptorUrls[i]);
        }
        for(int i=0;i<excludeUrls.length;i++){
            interceptregistration.excludePathPatterns(excludeUrls[i]);
        }
        super.addInterceptors(registry);
    }

}