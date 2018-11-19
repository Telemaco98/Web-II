package com.example.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public abstract class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int    id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "birth")
	private String birth;
	
	@Column(name = "cpf")
	private int    cpf;
	
	@Column(name = "genre")
	private char   genre;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "cell")
	private String cell;
	
	public Person () { }
	
	public Person (int id, String name, String birth, int cpf, char genre, String email, String cell) {
		this.id    = id;
		this.name  = name;
		this.birth = birth;
		this.cpf   = cpf;
		this.genre = genre;
		this.email = email;
		this.cell  = cell;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getBirth() {
		return birth;
	}
	
	public int getCpf() {
		return cpf;
	}
	
	public char getGenre() {
		return genre;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
