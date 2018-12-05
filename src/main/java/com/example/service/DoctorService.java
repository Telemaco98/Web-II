package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Doctor;
import com.example.repository.DoctorRepository;

@Service
@Transactional(readOnly = true)
public class DoctorService {
	@Autowired
	private DoctorRepository doctorRepository;

	public List<Doctor> findAll() {
		return doctorRepository.findAll();
	}
	
	public Optional<Doctor> findOne(Integer id) {
		return doctorRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Doctor save(Doctor entity) throws Exception{
		if(!( entity.getEmail().contains("@") ) ) {
			throw new Exception("Email incorreto!");
		}else if(entity.getCpf()=="" || entity.getCpf()==null){
			throw new Exception("CPF incorreto!");
		}else if(entity.getCrm()=="" || entity.getCrm()==null){
			throw new Exception("CRM incorreto!");
		}else {
			return doctorRepository.save(entity);
		}
		
	}

	@Transactional(readOnly = false)
	public void delete(Doctor entity) {
		doctorRepository.delete(entity);
	}
}
