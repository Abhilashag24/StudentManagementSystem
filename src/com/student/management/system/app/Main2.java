package com.student.management.system.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import javax.sound.midi.SysexMessage;

import com.student.management.system.pojo.Student;

public class Main2 {
	private static List<Student> studentList = null;

	public static void main(String[] args) {

		System.out.println("*********  Student Management System *********");

		studentList = new ArrayList<Student>();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("********* Welcome *********");
			System.out.println("Select an Option....");
			System.out.println("1. Register a Student");
			System.out.println("2. Find Student with Student ID");
			System.out.println("3. Get All information of  Students");
			System.out.println("4. List Student information in sorted order");
			System.out.println("5. Exit");

			int option = sc.nextInt();

			switch (option) {
			case 1:
				enrollStudent(sc);
				break;
			case 2:
				findStudentById(sc);
				break;
			case 3:
				printAllStudentsData();
				break;
			case 4:
				sortByName();
				break;
			case 5:
				exit();
				break;
			default:
				System.err.println("Invalid Option Selected ... Select between 1 to 5");
				break;
			}
		}

	}

	private static void printAllStudentsData() {
		System.out.println("-------------Printing All Students Data-------------");
		if(studentList.size()>0) {
		for (Student student : studentList) {
			student.printStudentInfo();
		}
		}else {
			System.err.println("Student List is Empty!! No Student Found.....");
		}
	}

	private static void exit() {
		System.out.println("Thank YOU !!!!");
		System.exit(0);
	}

	private static void findStudentById(Scanner sc) {
		
		 System.out.println("Enter the Student ID : ");
		 String studentId = sc.next();
		Student studentFound=null;
		try {
			studentFound = studentList.stream().filter(student -> student.getStudentId().equalsIgnoreCase(studentId)).findFirst()
					.orElseThrow(() -> new RuntimeException("No data Found!!"));
		} catch (RuntimeException e) {
			System.err.println("Student with ID " + studentId + " not found!!");
		}
		studentFound.printStudentInfo();
	}

	private static void enrollStudent(Scanner sc) {
		System.out.println("Enter Student Name ....");
		String studenName = sc.next();
		System.out.println("You have entered the name : " + studenName);

		System.out.println("Enter Student Age ....");
		int studentAge = sc.nextInt();
		System.out.println("The students age is : " + studentAge);

		System.out.println("Enter Student ID ....");
		String studentId = sc.next();
		System.out.println("You have entered the ID : " + studentId);

		Student newStudent = new Student(studenName, studentAge, studentId);
		studentList.add(newStudent);

		while (true) {
			System.out.println("Enter the course tobe enrolled !!..Type Done to exit");
			String courseName = sc.next();
			if (!courseName.equalsIgnoreCase("done")) {
				newStudent.enrollCourse(courseName);
			} else {
				break;
			}
		}
		newStudent.printStudentInfo();
	}

	private static void sortByName() {
		if(studentList.size()>0) {
		Comparator<Student> studentComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());
		Collections.sort(studentList, studentComparator);
		System.out.println(studentList);
		}
		else {
			System.err.println("Student List is Empty!! No Students Found to sort....");
		}
		printAllStudentsData();
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
