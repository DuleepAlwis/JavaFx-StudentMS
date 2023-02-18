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
@Table(name="subject_student_tb")
public class SubjectStudentEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@ManyToOne
	@JoinColumn(name="subject_id", nullable=false)
	private SubjectEntity subject_id;
	
	@ManyToOne
	@JoinColumn(name="student_id",nullable=false)
	private StudentEntity student_id;
	
	@Column(name="creditsEarned")
	private int creditsEarned;
	
	@Column(name="marks")
	private double marks;
	
	@Column(name="attempt")
	private int attempt;
	
	@Column(name="grade")
	private String grade;

	public SubjectStudentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SubjectStudentEntity(long id, SubjectEntity subject_id, StudentEntity student_id, int creditsEarned,
			double marks, int attempt, String grade) {
		super();
		this.id = id;
		this.subject_id = subject_id;
		this.student_id = student_id;
		this.creditsEarned = creditsEarned;
		this.marks = marks;
		this.attempt = attempt;
		this.grade = grade;
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

	public StudentEntity getStudent_id() {
		return student_id;
	}

	public void setStudent_id(StudentEntity student_id) {
		this.student_id = student_id;
	}

	public int getCreditsEarned() {
		return creditsEarned;
	}

	public void setCreditsEarned(int creditsEarned) {
		this.creditsEarned = creditsEarned;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public int getAttempt() {
		return attempt;
	}

	public void setAttempt(int attempt) {
		this.attempt = attempt;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "SubjectStudentEntity [id=" + id + ", subject_id=" + subject_id + ", student_id=" + student_id
				+ ", creditsEarned=" + creditsEarned + ", marks=" + marks + ", attempt=" + attempt + ", grade=" + grade
				+ "]";
	}
	
	
}
