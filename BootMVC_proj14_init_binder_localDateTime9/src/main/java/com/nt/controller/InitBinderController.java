package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.editor.LocalDateEditor;
import com.nt.editor.LocalDateTimeEditor;
import com.nt.editor.LocalTimeEditor;
import com.nt.model.InvestorInfo;

@Controller
public class InitBinderController {

	@GetMapping("/")
	public String showInvestorFormPage(@ModelAttribute("investor") InvestorInfo investor) {
		return "investor_form";
	}

	@PostMapping("/register")
	public String resultPage(@ModelAttribute("investor") InvestorInfo investor, Map<String, Object> map) {
		map.put("investor", investor);
		return "result_page";
	}

	@InitBinder
	public void myInitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(java.time.LocalDate.class, new LocalDateEditor());
		binder.registerCustomEditor(java.time.LocalTime.class, new LocalTimeEditor());
		binder.registerCustomEditor(java.time.LocalDateTime.class, new LocalDateTimeEditor());
	}

}
