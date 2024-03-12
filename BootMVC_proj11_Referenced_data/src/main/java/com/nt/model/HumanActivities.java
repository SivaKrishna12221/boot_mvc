package com.nt.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Entity
@Table(name = "mvc_human_activities")
@Component
public class HumanActivities {

	@Id
	private String hobbies;
}
