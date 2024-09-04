package com.synectiks.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synectiks.app.entity.FeeDetails;
import com.synectiks.app.entity.StudentDetailsEntity;
import com.synectiks.app.entity.StudentDetailsOfThisMonthTransactionDto;
import com.synectiks.app.mapper.StudentDetaulsOfThisMonthTransactionsMapper;
import com.synectiks.app.repository.FeeDetailsRepository;
import com.synectiks.app.repository.StudentadminRepository;

import jakarta.persistence.Tuple;

@Service
public class SchoolAdminService {
	@Autowired
	private StudentadminRepository studentadminrepository;
	@Autowired
	private FeeDetailsRepository feedetailsrepository;
	
	
	LocalDate today= LocalDate.now();
	Instant instant = today.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
	
	public List<StudentDetailsEntity> gettransactions() {
		LocalDate today= LocalDate.now();
		Instant instant = today.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
		Date date = Date.from(instant);
		System.out.println(date);
		List<StudentDetailsEntity> studentdetailsentity= feedetailsrepository.findByAmountPaidDate(date);
		System.out.println(studentdetailsentity);
		return studentdetailsentity;
		
	}





	public Long getFeePaymentDetails(String timeframe) throws ParseException {
		// TODO Auto-generated method stub
		if(timeframe.equalsIgnoreCase("last 6 months"))
		{
			
			Date startDate = Date.from(instant);
			LocalDate sixmonthago=  today.minus(6, ChronoUnit.MONTHS);
			Instant instant1 = sixmonthago.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
			 Date enddate= Date.from(instant1);

				System.out.println(startDate);
				System.out.println(enddate);
			Long total=feedetailsrepository.findTotalAmountPaidByYear(enddate, startDate);
			
			System.out.println(total);
			return total;
			
		}
		else {
			
			String year[]=timeframe.split("-");
			System.out.println(year[0]);
			String starting=year[0]+"-01-01";
			String ending=year[1]+"-12-31";
			  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			  Date startdate=formatter.parse(starting);
			  Date enddate=formatter.parse(ending);
			  
			Long total=feedetailsrepository.findTotalAmountPaidByYear(startdate, enddate);
			System.out.println(total);
			return total;
			
			
		}
		
	}

	public List<StudentDetailsOfThisMonthTransactionDto> getThisMonthTransactions() {
		Date currentdate= Date.from(instant);
		System.out.println(currentdate);
		List<Map<String, Object>> studentdetails=feedetailsrepository.findFeesPaidThisMonth();
		
		List<StudentDetailsOfThisMonthTransactionDto> sd=StudentDetaulsOfThisMonthTransactionsMapper.INSTANCE.toThisMonthTransactionDetails(studentdetails);
		
		 return sd;
		
		
	}

}
