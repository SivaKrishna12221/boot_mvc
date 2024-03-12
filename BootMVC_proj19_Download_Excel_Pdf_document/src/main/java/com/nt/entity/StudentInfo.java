package com.nt.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "mvc_student")
public class StudentInfo {
	@Id
	@GeneratedValue
	private Integer studentId;
	private String studName;
	private String studCourse;
	private Integer studAge;
	@Column(length = 10)
	private String studMobile;
	private Double studFees;
	private LocalDate studDof;

}
