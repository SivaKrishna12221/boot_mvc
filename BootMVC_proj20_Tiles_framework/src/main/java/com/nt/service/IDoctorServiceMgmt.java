package com.nt.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nt.entity.DoctorInfo;

public interface IDoctorServiceMgmt {

	public Page<DoctorInfo> fetchDoctorDetailsInfo(Pageable pageable);
}
