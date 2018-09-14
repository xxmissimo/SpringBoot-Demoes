package com.issimo.jdbc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@Autowired
	JdbcTemplate jdbctemplate;
	
	@ResponseBody
	@GetMapping("/query")
	public Map<String,Object> map(){
		String sql="select * from tb_goods";
		List<Map<String,Object>> list=jdbctemplate.queryForList(sql);
		return list.get(0);
	}
	
}
