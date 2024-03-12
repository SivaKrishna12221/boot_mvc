package com.nit.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.model.PersonDetails;

@Controller
public class DataRenderingController {

	@GetMapping("/report")
	public String getPersonInfo(Map<String, Object> map) {
		map.put("sno", 10);
		map.put("name", "siva");
		map.put("address", "k.jangampalli");
		return "personInfo";
	}

	@RequestMapping("/show_report")
	public String showReport2(Map<String, Object> map) {
		String[] nickNames = { "siva", "krish", "krishna" };
		Set<Long> phoneNumbers = new HashSet();
		phoneNumbers.add(7799352324l);
		phoneNumbers.add(9949075487l);
		phoneNumbers.add(7799474649l);
		List<String> courseList = List.of("coreJava", "advJava", "oracle");
		Map<String, Long> ids = Map.of("adhar", 353768203807l, "voterId", 45345343l, "pancard", 4343453l);
		map.put("nickNames", nickNames);
		map.put("phoneNumbers", phoneNumbers);
		map.put("courseList", courseList);
		map.put("ids", ids);

		// display list of objects
		PersonDetails details = new PersonDetails(10, "Siva", "Jangampalli", 779945745l);
		PersonDetails details2 = new PersonDetails(11, "Sitha", "kmp", 7799352324l);
		PersonDetails details3 = new PersonDetails(13, "ram", "ayodhya", 7799352015l);

		/*
		 * ArrayList al = new ArrayList(); al.add(details3); al.add(details2);
		 * al.add(details);
		 */
		List list = List.of(details, details2, details3);
		map.put("pinfo", list);

		PersonDetails details4 = new PersonDetails(14, "radha", "arnya", 2343663l);
		map.put("singlePInfo", details4);
		return "specialTypes";

	}
}
