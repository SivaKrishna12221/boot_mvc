package com.nt.service;

import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.repo.HobbieRepo;

@Service("service")
public class CustomerServiceImpl implements ICustomerInfoMgmtService {

	@Autowired
	private HobbieRepo hobbieRepo;

	@Override
	public Set<String> populateCountries() {
		Locale[] locales = Locale.getAvailableLocales();
		Set<String> countries = new TreeSet<>();
		for (Locale l : locales) {
			countries.add(l.getDisplayCountry());
		}
		return countries;
	}

	@Override
	public Set<String> populateLanguages() {
		Locale[] locale = Locale.getAvailableLocales();
		Set<String> countryLanguages = new TreeSet<>();
		for (Locale ll : locale) {
			countryLanguages.add(ll.getDisplayLanguage());
		}
		return countryLanguages;
	}

	@Override
	public Set<String> getHobbies() {
		Set<String> hobbies = hobbieRepo.fetchHobbies();
		return hobbies;
	}

}
