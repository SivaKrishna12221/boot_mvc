package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "mvc_job_seekar")
@Data
public class JobSeekar {
	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "seq_id", initialValue = 100, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer profileId;
	@Column(length = 20)
	private String name;
	@Column(length = 10)
	private String gender;
	@Column(length = 100)
	private String photo;
	@Column(length = 100)
	private String resume;
}
