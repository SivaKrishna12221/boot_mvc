package com.nt.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nt.entity.JobSeekar;

public interface IJobPortalMgmtService {
	public String registerJobProfile(JobSeekar seekar);

	public Page<JobSeekar> fetchListOfProfiles(Pageable pageable);
}
