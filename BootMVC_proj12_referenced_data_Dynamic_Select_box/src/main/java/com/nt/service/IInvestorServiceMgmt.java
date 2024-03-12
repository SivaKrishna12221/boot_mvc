package com.nt.service;

import java.util.List;
import java.util.Set;

public interface IInvestorServiceMgmt {
	public Set<String> populateCountries();

	public List<String> populateStates(String country);
}
