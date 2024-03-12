package com.nt.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Data;

@Entity
@Table(name = "mvc_student")
@Data
@SQLDelete(sql = "UPDATE mvc_student SET status='Deleted' where student_id=?")
@Where(clause = "status = 'Active'")
public class StudentInfo {

	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "sId_seq", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	@Column(name = "student_id")
	private Integer studentId;
	@Column(name = "stud_name", length = 20)
	private String name;
	@Column(name = "stud_course", length = 20)
	private String course;
	@Column(name = "stud_age")
	private Integer age;
	@Column(name = "stud_mobile")
	private String mobile;
	@Column(name = "stud_fees")
	private Double fees;
	@Column(name = "stud_dof")
	private LocalDate dof = LocalDate.now();
	@Column(name = "status")
	private String status = "Active";
	@Transient

	private String validateFlag = "no";
}
