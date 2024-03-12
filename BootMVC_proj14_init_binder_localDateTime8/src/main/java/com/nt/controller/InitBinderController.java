package com.nt.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.editors.LocalDateEditor;
import com.nt.editors.LocalDateTimeEditor;
import com.nt.editors.LocalTimeEditor;
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
	public String saveCricketerData(@ModelAttribute("cric") CricketerInfo cricketer, Map<String, Object> map,
			BindingResult errors) {
		String result = service.registerCricketerInfo(cricketer);
		map.put("message", result);
		return "result_page";
	}

	@InitBinder
	public void myInitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(LocalDate.class, new LocalDateEditor());
		binder.registerCustomEditor(LocalTime.class, new LocalTimeEditor());
		binder.registerCustomEditor(LocalDateTime.class, new LocalDateTimeEditor());
	}

}
