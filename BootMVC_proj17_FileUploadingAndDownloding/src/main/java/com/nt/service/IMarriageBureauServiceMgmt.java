package com.nt.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nt.enitity.MarriageSeekarInfo;

public interface IMarriageBureauServiceMgmt {

	public String registerProfile(MarriageSeekarInfo seekarInfo);

	public Page<MarriageSeekarInfo> getAllProfiles(Pageable pageable);
}
