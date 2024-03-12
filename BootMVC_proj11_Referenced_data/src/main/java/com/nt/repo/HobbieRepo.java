package com.nt.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.nt.model.HumanActivities;

public interface HobbieRepo extends CrudRepository<HumanActivities, String> {

	@Query("select hobbies from HumanActivities")
	public Set<String> fetchHobbies();
}
