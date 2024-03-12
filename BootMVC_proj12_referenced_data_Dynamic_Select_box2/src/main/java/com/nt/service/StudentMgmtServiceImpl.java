package com.nt.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service("service")
public class StudentMgmtServiceImpl implements IStudentMgmtService {

	@Autowired
	private Environment envi;

	@Override
	public Set<String> getListOfCountries() {
		Locale[] locales = Locale.getAvailableLocales();
		Set<String> countries = new TreeSet();
		for (Locale local : locales) {
			countries.add(local.getDisplayCountry());
		}
		return countries;
	}

	@Override
	public Set<String> getListOfStates(String country) {
		String statesData = envi.getProperty(country);
		String[] states = statesData.split(",");
		Set<String> setOfStates = Set.of(states);
		setOfStates.forEach(System.out::println);

		return setOfStates;
	}

	@Override
	public List<String> getListOfDistricts(String district) {
		String districtData = envi.getProperty(district);
		List<String> listOfDistricts = Arrays.asList(districtData.split(","));
		Collections.sort(listOfDistricts);
		return listOfDistricts;
	}

	@Override
	public List<String> getListOfMondals(String mondals) {
		String mondalData = envi.getProperty(mondals);
		List<String> listOfMondals = Arrays.asList(mondalData.split(","));
		Collections.sort(listOfMondals);
		return listOfMondals;
	}
}
