package actor;

import academic.*;
import java.util.*;

public class Student extends Actor implements IAttendant {
	public String nim;
	public ArrayList<Course> courses = new ArrayList<>();

	public Student(String nim, String name, String dob) {
		super(name, dob);
		this.nim = nim;
	}

    public String getNim() {
        return nim;
    }
	public void setNim(String nim) {
		this.nim = nim;
	}

	@Override
	public void attend() {
		System.out.println(name + " is attending the class");
	}

	public void addCourse(Course course) {
		this.courses.add(course);
	}

	public void showCredits(int i){
		int credit = 0;
		System.out.println(name + " credits for semester " + i + ":");
		for(Course course: courses){
			if(course.getCredit() == i){
				credit += course.getCredit();
				System.out.println("- " + course.getCourseName() + " (" + course.getCredit() + ")");
			}
		}
		System.out.println("Total credits: " + credit);
	}

}
