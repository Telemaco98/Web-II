package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Patient;
import com.example.repository.PatientRepository;

@Service
@Transactional(readOnly = true)
public class PatientService {
	@Autowired
	private PatientRepository patientRepository;

	public List<Patient> findAll() {
		return patientRepository.findAll();
	}
	
	public Optional<Patient> findOne(Integer id) {
		return patientRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Patient save(Patient entity) {
		return patientRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Patient entity) {
		patientRepository.delete(entity);
	}
}
