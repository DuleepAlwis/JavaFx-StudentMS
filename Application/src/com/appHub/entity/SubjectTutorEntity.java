package com.appHub.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="subject_tutor_tb")
public class SubjectTutorEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@ManyToOne
	@JoinColumn(name="subject_id", nullable=false)
	private SubjectEntity subject_id;
	
	@ManyToOne
	@JoinColumn(name="tutor_id",nullable=false)
	private TutorEntity tutor_id;
	
	@Column(name="year")
	private String year;
	
	@Column(name="semester")
	private String semester;

	public SubjectTutorEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SubjectTutorEntity(long id, SubjectEntity subject_id, TutorEntity tutor_id, String year, String semester) {
		super();
		this.id = id;
		this.subject_id = subject_id;
		this.tutor_id = tutor_id;
		this.year = year;
		this.semester = semester;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public SubjectEntity getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(SubjectEntity subject_id) {
		this.subject_id = subject_id;
	}

	public TutorEntity getTutor_id() {
		return tutor_id;
	}

	public void setTutor_id(TutorEntity tutor_id) {
		this.tutor_id = tutor_id;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	@Override
	public String toString() {
		return "SubjectTutorEntity [id=" + id + ", subject_id=" + subject_id + ", tutor_id=" + tutor_id + ", year="
				+ year + ", semester=" + semester + "]";
	}
	
	
	
	
}
