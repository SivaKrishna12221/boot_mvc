package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "jpa_doctor_info2")
@Entity
public class DoctorInfo {

	@Id
	@GeneratedValue
	private Integer doctorId;
	private String doctorName;
	private String specialization;
	private Double income;
}
