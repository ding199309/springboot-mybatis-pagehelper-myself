package com.dfz.springboot.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.dfz.springboot.model.City;
import com.dfz.springboot.service.CityService;
import com.github.pagehelper.PageInfo;

/** 
* @author   dfz
* 作者 E-mail:  dfz@jkinvest.cn
* @date 创建时间：2017年5月4日 下午5:03:31 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/

@Controller
public class CityController {
	
	@Autowired
	private CityService  cityService;
	
	
	@RequestMapping("/list")
	public void  cityList(HttpServletResponse response) throws IOException{		
		List<City> list=cityService.findAll();	
		List<String> listout=new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			listout.add(list.get(i).getName());
		}
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(listout);
	}
	
	@RequestMapping("/pageList")
	public void  pageList(HttpServletResponse response) throws IOException{		
		PageInfo<City> page=cityService.findByPage();
		List<City> list=page.getList();
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(JSONArray.toJSONString(list));
	}

}
