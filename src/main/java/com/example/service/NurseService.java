package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Nurse;
import com.example.repository.NurseRepository;

@Service
@Transactional(readOnly = true)
public class NurseService {
	@Autowired
	private NurseRepository nurseRepository;

	public List<Nurse> findAll() {
		return nurseRepository.findAll();
	}
	
	public Optional<Nurse> findOne(Integer id) {
		return nurseRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Nurse save(Nurse entity) throws Exception{
		if(!( entity.getEmail().contains("@") ) ) {
			throw new Exception("Email incorreto!");
		}else if(entity.getCpf()=="" || entity.getCpf()==null){
			throw new Exception("CPF incorreto!");
		}else if(entity.getCoren()=="" || entity.getCoren()==null){
			throw new Exception("CRM incorreto!");
		}else {
			return nurseRepository.save(entity);
		}
	}

	@Transactional(readOnly = false)
	public void delete(Nurse entity) {
		nurseRepository.delete(entity);
	}
}
