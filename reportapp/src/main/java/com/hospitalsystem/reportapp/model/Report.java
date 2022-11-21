package com.hospitalsystem.reportapp.model;

import java.time.Instant;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
@Table(name="report")
public class Report {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long fileNumber;
	
	@NotNull
	@Column(name="patient_name")
	@Pattern(regexp="[A-Za-z]")
	private String patientName;
	
	@NotNull
	@Column(name="patient_surname")
	@Pattern(regexp="[A-Za-z]")
	private String patientSurname;
	
	@NotNull
	@Size(min =13, max=13)
	@Column(name="patient_identification")
	private Long patientIdentification;
	
	@NotNull
	@Column(name="diagnostic_title")
	@Pattern(regexp="[A-Za-z]")
	private String diagnosticTitle;
	
	@Column(name="diagnostic_details")
	private String diagnosticDetails;
	
	@Column(name="date")
	private LocalDate date;
	
	@Column(name="image_id")
	private int image;
	
	@ManyToOne
	private LabWorker labWorker;
	
}
