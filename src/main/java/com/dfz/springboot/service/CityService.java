package com.dfz.springboot.service;

import java.util.List;

import com.dfz.springboot.model.City;
import com.github.pagehelper.PageInfo;

/** 
* @author   dfz
* 作者 E-mail:  dfz@jkinvest.cn
* @date 创建时间：2017年5月4日 下午4:57:06 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
public interface CityService {

	public  List<City> findAll();
	
	public  PageInfo<City> findByPage();
}
