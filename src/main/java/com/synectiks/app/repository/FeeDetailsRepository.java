package com.synectiks.app.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.synectiks.app.entity.FeeDetails;
import com.synectiks.app.entity.StudentDetailsEntity;


import jakarta.persistence.Tuple;

@Repository
public interface FeeDetailsRepository extends JpaRepository<FeeDetails, Long> {



	
	@Query("SELECT s.name AS name, s.admissionNo AS admissionNo,s.classAndSection AS classAndSection,f.typeOfTransaction AS typeOfTransaction, f.amountPaid AS amountPaid, f.receiptNo AS receiptNo " +
		       "FROM StudentDetailsEntity s JOIN s.feeDetails f " +
		       "WHERE f.amountPaidDate = :amountPaidDate")
	List<Map<String, Object>>  findByAmountPaidDate(@Param("amountPaidDate") Date date);

	@Query("SELECT SUM(f.amountPaid) FROM FeeDetails f WHERE f.amountPaidDate BETWEEN :startDate AND :endDate")
	Long findTotalAmountPaidByYear(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
	


	@Query("SELECT s.name AS name, s.admissionNo AS admissionNo, s.classAndSection AS classAndSection, " +
		       "f.amountPaid AS amountPaid, f.typeOfTransaction AS typeOfTransaction, f.receiptNo AS receiptNo " +
		       "FROM StudentDetailsEntity s JOIN s.feeDetails f " +
		       "WHERE EXTRACT(MONTH FROM f.amountPaidDate) = EXTRACT(MONTH FROM CURRENT_DATE) " +
		       "AND EXTRACT(YEAR FROM f.amountPaidDate) = EXTRACT(YEAR FROM CURRENT_DATE)")
		List<Map<String, Object>> findFeesPaidThisMonth();
	
	
//	
//	@Query("SELECT s.name AS name, s.admissionNo AS admissionNo, s.classAndSection AS classAndSection, " +
//		       "f.amountPaid AS amountPaid, f.typeOfTransaction AS typeOfTransaction, f.receiptNo AS receiptNo " +
//		       "FROM StudentDetailsEntity s JOIN s.feeDetails f " +
//		       "WHERE (:name IS NULL OR s.name = :name) " +
//		       "AND (:admissionNo IS NULL OR s.admissionNo = :admissionNo) " +
//		       "AND (:classAndSection IS NULL OR s.classAndSection = :classAndSection)")
//		List<Map<String, Object>> findStudentAndFeeDetails(@Param("name") String name, 
//		                                                    @Param("admissionNo") Long admissionNo, 
//		                                                    @Param("classAndSection") String classAndSection);

//
//	@Query("SELECT s.name AS name, " +
//		       "s.admissionNo AS admissionNo, " +
//		       "s.classAndSection AS classAndSection, " +
//		       "f.amountPaid AS totalAmountPaid, " +
//		       "f.typeOfTransaction AS typeOfTransaction, " +
//		       "f.receiptNo AS receiptNo " +
//		       "FROM StudentDetailsEntity s " +
//		       "JOIN s.feeDetails f " +
//		       "WHERE (:name IS NULL OR s.name = :name) " +
//		       "AND (:admissionNo IS NULL OR s.admissionNo = :admissionNo) " +
//		       "AND (:classAndSection IS NULL OR s.classAndSection = :classAndSection)")
//		List<Map<String, Object>> findStudentAndFeeDetails(
//		    @Param("name") String name, 
//		    @Param("admissionNo") Long admissionNo, 
//		    @Param("classAndSection") String classAndSection);
//
	@Query("SELECT s.name AS name, s.admissionNo AS admissionNo, s.classAndSection AS classAndSection, " +
		       "f.amountPaid AS totalAmountPaid, f.typeOfTransaction AS typeOfTransaction, f.receiptNo AS receiptNo " +
		       "FROM StudentDetailsEntity s " +
		       "JOIN s.feeDetails f " +
		       "WHERE (:name IS NULL OR TRIM(s.name) = TRIM(:name))  " +
		       "AND (:admissionNo IS NULL OR s.admissionNo = :admissionNo) " +
		       "AND (:classAndSection IS NULL OR s.classAndSection = :classAndSection)")
		List<Map<String, Object>> findStudentAndFeeDetails(
		    @Param("name") String name,
		    @Param("admissionNo") Long admissionNo,
		    @Param("classAndSection") String classAndSection);

}
