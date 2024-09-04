package com.synectiks.app.mapper;

import java.util.Map;

import com.synectiks.app.entity.StudentDetailsOfThisMonthTransactionDto;

public class StudentDetailsOfThisMonthTransactin {

	
	public StudentDetailsOfThisMonthTransactionDto mapToStudentMonthTransaction(Map<String, Object> result) {
		StudentDetailsOfThisMonthTransactionDto transaction = new StudentDetailsOfThisMonthTransactionDto();
        
        // Assuming the map keys match the column names in the SQL query
        transaction.setName((String) result.get("name"));
        transaction.setAdmissionNo((Long) result.get("admissionNo"));
        transaction.setClassAndSection((String) result.get("class_and_section"));
        transaction.setTotalAmountPaid((Integer) result.get("amount_paid"));
        transaction.setTypeOfTransaction((String) result.get("type_of_transaction"));
        
        return transaction;
    
}
}
