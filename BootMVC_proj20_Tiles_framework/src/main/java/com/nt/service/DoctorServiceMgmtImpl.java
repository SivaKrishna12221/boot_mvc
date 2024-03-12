package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nt.entity.DoctorInfo;
import com.nt.repo.CustomDoctorInfoRepository;

@Service("service")
public class DoctorServiceMgmtImpl implements IDoctorServiceMgmt {
	@Autowired
	private CustomDoctorInfoRepository doctorRepo;

	@Override
	public Page<DoctorInfo> fetchDoctorDetailsInfo(Pageable pageable) {

		Page<DoctorInfo> info = doctorRepo.findAll(pageable);
		return info;

	}
}
