package com.hospitalsystem.reportapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospitalsystem.reportapp.model.LabWorker;
import com.hospitalsystem.reportapp.model.Report;

public interface LabWorkerRepository extends JpaRepository<LabWorker, Long> {
	
	Report findByWorkerName(String workerName);
}
