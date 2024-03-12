package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nt.enitity.MarriageSeekarInfo;
import com.nt.repo.CustomMarriageRepository;

@Service("service")
public class MarriageBureauServiceImpl implements IMarriageBureauServiceMgmt {
	@Autowired
	private CustomMarriageRepository marriageRepo;

	@Override
	public String registerProfile(MarriageSeekarInfo seekarInfo) {

		Integer id = marriageRepo.save(seekarInfo).getProfileId();
		return "profile is successfully registered with id " + id;
	}

	@Override
	public Page<MarriageSeekarInfo> getAllProfiles(Pageable pageable) {

		return marriageRepo.findAll(pageable);

	}
}
