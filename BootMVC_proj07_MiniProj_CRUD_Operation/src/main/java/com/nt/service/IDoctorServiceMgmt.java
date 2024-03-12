package com.nt.service;

import java.util.Optional;

import com.nt.entity.Doctor;

public interface IDoctorServiceMgmt {
	public Iterable<Doctor> showDoctorsDetails();

	public String addNewDoctor(Doctor doc);

	public Optional<Doctor> findByDoctorId(Integer doctorId);

	public Doctor showDoctorById(Integer doctorId);

	public String updateDoctorByObject(Doctor doc);

	public String deleteDoctorById(Integer doctorId);

}
