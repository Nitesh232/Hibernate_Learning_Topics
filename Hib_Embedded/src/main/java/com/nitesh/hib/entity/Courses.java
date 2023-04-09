package com.nitesh.hib.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Courses {
	
	private String courseName;
	
	private String courseDuration;
	
	private String instructor;

	public Courses(String courseName, String courseDuration, String instructor) {
		this.courseName = courseName;
		this.courseDuration = courseDuration;
		this.instructor = instructor;
	}

	public Courses() {
		
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "Courses [courseName=" + courseName + ", courseDuration=" + courseDuration + ", instructor=" + instructor
				+ "]";
	}
	
		

}
