import java.util.ArrayList;
import java.util.Collections;

public class Manager extends User  {
    String surname, name;
    public Manager() {}

    public Manager(String surname, String name){
      this.surname = surname;
      this.name = name;
    }

    public void addCourseRegistration(String courseTitle, String description, int yearOfStudy, String departmet, String ...s){
        Main.coursesreg.add(new Course(courseTitle, description, yearOfStudy, departmet, s));
    }

    public void viewInfo(String s){
        if(s == "Teachers"){
            Collections.sort(Main.teachers);
        }
        for(Teacher t : Main.teachers){
            System.out.println(t);
        }
    }

    public String toString(){
        return  this.surname + " " + this.name +  ". manager";
    }

    public boolean equals(Object o){
        Student s = (Student)o;
        if(s.surname.equals(this.surname) && s.name.equals(this.name)) return true;
        return false;
    }

    public int hashCode(){
        return this.surname.hashCode() * this.name.hashCode();
    }
}
