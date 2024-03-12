package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.entity.DoctorInfo;
import com.nt.service.INitServiceMgmt;

@Controller
public class TilesController {

	@Autowired
	private INitServiceMgmt service;

	@GetMapping("/")
	public String showHomePage() {
		return "homeDef";
	}

	@GetMapping("/doctor_report")
	public String displayDoctorReport(Map<String, Object> map,
			@PageableDefault(size = 5, page = 0, direction = Sort.Direction.ASC, sort = "doctorId") Pageable pageable) {
		Page<DoctorInfo> page = service.fetchDoctorDetailsInfo(pageable);
		map.put("pageData", page);
		return "doctorDef";
	}
}
