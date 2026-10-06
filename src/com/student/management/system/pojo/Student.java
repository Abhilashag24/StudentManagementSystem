package com.student.management.system.pojo;

import java.util.ArrayList;
import java.util.List;

public class Student {

	private String name;
	private int age;
	private String studentId;
	private List<String> courses;

	public Student(String name, int age, String studentId) {
		super();
		if (validateAge(age) && validateName(name) && validateStudentId(studentId)) {

			this.name = name;
			this.age = age;
			this.studentId = studentId;
			courses = new ArrayList<String>();
		}
	}

	private boolean validateStudentId(String studentId) {
		if (studentId.matches("^S-\\d+$")) {
			return true;
		} else {
			System.err.println("Invalid Student ID... Id Should strats with S-");
			return false;
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (validateName(name)) {
			this.name = name;
		} else {
			System.err.println("Invalid Name!!");
		}

	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (validateAge(age)) {
			this.age = age;
		} else {
			System.err.println("Invalid Age !! Students age needs to be in between 19 and 35");
		}
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		if (studentId.matches("^S-\\d+$")) {
			this.studentId = studentId;
		} else {
			System.err.println("Invalid Student ID... Id Should strats with S-");

		}

	}

	public List<String> getCourses() {
		return courses;
	}

	public void setCourses(List<String> courses) {
		this.courses = courses;
	}

	// to add a course to the `courses` list.
	public void enrollCourse(String course) {
		if (validateCourseName(course)) {
			if (!courses.contains(course)) {
				courses.add(course);
				System.out.println("Student is enrolled to the " + course + " successfully!!!");
			} else {
				System.err.println("Student is already enrolled to the course " + course);
			}
		}
	}

	// to display the student’s name, age, student ID, and a list of enrolled
	// courses
	public void printStudentInfo() {
		System.out.println("************** Student Data **************");
		System.out.println("Student Name: " + name);
		System.out.println("Student Age: " + age);
		System.out.println("Student Id: " + studentId);
		System.out.println("Courses Enrolled Info: "+courses);
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", studentId=" + studentId + ", courses=" + courses + "]";
	}

	public boolean validateAge(int age) {
		if (age >= 19 && age <= 35) {
			return true;
		} else
			System.err.println("Invalid Age !! Students age needs to be in between 19 and 35");
		return false;
	}

	public boolean validateName(String name) {
		if (name == null || name.isEmpty() || !name.matches("^[a-zA-Z\\s]+$")) {
			System.err.println("Invalid Name!!");
			return false;
		} else {
			return true;
		}
	}

	public boolean validateCourseName(String course) {
		if (course.equalsIgnoreCase("Java") || course.equalsIgnoreCase("DSA") || course.equalsIgnoreCase("DevOps")) {
			return true;
		} else {
			System.err.println("Invalid Course Name!!! You can only enroll to the courses : Java/DSA/DevOps");
			return false;
		}
	}
}
