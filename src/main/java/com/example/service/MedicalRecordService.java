package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.model.MedicalRecord;
import com.example.repository.MedicalRecordRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class MedicalRecordService {

	@Autowired
	private MedicalRecordRepository medicalRecordRepository;

	public List<MedicalRecord> findAll() {
		return medicalRecordRepository.findAll();
	}
	
	public Optional<MedicalRecord> findOne(Integer id) {
		return medicalRecordRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public MedicalRecord save(MedicalRecord entity) {
		return medicalRecordRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(MedicalRecord entity) {
		medicalRecordRepository.delete(entity);
	}

}
	
