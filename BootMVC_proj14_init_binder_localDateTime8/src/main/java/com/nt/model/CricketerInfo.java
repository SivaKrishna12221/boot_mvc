package com.nt.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "mvc_cricketer_ldt")
public class CricketerInfo {
	@Id
	@SequenceGenerator(name = "gen2", sequenceName = "cno_seq1", initialValue = 50, allocationSize = 3)
	@GeneratedValue(generator = "gen2", strategy = GenerationType.SEQUENCE)
	private Integer cno;
	@Column(length = 20)
	private String name;
	@Column(length = 20)
	private String type;
	private LocalDate dob;
	private LocalTime tob;
	private LocalDateTime doj;

}
