package com.example.demo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="student",schema="env_task_manager")
@Setter
@Getter
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@GeneratedValue(generator="id-gen")
	//@GenericGenerator(name="id-gen",strategy="com.example.demo.StudentIdGenerator")
	@Column(name="studentId")
	private Long studentId;
	
	@Column(name="studentName",length=255,nullable=false)
	private String studentName;
	
	@Temporal(TemporalType.DATE)
	@Column(name="birthDate",nullable=false)
	private Date birthDate;
	
	@OneToOne(mappedBy = "student", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private StudentInfo studentInfo;

}
