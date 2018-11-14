package com.example.model;

public class MedicalRecord {
	private int   idPatient; /** The patient id */ 
	private int   height; 	 /** The patient height in cm */
	private float weidth;	 /** The patient height in kg */
	private String exam;
		
	public MedicalRecord (int idPatient, int height, float weidth) {
		this.idPatient = idPatient;
		this.height    = height;
		this.weidth    = weidth;
	}
}
