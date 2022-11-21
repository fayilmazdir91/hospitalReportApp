package com.hospitalsystem.reportapp.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hospitalsystem.reportapp.model.Report;
import com.hospitalsystem.reportapp.repository.ReportRepository;

@Controller
@RequestMapping("/api")
public class AppController {

	private ReportRepository reportRepository;
	
	public AppController(ReportRepository reportRepository) {
		this.reportRepository = reportRepository;
	}
	
	@GetMapping("/reports")
	public String reports(Model theModel) {
		List<Report> theReports= reportRepository.findAll();
		theModel.addAttribute("reports", theReports);
		return "list-reports";
	}
	
	@GetMapping("/report/{fileNumber}")
	public String getReport(@RequestParam("fileNumber") Long theFileNumber, Model theModel) {
		Report theReport = reportRepository.findByFileNumber(theFileNumber);
		theModel.addAttribute("report", theReport);
		return "one-report";
	}
	
	@GetMapping("/report/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Report theReport = new Report();
		
		theModel.addAttribute("report",theReport);
		return "report-form";
	}
	
	@PostMapping("/save")
	public String saveReport(@ModelAttribute("report") Report theReport) {
		theReport.setDate(LocalDate.now());
		reportRepository.save(theReport);
		return "redirect:/api/reports";
	}
	

	@GetMapping("/report/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("fileNumber") Long theFileNumber, Model theModel) {
		
		Report theReport = reportRepository.findByFileNumber(theFileNumber);
		
		theModel.addAttribute("report", theReport);
		
		return "report-form";
	}
	
	@GetMapping("/report/delete")
	public String delete(@RequestParam("fileNumber") Long theFileNumber) {
		
		reportRepository.deleteById(theFileNumber);
		
		return "redirect:/api/reports";
	}
	
}
