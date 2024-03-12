package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "jpa_doctor_info2")
@Data
public class Doctor {
	@Id
	@SequenceGenerator(name = "seq1", sequenceName = "doctor_id_seq1", initialValue = 220, allocationSize = 1)
	@GeneratedValue(generator = "seq1", strategy = GenerationType.SEQUENCE)
	private Integer doctorId;
	private String doctorName;
	private String specialization;
	private Double income;
}
