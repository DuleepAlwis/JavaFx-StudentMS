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

import com.appHub.enums.Gender;

@Entity
@Table(name="tutor_tb")
public class TutorEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tutor_user_id")
    private UserEntity user;
	
	@Column(name="name")
	private String name;
	
	@Column(name="doj")
	private Date doj;
	
	@Column(name="dob")
	private Date dob;
	
	@Column(name="qualification")
	private String qualification;
	
	@Column(name="nic")
	private String nic;
	
	@Column(name="gender")
	private Gender gender;

	@OneToMany(mappedBy="tutor_id" , targetEntity = SubjectTutorEntity.class)
	private List<SubjectTutorEntity> tutorSubjects;
	
	public TutorEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TutorEntity(long id, UserEntity user, String name, Date doj, Date dob, String qualification, String nic,
			Gender gender) {
		super();
		this.id = id;
		this.user = user;
		this.name = name;
		this.doj = doj;
		this.dob = dob;
		this.qualification = qualification;
		this.nic = nic;
		this.gender = gender;
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

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "TutorEntity [id=" + id + ", user=" + user + ", name=" + name + ", doj=" + doj + ", dob=" + dob
				+ ", qualification=" + qualification + ", nic=" + nic + ", gender=" + gender + "]";
	}
	
	
}
