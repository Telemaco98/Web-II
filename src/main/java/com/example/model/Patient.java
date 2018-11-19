package com.example.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patients")
public class Patient extends Person implements Serializable {
	private static final long serialVersionUID = 1L;

	public Patient () {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int    id;

	public Patient(int id, String name, String birth, String cpf, char genre, String email, String cell) {
		super(name, birth, cpf, genre, email, cell);
		// TODO Auto-generated constructor stub
		this.id=id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
