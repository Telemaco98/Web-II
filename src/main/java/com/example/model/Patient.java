package com.example.model;

public class Patient extends Person {
	 
	
	public Patient () {
		super();
	}
	
	public Patient (int id, String name, String birth, int cpf, char genre, String email, String cell) {
		super(id, name, birth, cpf, genre, email, cell);
	}
}
