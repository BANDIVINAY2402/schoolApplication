package com.synectiks.app.mapper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.synectiks.app.entity.FeeDetails;
import com.synectiks.app.entity.StudentDetailsEntity;
import com.synectiks.app.entity.StudentDetailsOfThisMonthTransactionDto;


@Mapper
public interface StudentDetaulsOfThisMonthTransactionsMapper {
	
	
	StudentDetaulsOfThisMonthTransactionsMapper INSTANCE=Mappers.getMapper(StudentDetaulsOfThisMonthTransactionsMapper.class);
	 @Mapping(source = "name", target = "name")
	 @Mapping(source = "admissionNo", target = "admissionNo")
    @Mapping(source = "classAndSection", target = "classAndSection")
    @Mapping(source = "amountPaid", target = "totalAmountPaid")
    @Mapping(source = "typeOfTransaction", target = "typeOfTransaction")
	StudentDetailsOfThisMonthTransactionDto map(Map<String, Object> map);

	default List<StudentDetailsOfThisMonthTransactionDto> toThisMonthTransactionDetails(List<Map<String, Object>> studentdetails)
	{
		return studentdetails.stream().map(this::map).toList();
		   
		
	}
	default String map(Object value) {
		 if (value == null) {
		        return null;
		    }
		    if (value instanceof String) {
		        return (String) value;
		    }
		    if (value instanceof Date) {
		        return new SimpleDateFormat("yyyy-MM-dd").format((Date) value);
		    }
		    if (value instanceof Number) {
		        return ((Number) value).toString();
		    }
		    // Add other type checks as needed
		    return value.toString();
		}


		

}
