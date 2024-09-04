package com.synectiks.app.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class FeeDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paymentNo;
	private String feeType;
	private Integer totalDue;
	private Integer amountPaid;
	private Date amountPaidDate;
	private Date dueDate;
	private String status;
	private String receiptNo;
	private String typeOfTransaction;
	@ManyToOne
	@JoinColumn(name="admissionNo")
	@JsonIgnore
	private StudentDetailsEntity student;
	public Long getPaymentNo() {
		return paymentNo;
	}
	public void setPaymentNo(Long paymentNo) {
		this.paymentNo = paymentNo;
	}
	public String getFeeType() {
		return feeType;
	}
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	public Integer getTotalDue() {
		return totalDue;
	}
	public void setTotalDue(Integer totalDue) {
		this.totalDue = totalDue;
	}
	public Integer getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(Integer amountPaid) {
		this.amountPaid = amountPaid;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReceiptNo() {
		return receiptNo;
	}
	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}
	public Date getAmountPaidDate() {
		return amountPaidDate;
	}
	public void setAmountPaidDate(Date amountPaidDate) {
		this.amountPaidDate = amountPaidDate;
	}
	public StudentDetailsEntity getStudent() {
		return student;
	}
	public void setStudent(StudentDetailsEntity student) {
		this.student = student;
	}
	
	
	public String getTypeOfTransaction() {
		return typeOfTransaction;
	}
	public void setTypeOfTransaction(String typeOfTransaction) {
		this.typeOfTransaction = typeOfTransaction;
	}
		
	
	@Override
	public String toString() {
		return "FeeDetails [paymentNo=" + paymentNo + ", feeType=" + feeType + ", totalDue=" + totalDue
				+ ", amountPaid=" + amountPaid + ", amountPaidDate=" + amountPaidDate + ", dueDate=" + dueDate
				+ ", status=" + status + ", receiptNo=" + receiptNo + ", typeOfTransaction=" + typeOfTransaction
				;
	}
	

}
