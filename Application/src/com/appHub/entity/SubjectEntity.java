package com.appHub.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.appHub.enums.Degree;

@Entity
@Table(name="subject_tb")
public class SubjectEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="degree")
	private Degree degree;
	
	@Column(name="name")
	private String name;
	
	@Column(name="credits")
	private int credits;
	
	@Column(name="academicYear")
	private String academicYear;
	
	@Column(name="semester")
	private String semester;

	@OneToMany(mappedBy="subject_id" , targetEntity = SubjectTutorEntity.class)
	private List<SubjectTutorEntity> subjectTutor;
	
	@OneToMany(mappedBy="subject_id",targetEntity=SubjectStudentEntity.class)
	private List<SubjectStudentEntity> subjectStudent;
	
	
	
	public List<SubjectStudentEntity> getSubjectStudent() {
		return subjectStudent;
	}

	public void setSubjectStudent(List<SubjectStudentEntity> subjectStudent) {
		this.subjectStudent = subjectStudent;
	}

	public List<SubjectTutorEntity> getSubjectTutor() {
		return subjectTutor;
	}

	public void setSubjectTutor(List<SubjectTutorEntity> subjectTutor) {
		this.subjectTutor = subjectTutor;
	}

	public SubjectEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SubjectEntity(long id, Degree degree, String name, int credits, String academicYear, String semester) {
		super();
		this.id = id;
		this.degree = degree;
		this.name = name;
		this.credits = credits;
		this.academicYear = academicYear;
		this.semester = semester;
	}

	public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	@Override
	public String toString() {
		return "SubjectEntity [id=" + id + ", degree=" + degree + ", name=" + name + ", credits=" + credits
				+ ", academicYear=" + academicYear + ", semester=" + semester + "]";
	}
	
	
}
