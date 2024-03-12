package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.entity.Doctor;
import com.nt.service.IDoctorServiceMgmt;

@Controller
public class DoctorController {
	@Autowired
	private IDoctorServiceMgmt service;

	@GetMapping("/")
	public String showDoctorHome() {
		return "doctorHome";
	}

	@GetMapping("/show_doctor_report")
	public String showDoctorReport(Map<String, Object> map) {
		Iterable<Doctor> docs = service.showDoctorsDetails();
		map.put("docsList", docs);
		return "doctor_report";
	}

	@GetMapping("/add_doctor")
	public String addNewDoctor(@ModelAttribute("docs") Doctor docs) {
		return "add_doctor";
	}

	// This code contains drawback . Here double positing is happend
	/*
	 * @PostMapping("/add_doctor")
	 * public String updatedDoctorReport(Map<String, Object>
	 * map, @ModelAttribute("docs") Doctor docs) {
	 * String msg = service.addNewDoctor(docs);
	 * Iterable<Doctor> docList = service.showDoctorsDetails();
	 * map.put("msg", msg);
	 * map.put("docsList", docList);
	 * return "doctor_report";// double posting problem
	 * }
	 */
	// To solve this problem
	/*
	 * @PostMapping("/add_doctor")
	 * public String updatedDoctorReport(@ModelAttribute("docs") Doctor docs) {
	 * String msg = service.addNewDoctor(docs);
	 * map.put("msg", msg);
	 * return "redirect:doctor_report";//it contains draw back we can't get the
	 * message
	 * }
	 */
	@PostMapping("/add_doctor")
	public String updatedDoctorReport(@ModelAttribute("docs") Doctor docs, RedirectAttributes attr) {
		String message = service.addNewDoctor(docs);
		attr.addFlashAttribute("msg", message);
		return "redirect:show_doctor_report";
		// we can also use httpSession attribute to display msg continuously.
	}
	/*
	 * @GetMapping("/edit_doctor_report") public String
	 * editDoctorData(Map<String,Object> map, @ModelAttribute("docs") Doctor docs,
	 * 
	 * @RequestParam Integer doctorId) { Optional<Doctor> doctorInfo =
	 * service.findByDoctorId(doctorId);
	 * 
	 * map.put("docs", doctorInfo);
	 * 
	 * return "add_doctor"; }
	 */

	@GetMapping("/edit_doctor_report")
	public String showEditDoctorPage(@RequestParam Integer doctorId, @ModelAttribute("docs") Doctor doc) {
		Doctor doctor = service.showDoctorById(doctorId);
		BeanUtils.copyProperties(doctor, doc);
		return "edit_doctor";

	}

	@PostMapping("/edit_doctor_report")
	public String updateDoctorRecord(@ModelAttribute("docs") Doctor doc, RedirectAttributes attr) {
		String result = service.updateDoctorByObject(doc);
		attr.addFlashAttribute("msg", result);
		return "redirect:show_doctor_report";
	}

	@GetMapping("/delete_doctor_report")
	public String deleteDoctorData(@RequestParam Integer doctorId, RedirectAttributes attr) {
		String result = service.deleteDoctorById(doctorId);
		attr.addFlashAttribute("msg", result);
		return "redirect:show_doctor_report";
	}
}
