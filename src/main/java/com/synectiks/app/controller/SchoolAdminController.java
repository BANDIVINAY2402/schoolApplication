package com.synectiks.app.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.synectiks.app.entity.FeeDetails;
import com.synectiks.app.entity.StudentDetailsEntity;

import com.synectiks.app.entity.TransactionDetailsDto;
import com.synectiks.app.service.SchoolAdminService;

import jakarta.persistence.Tuple;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin
public class SchoolAdminController {
	
	@Autowired
	private SchoolAdminService schooladminservice;
	
	
	@GetMapping("/studentdetails")
	public String getStudentDetails(@RequestParam String param) {
		return new String();
	}
	@GetMapping("/Dashboard/recenttransactions")
	public ResponseEntity<List<TransactionDetailsDto>> getRecentTransactions() {
	List<TransactionDetailsDto> studentdetails=schooladminservice.gettransactions();
		
		return ResponseEntity.status(200).body(studentdetails);
	}
	@GetMapping("/Dashboard/feepayments")
	public ResponseEntity<String>  getFeePayments(@RequestParam String timeframe) throws ParseException {
		
	Long total=schooladminservice.getFeePaymentDetails(timeframe);
		return ResponseEntity.status(200).body("total amount received between "+timeframe+":"+total );
	}
	@GetMapping("/Dashboard/thismonthtransactions")
	public ResponseEntity<List<TransactionDetailsDto>>  getthismonthtransactions() {
		
		List<TransactionDetailsDto> student=schooladminservice.getThisMonthTransactions();
		
		return ResponseEntity.status(200).body(student);
	}
	@GetMapping("/Dashboard/SearchStudentFeeDetails")
	public ResponseEntity<List<TransactionDetailsDto>> searchStudentDetails(@RequestParam(required = false) String name,@RequestParam(required = false) Long admno,@RequestParam(required = false) String classandsection) {
		List<TransactionDetailsDto> student=schooladminservice.searchStudentFeeDetails(name,admno,classandsection);
		System.out.println(student);
		return  ResponseEntity.status(200).body(student);
	}
//	@GetMapping("/Dashboard/SearchStudentFeeDetails")
//	public String getMont(@RequestParam String param) {
//		return new String();
//	}
	
	
	
	
	
	
	

}
