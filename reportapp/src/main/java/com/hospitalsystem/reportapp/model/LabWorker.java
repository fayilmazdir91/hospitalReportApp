package com.hospitalsystem.reportapp.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
@Table(name="worker")
public class LabWorker {
	
	@Id
	private Long id;
	
	@Column(name="worker_name")
	@Pattern(regexp="[A-Za-z]")
	private String workerName;
	
	@Column(name="worker_surname")
	@Pattern(regexp="[A-Za-z]")
	private String workerSurname;
	
	@Size(min =7, max=7)
	@Column(name="worker_number")
	private Long workerNumber;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Report> reports;
}
