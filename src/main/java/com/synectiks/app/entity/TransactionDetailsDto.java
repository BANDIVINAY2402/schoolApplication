package com.synectiks.app.entity;

public class TransactionDetailsDto {
	 private String name;
	    private Long admissionNo;
	    private String classAndSection;
	   
	    private String typeOfTransaction;
	    
	    private String paymentNo;
		private Integer amountPaid;
	

	


	


	public TransactionDetailsDto(String name, Long admissionNo, String classAndSection, String typeOfTransaction,
				String paymentNo, Integer amountPaid) {
			super();
			this.name = name;
			this.admissionNo = admissionNo;
			this.classAndSection = classAndSection;
			this.typeOfTransaction = typeOfTransaction;
			this.paymentNo = paymentNo;
			this.amountPaid = amountPaid;
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

	


	


	public String getPaymentNo() {
		return paymentNo;
	}



	public void setPaymentNo(String paymentNo) {
		this.paymentNo = paymentNo;
	}



	public Integer getAmountPaid() {
		return amountPaid;
	}



	public void setAmountPaid(Integer amountPaid) {
		this.amountPaid = amountPaid;
	}



	@Override
	public String toString() {
		return "StudentDetailsOfThisMonthTransactionDto [name=" + name + ", admissionNo=" + admissionNo
				+ ", classAndSection=" + classAndSection + ", typeOfTransaction=" + typeOfTransaction + ", paymentNo="
				+ paymentNo + ", amountPaid=" + amountPaid + "]";
	}



}
