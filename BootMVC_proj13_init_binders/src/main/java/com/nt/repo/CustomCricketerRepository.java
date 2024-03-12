package com.nt.repo;

import org.springframework.data.repository.CrudRepository;

import com.nt.model.CricketerInfo;

public interface CustomCricketerRepository extends CrudRepository<CricketerInfo, Integer> {

}
