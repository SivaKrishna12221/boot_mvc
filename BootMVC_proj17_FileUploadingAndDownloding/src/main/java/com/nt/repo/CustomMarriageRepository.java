package com.nt.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.enitity.MarriageSeekarInfo;

public interface CustomMarriageRepository extends PagingAndSortingRepository<MarriageSeekarInfo, Integer> {

}
