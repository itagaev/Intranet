import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class Student extends User {
    public String department, speciality;
    public HashMap<Course, Integer> studycourses;
    public int yearOfStudy;
    public Student() {}

    public Student(String surname, String name, String department, String speciality, int yearOfStudy){
        super(surname, name);
        this.department = department;
        this.speciality = speciality;
        studycourses = new HashMap<Course, Integer>();
        this.yearOfStudy = yearOfStudy;
    }

    public Student(String surname, String name, String department, String speciality){
        super(surname, name);
        this.department = department;
        this.speciality = speciality;
        studycourses = new HashMap<Course, Integer>();
        this.yearOfStudy = 1;
    }

    void registerForCourse(Course c){
        this.studycourses.put(c, null);
    }

    void viewCourseMark(String s){
        Iterator it = this.studycourses.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            Course cur = (Course) pair.getKey();
            if(s == cur.courseTitle){
                System.out.println(pair.getValue());
            }
        }
    }

    void viewTranscript(){
        Iterator it = this.studycourses.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }






    public String toString(){
        return  this.surname + " " + this.name +  " " + this.department + "/" + this.yearOfStudy;
    }

    public boolean equals(Object o){
        Student s = (Student)o;
        if(s.surname.equals(this.surname) && s.name.equals(this.name) && s.department.equals(this.department) && s.speciality.equals(this.speciality)) return true;
        return false;
    }

    public int hashCode(){
        return this.surname.hashCode() * this.name.hashCode() * this.department.hashCode() * this.speciality.hashCode();
    }

    public void hu(Object o){
        if(o instanceof Student){
            System.out.println("Student");
        }
        if(o instanceof  Teacher){
            System.out.println("Teacher");
        }
    }

}
