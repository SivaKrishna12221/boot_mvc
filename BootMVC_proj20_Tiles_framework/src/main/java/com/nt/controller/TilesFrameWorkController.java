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
import com.nt.service.IDoctorServiceMgmt;

@Controller
public class TilesFrameWorkController {

	@Autowired
	private IDoctorServiceMgmt service;

	@GetMapping("/")
	public String showHomeTilesFramework() {
		return "homeDef";
	}

	@GetMapping("/doctor_report")
	public String displayDoctorsInfoByPagination(
			@PageableDefault(size = 5, page = 0, direction = Sort.Direction.ASC, sort = "doctorId") Pageable pageable,
			Map<String, Object> map) {
		Page<DoctorInfo> pageInfo = service.fetchDoctorDetailsInfo(pageable);
		map.put("pageData", pageInfo);
		return "doctorDef";
	}
}
