package com.dfz.springboot.model;

import javax.persistence.Table;

/** 
* @author   dfz
* 作者 E-mail:  dfz@jkinvest.cn
* @date 创建时间：2017年5月4日 下午4:52:00 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
@Table(name="city")
public class City extends BaseEntity {
	
	
	private String name;

    private String state;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
    
    
    

}
