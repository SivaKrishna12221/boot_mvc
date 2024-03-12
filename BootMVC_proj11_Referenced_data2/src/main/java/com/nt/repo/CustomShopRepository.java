package com.nt.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.nt.entity.Items;

public interface CustomShopRepository extends CrudRepository<Items, String> {

	@Query("select things from Items")
	public Set<String> fetchItems();
}
