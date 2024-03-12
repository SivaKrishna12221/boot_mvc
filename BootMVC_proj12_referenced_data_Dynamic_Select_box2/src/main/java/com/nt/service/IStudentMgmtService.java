package com.nt.service;

import java.util.List;
import java.util.Set;

public interface IStudentMgmtService {

	public Set<String> getListOfCountries();

	public Set<String> getListOfStates(String country);

	public List<String> getListOfDistricts(String districts);

	public List<String> getListOfMondals(String mondals);
}
