package com.example.model;

import java.util.Date;

public class MedicalRecord {
	private int    idPatient; /** The patient id */ 
	private int    height; 	 /** The patient height in cm */
	private float  weidth;	 /** The patient height in kg */
	private Date   date;
	private String description;
		
	public MedicalRecord (int idPatient, int height, float weidth, Date date, String description) {
		this.idPatient 	 = idPatient;
		this.height		 = height;
		this.weidth   	 = weidth;
		this.date		 = date;
		this.description = description;
	}
}
