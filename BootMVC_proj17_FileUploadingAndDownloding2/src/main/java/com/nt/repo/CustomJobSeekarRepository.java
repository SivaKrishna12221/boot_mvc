package com.nt.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.entity.JobSeekar;

public interface CustomJobSeekarRepository extends PagingAndSortingRepository<JobSeekar, Integer> {

}
