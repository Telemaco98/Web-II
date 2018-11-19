package com.example.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "patients")
public class Patient extends Person implements Serializable {
	private static final long serialVersionUID = 1L;

	public Patient () {
		super();
	}
	
	public Patient (int id, String name, String birth, int cpf, char genre, String email, String cell) {
		super(id, name, birth, cpf, genre, email, cell);
	}
}
