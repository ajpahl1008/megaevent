package com.pahlsoft.ws.megaevent.service;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pahlsoft.ws.megaevent.beans.RoleMapBean;

public class TestMapBean {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
 
    	RoleMapBean rmb = (RoleMapBean) context.getBean("roleMapBean");
   	
    	System.out.println("Role 1: " + rmb.getRoleTypes().get(1));
    	for (Map.Entry<Integer, String> entry : rmb.getRoleTypes().entrySet()) {
    		System.out.println(entry.getKey()+ "-" + entry.getValue());
    	}
    	
	}

}
