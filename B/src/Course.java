import jdk.jfr.Percentage;

import java.util.ArrayList;
import java.util.Iterator;

public class Course {
    String courseTitle, description, speciality;
    ArrayList<String> specialities;
    int yearOfStudy;

    public Course() {}

    public Course(String courseTitle, String description, int yearOfStudy, ArrayList<String> specialities){
        this.courseTitle = courseTitle;
        this.description = description;
        this.yearOfStudy = yearOfStudy;
        for(String s : specialities){
            this.specialities.add(s);
        }
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



    public static class CourseFile {
        ArrayList<String> paths;
        Course curcourse;
        public CourseFile() {}

        public CourseFile(Course curcourse, String ...a){
            this.curcourse = curcourse;
            for(String s : a){
                paths.add(s);
            }
        }
        void addPath(String p){
            paths.add(p);
        }
        void viewCourseFiles(){
            Iterator it = this.paths.iterator();
            while(it.hasNext()){
                System.out.println(it.next());
            }
        }
    }


}