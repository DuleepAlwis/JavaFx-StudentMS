package com.appHub.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.appHub.enums.Degree;
import com.appHub.enums.Gender;

@Entity
@Table(name="student_tb")
public class StudentEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_user_id")
    private UserEntity user;
	
	@Column(name="name")
	private String name;
	
	@Column(name="admissionno")
	private String admission;
	
	@Column(name="indexno")
	private String indexno;
	
	@Column(name="dob")
	private Date dob;
	
	@Column(name="doj")
	private Date doj;
	
	@Column(name="batch")
	private String batch;
	
	@Column(name="address")
	private String address;
	
	@Column(name="city")
	private String city;
	
	@Column(name="district")
	private String district;
	
	@Column(name="gender")
	private Gender gender;

	@Column(name="degree")
	private Degree degree;
	
	@OneToMany(mappedBy="student_id",targetEntity=SubjectStudentEntity.class)
	private List<SubjectStudentEntity> subjectStudent;
	
	public List<SubjectStudentEntity> getSubjectStudent() {
		return subjectStudent;
	}

	public void setSubjectStudent(List<SubjectStudentEntity> subjectStudent) {
		this.subjectStudent = subjectStudent;
	}

	public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	public StudentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentEntity(long id, UserEntity user, String name, String admission, String indexno, Date dob, Date doj,
			String batch, String address, String city, String district, Gender gender,Degree degree) {
		super();
		this.id = id;
		this.user = user;
		this.name = name;
		this.admission = admission;
		this.indexno = indexno;
		this.dob = dob;
		this.doj = doj;
		this.batch = batch;
		this.address = address;
		this.city = city;
		this.district = district;
		this.gender = gender;
		this.degree = degree;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdmission() {
		return admission;
	}

	public void setAdmission(String admission) {
		this.admission = admission;
	}

	public String getIndexno() {
		return indexno;
	}

	public void setIndexno(String indexno) {
		this.indexno = indexno;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", user=" + user + ", name=" + name + ", admission=" + admission
				+ ", indexno=" + indexno + ", dob=" + dob + ", doj=" + doj + ", batch=" + batch + ", address=" + address
				+ ", city=" + city + ", district=" + district + ", gender=" + gender + ", degree="+degree+"]";
	}
	
	
}
