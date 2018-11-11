/**
 * 
 */
package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author vignesh
 *
 */

@Entity
@Table(name="student_info",schema="env_task_manager")
@Setter
@Getter
public class StudentInfo {
	
	@Id
	@GenericGenerator(name="generator", strategy="foreign", parameters = {
			@Parameter(name = "property", value = "student")
	})
	@GeneratedValue(generator="generator")
	@Column(name="studentId")
	private Long studentId;
	
	@Column(name="studentPhone",length=10,nullable=false)
	private String studentPhone;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="studentId")
	private Student student;

}
