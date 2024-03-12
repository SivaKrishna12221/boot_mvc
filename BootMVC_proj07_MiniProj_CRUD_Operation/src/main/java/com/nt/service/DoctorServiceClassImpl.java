package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.repo.CustomDoctorRepository;

@Service("service")
public class DoctorServiceClassImpl implements IDoctorServiceMgmt {
	@Autowired
	private CustomDoctorRepository doctorRepo;

	@Override
	public Iterable<Doctor> showDoctorsDetails() {
		Sort sort = Sort.by(Direction.ASC, "doctorId");
		return doctorRepo.findAll(sort);
	}

	@Override
	public String addNewDoctor(Doctor doc) {
		Doctor docs = doctorRepo.save(doc);
		return "Doctor addedd successfully with id:" + docs.getDoctorId();
	}

	// we can use like this also
	@Override
	public Optional<Doctor> findByDoctorId(Integer doctorId) {
		Optional<Doctor> opt = doctorRepo.findById(doctorId);
		if (opt.isPresent()) {

			return opt;
		} else {
			throw new IllegalArgumentException("data not found");
		}
	}

	@Override
	public Doctor showDoctorById(Integer doctorId) {
		return doctorRepo.findById(doctorId).get();

	}

	@Override
	public String updateDoctorByObject(Doctor doc) {
		Doctor docs = doctorRepo.save(doc);

		return "doctor data updated successfully for this Id:" + docs.getDoctorId();
	}

	@Override
	public String deleteDoctorById(Integer doctorId) {

		doctorRepo.deleteById(doctorId);
		return doctorId + " id doctor deleted successfully";
	}

}
