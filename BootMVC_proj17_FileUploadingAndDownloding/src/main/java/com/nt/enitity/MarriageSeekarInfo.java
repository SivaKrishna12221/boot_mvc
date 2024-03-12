package com.nt.enitity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "mvc_marraige_seekar_info")
@Data
public class MarriageSeekarInfo {

	@Id
	@GeneratedValue
	private Integer profileId;
	@Column(length = 25)
	private String name;
	@Column(length = 10)
	private String gender;
	@Column(length = 100)
	private String resumePath;
	@Column(length = 100)
	private String photoPath;

}
