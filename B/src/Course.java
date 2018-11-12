import java.util.ArrayList;
import java.util.Iterator;

public class Course {
    String courseTitle, description, speciality, department;
    ArrayList<String> specialities = new ArrayList<String>();
    int yearOfStudy;
    ArrayList<Student> students = new ArrayList<Student>();
    ArrayList<CourseFile> files = new ArrayList<CourseFile>();

    public Course() {}

    public Course(String courseTitle, String description, int yearOfStudy, String department, String ...a){
        this.courseTitle = courseTitle;
        this.description = description;
        this.yearOfStudy = yearOfStudy;
        this.department = department;
        for(String h : a){
            this.specialities.add(h);
        }
        students = new ArrayList<Student>();
    }

    void dialStudents(){
        Iterator it = Main.students.iterator();
        while(it.hasNext()){
            Student s = (Student)it.next();
            if(s.yearOfStudy == this.yearOfStudy && this.specialities.indexOf(s.speciality) >= 0){
                this.students.add(s);
            }
        }
    }
    void addFile(String name, String path){
        CourseFile c = new CourseFile(name, path);
        this.files.add(c);
    }

    void addFile(CourseFile file){
        this.files.add(file);
    }
    @Override
    public boolean equals(Object o ){
        Course c = (Course)o;
        if(c.courseTitle == this.courseTitle) return true;
        return false;
    }

    @Override
    public String toString(){
        return this.courseTitle;
    }

    @Override
    public int hashCode(){
        return this.courseTitle.hashCode() * this.description.hashCode() * this.yearOfStudy * 31;
    }
}