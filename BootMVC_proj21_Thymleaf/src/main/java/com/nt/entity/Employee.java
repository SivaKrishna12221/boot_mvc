package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Data;

@Entity
@Table(name = "mvc_emp")
@Data
@SQLDelete(sql = "update mvc_emp set status='deleted' where empno=?") // soft deletion
@Where(clause = "status<>'deleted'")
public class Employee {

	/*
	 * @SequenceGenerator(name = "gen1", sequenceName = "empno_seq", initialValue =
	 * 100, allocationSize = 3)
	 * 
	 * @GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	 */
	@Id
	private Integer empno;
	private String ename;
	private String job;
	private Double sal;
	private Integer deptno;
	private String status = "Active";
	@Transient
	private String activate = "no";
}
