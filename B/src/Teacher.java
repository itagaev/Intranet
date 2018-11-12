import java.util.HashSet;
import java.util.Iterator;
import java.util.HashSet;

public class Teacher extends User{
    private double salary;
    public String department;
    HashSet<Course> mycourses = new HashSet<Course>();

   public Teacher() {}

   public Teacher(String surname, String name, String department, double salary){
        super(surname, name);
        this.department = department;
        this.salary = salary;
   }
    public String toString(){
        return "My name is " + this.surname + " " + this.name + ". I am teacher";
    }

    void setSalary(double salary){ this.salary = salary;}
    double getSalary() {return this.salary;}

    void addCourse(Course c){
       this.mycourses.add(c);
    }

    void deleteCourse(String nameOfCourse){
        Iterator it = mycourses.iterator();
        while(it.hasNext()){
            Course t = (Course)it.next();

            if(t.courseTitle.equals(nameOfCourse)){
               this.mycourses.remove(t);
               break;
            }
        }
    }

    void viewCourses(){
        Iterator it = mycourses.iterator();
        while(it.hasNext()){
            System.out.println(it.next());

        }

    }

     void putMark(Student s, Course c, int mark){
       s.studycourses.put(c, mark);
     }
    public boolean equals(Object o){
        Teacher t = (Teacher)o;
        if(t.surname.equals(this.surname) && t.name.equals(this.name)) return true;
        return false;
    }

    public int hashCode(){
        return this.surname.hashCode() * this.name.hashCode() * this.department.hashCode() * (int)this.salary * 31;
    }
}
