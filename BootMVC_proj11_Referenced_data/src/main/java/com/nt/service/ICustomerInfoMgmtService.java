package com.nt.service;

import java.util.Set;

public interface ICustomerInfoMgmtService {

	public Set<String> populateCountries();

	public Set<String> populateLanguages();

	public Set<String> getHobbies();
}
