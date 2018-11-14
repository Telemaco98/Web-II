package com.example.model;

public abstract class Person {
	private int    id;
	private String name;
	private String birth;
	private int    cpf;
	private char   genre;
	private String email;
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
