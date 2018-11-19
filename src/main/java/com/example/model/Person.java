package com.example.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public abstract class Person {
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "birth")
	private String birth;
	
	@Column(name = "cpf")
	private String    cpf;
	
	@Column(name = "genre")
	private char   genre;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "cell")
	private String cell;
	
	public Person () { }
	
	public Person (String name, String birth, String cpf, char genre, String email, String cell) {
		
		this.name  = name;
		this.birth = birth;
		this.cpf   = cpf;
		this.genre = genre;
		this.email = email;
		this.cell  = cell;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public char getGenre() {
		return genre;
	}

	public void setGenre(char genre) {
		this.genre = genre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}
	
	
}
