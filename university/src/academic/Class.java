package academic;

import actor.*;
import java.util.*;

public class Class {
	private String classCode;
	private String year;
	private int semester;

	private ArrayList<Course> courses = new ArrayList<>();
	private ArrayList<Student> students = new ArrayList<>();
	private ArrayList<Student> presentStudents = new ArrayList<>();
	private ArrayList<Lecturer> lecturers = new ArrayList<>();

	public Class(String classCode, int semester, String year) {
		this.classCode = classCode;
		this.semester = semester;
		this.year = year;
	}

	public void addCourse(Course course) {
		courses.add(course);
		System.out.println(course.getCourseName() + " has been added to the class.");
	}

	public void addStudent(Student student) {
		students.add(student);
		for(Course course : courses){
			student.addCourse(course);
		}
		System.out.println(student.getName() + " has been added to the class.");
	}

	public void addLecturer(Lecturer lec, Course course) {
		lecturers.add(lec);
		lec.addCourse(course);
		System.out.println(lec.getName() + " has been added to the class.");
	}

	public void attend(IAttendant attendant) {
		attendant.attend();
		if(attendant instanceof Student student){
			presentStudents.add(student);
		}
	}

	public void takeAttendance(IAttendee attendee){
		attendee.takeAttendance();
	}

	public void showTodayAttendance(){
		System.out.println("Today's attendance:");
		for(Student student : presentStudents){
			System.out.println("- " + student.getName() + " (" + student.getNim() + ")");
		}
	}
}
