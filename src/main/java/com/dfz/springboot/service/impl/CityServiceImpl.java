package com.dfz.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dfz.springboot.mapper.CityMapper;
import com.dfz.springboot.model.City;
import com.dfz.springboot.service.CityService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/** 
* @author   dfz
* 作者 E-mail:  dfz@jkinvest.cn
* @date 创建时间：2017年5月4日 下午4:57:34 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/

@Service
public class CityServiceImpl  implements CityService{
	
	
	@Autowired
	private CityMapper cityMapper;
	
	
	public  List<City> findAll(){
		List<City> list=new ArrayList<City>();		
		return cityMapper.selectAll();
	}


	@Override
	public PageInfo<City> findByPage() {
		PageHelper.startPage(1,2);
		List<City> list=cityMapper.selectAll();		
		return new PageInfo<City>(list);
	}
	
	

}
