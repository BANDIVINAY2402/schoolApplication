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

import com.synectiks.app.entity.TransactionDetailsDto;

import com.synectiks.app.mapper.TransactionDetailsMapper;
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
	
	public List<TransactionDetailsDto> gettransactions() {
		LocalDate today= LocalDate.now();
		Instant instant = today.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
		Date date = Date.from(instant);
		System.out.println(date);
		System.out.println(feedetailsrepository.findByAmountPaidDate(date));
		List<Map<String, Object>> transactions= feedetailsrepository.findByAmountPaidDate(date);
		
		List<TransactionDetailsDto> transactiondetails=TransactionDetailsMapper.INSTANCE.toTransactionDetails(transactions);
		//System.out.println(studentdetailsentity);
		System.out.println(transactiondetails);
		return transactiondetails;
		
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

	public List<TransactionDetailsDto> getThisMonthTransactions() {
		Date currentdate= Date.from(instant);
		System.out.println(currentdate);
		List<Map<String, Object>> studentdetails=feedetailsrepository.findFeesPaidThisMonth();
		
		List<TransactionDetailsDto> sd=TransactionDetailsMapper.INSTANCE.toTransactionDetails(studentdetails);
		
		 return sd;
		
		
	}





	public  List<TransactionDetailsDto> searchStudentFeeDetails(String name, Long admno, String classandsection) {
	
	//List<Map<String, Object>> studentDetails = feedetailsrepository.findStudentAndFeeDetails(name, admno, classandsection);
System.out.println("hii");
if(name.isEmpty()) {
	name=null;
	
}
if(classandsection.isEmpty()) {
	classandsection=null;
}

List<Map<String, Object>> studentdetails=	feedetailsrepository.findStudentAndFeeDetails(name,admno,classandsection);
System.out.println(name+"  "+admno+"  "+classandsection);
System.out.println(studentdetails.isEmpty());
	for (Map<String, Object> details : studentdetails) {
	    if (details == null) {
	        System.out.println("Map is null");
	        continue;
	    }

	    else {
	    	System.out.println("not a null");
	    }
	    // Iterate over each key-value pair in the map
	    for (Map.Entry<String, Object> entry : details.entrySet()) {
	        String key = entry.getKey();    // Get the key
	        Object value = entry.getValue(); // Get the value

	        // Check if the value is null
	        if (value == null) {
	            System.out.println("Key: " + key + " has a null value");
	        } else {
	            // Process the key-value pair
	            System.out.println("Key: " + key + ", Value: " + value);
	        }
	    }
	}

		List<TransactionDetailsDto> sd=TransactionDetailsMapper.INSTANCE.toTransactionDetails(studentdetails);
		System.out.println(sd);
		
		return sd;
	}

}
