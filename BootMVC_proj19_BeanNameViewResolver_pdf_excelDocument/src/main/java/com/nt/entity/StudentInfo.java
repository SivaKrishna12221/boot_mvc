package com.nt.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private String studMobile;
	private Double studFees;
	private LocalDate studDof;

}
