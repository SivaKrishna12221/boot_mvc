package com.nt.controller;

import java.text.SimpleDateFormat;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.CricketerInfo;
import com.nt.service.ICrickterServiceMgmt;

@Controller
public class InitBinderController {

	@Autowired
	private ICrickterServiceMgmt service;

	@GetMapping("/")
	public String showCricketForm(@ModelAttribute("cric") CricketerInfo cricketer) {
		return "cricketer_form";
	}

	@PostMapping("/cricketer_data")
	public String saveCricketerData(@ModelAttribute("cric") CricketerInfo cricketer, Map<String, Object> map) {
		String result = service.registerCricketerInfo(cricketer);
		map.put("message", result);
		return "result_page";
	}
	@InitBinder
	public void myInitBinder(WebDataBinder binder)
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		CustomDateEditor cde=new CustomDateEditor(sdf,false);
		binder.registerCustomEditor(java.util.Date.class, cde);
	}
	
}
