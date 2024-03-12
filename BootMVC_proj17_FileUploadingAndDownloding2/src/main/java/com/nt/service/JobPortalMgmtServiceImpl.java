package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nt.entity.JobSeekar;
import com.nt.repo.CustomJobSeekarRepository;

@Service("service")
public class JobPortalMgmtServiceImpl implements IJobPortalMgmtService {

	@Autowired
	private CustomJobSeekarRepository jobRepo;

	@Override
	public String registerJobProfile(JobSeekar seekar) {
		Integer id = jobRepo.save(seekar).getProfileId();
		return id + " profile Id registered succesfully";
	}

	@Override
	public Page<JobSeekar> fetchListOfProfiles(Pageable pageable) {
		Page<JobSeekar> page = jobRepo.findAll(pageable);
		return page;
	}
}
