package actor;

import academic.*;
import java.util.*;

public class Lecturer extends Actor implements IAttendee{
	public String lecturerCode;
    public ArrayList<Course> courses = new ArrayList<>();

    public Lecturer(String lecturerCode, String name, String dob) {
        super(name, dob);
        this.lecturerCode = lecturerCode;
    }

    public String getLecturerCode() {
        return lecturerCode;
    }

    public void setLecturerCode(String lecturerCode) {
        this.lecturerCode = lecturerCode;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    @Override
    public void takeAttendance() {
        System.out.println(name + " is taking attendance");
    }

    public void showCourse(int i){
        System.out.println(name + " is teaching");
        for(Course course: courses){
            if(course.getCredit() == i){
                System.out.println("- " + course.getCourseName());
            }
        }
    }
}
