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
public class InvestorServiceImpl implements IInvestorServiceMgmt {
	@Autowired
	private Environment envi;

	@Override
	public Set<String> populateCountries() {
		Locale[] locale = Locale.getAvailableLocales();
		Set<String> countries = new TreeSet();
		for (Locale l : locale) {
			countries.add(l.getDisplayCountry());
		}
		return countries;
	}

	@Override
	public List<String> populateStates(String country) {
		String states = envi.getProperty(country);
		System.out.println(states);
		List<String> splitStates = Arrays.asList(states.split(","));
		splitStates.forEach(System.out::println);
		Collections.sort(splitStates);
		return splitStates;
	}
}
