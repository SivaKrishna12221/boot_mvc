package com.nt.service;

import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.repo.CustomShopRepository;

@Service("service")
public class VeeradeviShopServiceImpl implements IVeeradeviShopMgmtService {

	@Autowired
	private CustomShopRepository itemRepo;

	@Override
	public Set<String> getSetOfCountries() {

		Locale[] locale = Locale.getAvailableLocales();
		Set<String> countries = new TreeSet<>();
		for (Locale l : locale) {
			countries.add(l.getDisplayCountry());
		}
		return countries;
	}

	@Override
	public Set<String> getSetOfLanguages() {
		Locale locales[] = Locale.getAvailableLocales();
		Set<String> languages = new TreeSet<>();// sorting order
		for (Locale lan : locales) {
			languages.add(lan.getDisplayLanguage());
		}
		return languages;
	}

	@Override
	public Set<String> getListOfItems() {
		Set<String> items = itemRepo.fetchItems();
		return items;
	}
}
