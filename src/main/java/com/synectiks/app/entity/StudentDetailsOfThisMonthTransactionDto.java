package com.synectiks.app.entity;

import java.util.Objects;

public class StudentDetailsOfThisMonthTransactionDto {
	
	 private String name;
	    private Long admissionNo;
	    private String classAndSection;
	    private Integer totalAmountPaid;
	    private String typeOfTransaction;
	    

	public StudentDetailsOfThisMonthTransactionDto(String name, Long admissionNo, String classAndSection,
				Integer totalAmountPaid, String typeOfTransaction) {
			super();
			this.name = name;
			this.admissionNo = admissionNo;
			this.classAndSection = classAndSection;
			this.totalAmountPaid = totalAmountPaid;
			this.typeOfTransaction = typeOfTransaction;
		}
	
	
	
	public StudentDetailsOfThisMonthTransactionDto() {
		// TODO Auto-generated constructor stub
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Long getAdmissionNo() {
		return admissionNo;
	}
	public void setAdmissionNo(Long admissionNo) {
		this.admissionNo = admissionNo;
	}
	public String getClassAndSection() {
		return classAndSection;
	}
	public void setClassAndSection(String classAndSection) {
		this.classAndSection = classAndSection;
	}
	public String getTypeOfTransaction() {
		return typeOfTransaction;
	}
	public void setTypeOfTransaction(String typeOfTransaction) {
		this.typeOfTransaction = typeOfTransaction;
	}

	public Integer getTotalAmountPaid() {
		return totalAmountPaid;
	}
	public void setTotalAmountPaid(Integer totalAmountPaid) {
		this.totalAmountPaid = totalAmountPaid;
	}



	@Override
	public String toString() {
		return "StudentDetailsOfThisMonthTransactionDto [name=" + name + ", admissionNo=" + admissionNo
				+ ", classAndSection=" + classAndSection + ", totalAmountPaid=" + totalAmountPaid
				+ ", typeOfTransaction=" + typeOfTransaction + "]";
	}

	

}
