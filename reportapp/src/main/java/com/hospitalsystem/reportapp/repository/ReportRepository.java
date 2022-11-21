package com.hospitalsystem.reportapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospitalsystem.reportapp.model.Report;

public interface ReportRepository extends JpaRepository<Report, Long> {
	
	Report findByPatientName(String patientName);
	
	Report findByFileNumber(Long fileNumber);
	
}
