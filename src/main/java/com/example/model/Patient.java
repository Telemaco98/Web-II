package com.example.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "patients")
public class Patient extends Person implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column
	private BloodType bloodType;
	
	@Column
	private boolean specialNeed;
	
	@Column
	private String specialNeedDescription; 
	
	public BloodType getBloodType() {
		return bloodType;
	}
	
	public boolean getSpecialNeed() {
		return specialNeed;
	}
	
	public String getSpecialNeedDescription() {
		return specialNeedDescription;
	}
	
	public void setSpecialNeed(boolean specialNeed) {
		this.specialNeed = specialNeed;
	}
	
	public void setSpecialNeedDescription(String specialNeedDescription) {
		this.specialNeedDescription = specialNeedDescription;
	}
}
