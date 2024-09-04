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
import com.synectiks.app.entity.StudentDetailsOfThisMonthTransactionDto;

import jakarta.persistence.Tuple;

@Repository
public interface FeeDetailsRepository extends JpaRepository<FeeDetails, Long> {


	
	@Query("SELECT f.student FROM FeeDetails f WHERE f.amountPaidDate = :amountPaidDate")
    List<StudentDetailsEntity> findByAmountPaidDate(@Param("amountPaidDate") Date date);
	
	@Query("SELECT SUM(f.amountPaid) FROM FeeDetails f WHERE f.amountPaidDate BETWEEN :startDate AND :endDate")
	Long findTotalAmountPaidByYear(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
	
	
//	@Query("SELECT f FROM FeeDetails f WHERE FUNCTION('MONTH', f.paymentDate) = FUNCTION('MONTH', :currentDate) AND FUNCTION('YEAR', f.paymentDate) = FUNCTION('YEAR', :currentDate)")
//	List<FeeDetails> findAllFeesPaidByCurrentMonth(@Param("currentDate") Date currentDate);


//	@Query("SELECT f FROM FeeDetails f WHERE MONTH(f.amountPaidDate) = MONTH(CURRENT_DATE) AND YEAR(f.amountPaidDate) = YEAR(CURRENT_DATE)")
//    List<FeeDetails> findFeesPaidThisMonth1();
////	
//	 @Query("SELECT com.synectiks.app.entity.StudentDetailsOfThisMonthTransactionDto(s.name, s.admissionNo, s.classAndSection, SUM(f.amountPaid), f.typeOfTransaction) " +
//	           "FROM StudentDetailsEntity s " +
//	           "JOIN s.feeDetails f " +
//	           "WHERE EXTRACT(MONTH FROM f.amountPaidDate) = EXTRACT(MONTH FROM CURRENT_DATE) " +
//	           "AND EXTRACT(YEAR FROM f.amountPaidDate) = EXTRACT(YEAR FROM CURRENT_DATE) " +
//	           "GROUP BY s.name, s.admissionNo, s.classAndSection, f.typeOfTransaction")
//	    List<StudentDetailsOfThisMonthTransactionDto> findFeesPaidThisMonth();

	
	@Query("SELECT s.name AS name, s.admissionNo AS admissionNo, s.classAndSection AS classAndSection, " +
		       "SUM(f.amountPaid) AS amountPaid, f.typeOfTransaction AS typeOfTransaction " +
		       "FROM StudentDetailsEntity s JOIN s.feeDetails f " +
		       "WHERE EXTRACT(MONTH FROM f.amountPaidDate) = EXTRACT(MONTH FROM CURRENT_DATE) " +
		       "AND EXTRACT(YEAR FROM f.amountPaidDate) = EXTRACT(YEAR FROM CURRENT_DATE) " +
		       "GROUP BY s.name, s.admissionNo, s.classAndSection, f.typeOfTransaction")
		List<Map<String, Object>> findFeesPaidThisMonth();


}
