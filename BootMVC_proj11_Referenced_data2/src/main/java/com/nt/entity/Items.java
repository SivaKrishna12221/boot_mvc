package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

@Entity
@Data
@Table(name = "mvc_items")
@Component
public class Items {

	@Id
	@GeneratedValue
	private Integer id;
	private String things;
}
