package com.thuchanhchuyensau.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class MessageUtil {
	
	public Map<String,String> getMessage(String mess){
		Map<String, String> rs=new HashMap<>();
		if(mess.equals("err_confirm")) {
			rs.put("message","Confirm Password Incorrect !");	
			rs.put("alert","danger");
		}
		else if(mess.equals("err_valid")) {
			rs.put("message","Username Invalid !");
			rs.put("alert","danger");
		}
		else if(mess.equals("add_user_success")) {
			rs.put("message","Register Complete !");
			rs.put("alert","success");
		}
		
		return rs;
	}
	
}
