package com.synectiks.app.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class StudentDetailsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long admissionNo;
	private String name;
	private String fatherName;
	
	private String motherName;
	
	private Long rollNo;
	private String classAndSection;
	private Date dateOfBirth;
	//@Column(unique = true)
	private Long aadharno;
	private String schoolTransport;
	

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
  //  @JsonIgnore
    private List<FeeDetails> feeDetails;


	public Long getAdmissionNo() {
		return admissionNo;
	}


	public void setAdmissionNo(Long admissionNo) {
		this.admissionNo = admissionNo;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getFatherName() {
		return fatherName;
	}


	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}


	public String getMotherName() {
		return motherName;
	}


	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}


	public Long getRollNo() {
		return rollNo;
	}


	public void setRollNo(Long rollNo) {
		this.rollNo = rollNo;
	}


	public String getClassAndSection() {
		return classAndSection;
	}


	public void setClassAndSection(String classAndSection) {
		this.classAndSection = classAndSection;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public Long getAadharno() {
		return aadharno;
	}


	public void setAadharno(Long aadharno) {
		this.aadharno = aadharno;
	}


	public String getSchoolTransport() {
		return schoolTransport;
	}


	public void setSchoolTransport(String schoolTransport) {
		this.schoolTransport = schoolTransport;
	}


	public List<FeeDetails> getFeeDetails() {
		return feeDetails;
	}


	public void setFeeDetails(List<FeeDetails> feeDetails) {
		this.feeDetails = feeDetails;
	}


	@Override
	public String toString() {
		return "StudentDetailsEntity [admissionNo=" + admissionNo + ", name=" + name + ", fatherName=" + fatherName
				+ ", motherName=" + motherName + ", rollNo=" + rollNo + ", classAndSection=" + classAndSection
				+ ", dateOfBirth=" + dateOfBirth + ", aadharno=" + aadharno + ", schoolTransport=" + schoolTransport
				+ ", feeDetails=" + feeDetails + "]";
	}


	






	


	
	
	
	

}
