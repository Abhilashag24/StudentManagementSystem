package com.student.management.system.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.management.RuntimeErrorException;

import com.student.management.system.pojo.Student;

public class Main {
	private static List<Student> studentList = null;

	public static void main(String[] args) {

		System.out.println("*********  Student Management System *********");
		System.out.println("********* Welcome *********");

		studentList = new ArrayList<Student>();

		Student s1 = new Student("Jatin", 19, "S-898");
		s1.enrollCourse("Java");
		s1.enrollCourse("DevOps");
		s1.enrollCourse("DSA");

		s1.printStudentInfo();
		studentList.add(s1);

		Student s2 = new Student("Uday", 20, "S-998");
		s2.enrollCourse("DevOps");
		s2.enrollCourse("DSA");
		s2.printStudentInfo();
		studentList.add(s2);

		Student s3 = new Student("Neha", 30, "S-798");
		s3.enrollCourse("Java");
		s3.enrollCourse("DevOps");
		s3.printStudentInfo();
		studentList.add(s3);

		Student result = findStudentById("S-98");
		System.out.println(result);

		sortByName();
		 
	}

	private static void sortByName() {
		Comparator<Student> studentComparator =  (o1,o2) -> o1.getName().compareTo(o2.getName());
		Collections.sort(studentList, studentComparator);
		System.out.println(studentList);
	}

	public static Student findStudentById(String studentId) {
		Student result = null;
		try {
			result = studentList.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId)).findFirst()
					.orElseThrow(() -> new RuntimeException("No data Found!!"));
		} catch (RuntimeException e) {
			System.err.println("Student with ID " + studentId + " not found!!");
		}
		return result;
	}
}
