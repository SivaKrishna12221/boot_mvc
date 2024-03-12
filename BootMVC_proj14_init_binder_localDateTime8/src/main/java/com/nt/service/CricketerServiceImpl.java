package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.CricketerInfo;
import com.nt.repo.CustomCricketerRepository;

@Service("service")
public class CricketerServiceImpl implements ICrickterServiceMgmt {

	@Autowired
	private CustomCricketerRepository cricRepo;

	@Override
	public String registerCricketerInfo(CricketerInfo cricketer) {
		CricketerInfo cricInfo = cricRepo.save(cricketer);
		return cricInfo.getCno() + " id cricketer is  saved successfully ";
	}
}
