package com.example.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "medicalRecords")
public class MedicalRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int    id;
	
	@ManyToOne
	@JoinColumn(name="patient_id")
	private Patient patient; /** The patient id */ 
	@Column(name = "height")
	private float    height; 	 /** The patient height in cm */
	@Column(name = "weight")
	private float  weight;	 /** The patient height in kg */
	@Column(name = "date")
	private String   date;
	@Column(name = "description")
	private String description;
	@Column(name = "symptoms")
	private String symptoms;
	@Column(name = "systolicBloodPressure")
	private float systolicBloodPressure;
	@Column(name = "diastolicBloodPressure")
	private float diastolicBloodPressure;
	@Column(name = "medication")
	private String medication;
	@Column(name = "clinicalStatus")
	private String clinicalStatus;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public float getSystolicBloodPressure() {
		return systolicBloodPressure;
	}

	public void setSystolicBloodPressure(float systolicBloodPressure) {
		this.systolicBloodPressure = systolicBloodPressure;
	}

	public float getDiastolicBloodPressure() {
		return diastolicBloodPressure;
	}

	public void setDiastolicBloodPressure(float diastolicBloodPressure) {
		this.diastolicBloodPressure = diastolicBloodPressure;
	}

	public String getMedication() {
		return medication;
	}

	public void setMedication(String medication) {
		this.medication = medication;
	}

	public String getClinicalStatus() {
		return clinicalStatus;
	}

	public void setClinicalStatus(String clinicalStatus) {
		this.clinicalStatus = clinicalStatus;
	}
	
	
		
	
}
