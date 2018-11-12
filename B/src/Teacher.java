import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashSet;
enum JobTitle{
    TUTOR,
    LECTOR,
    SENIOR_LECTOR,
    PROFESSOR
}
public class Teacher extends User implements Comparable<Teacher>{
    private double salary;
    public String department, surname, name;
    HashSet<Course> mycourses = new HashSet<Course>();
    File actions;
    JobTitle jt;

   public Teacher() {}

   public Teacher(String surname, String name, String department, double salary){
        this.surname = surname;
        this.name = name;
        this.department = department;
        this.salary = salary;
       actions = new File(Main.initpath + "\\" + this.surname + this.name + "Teacher");
       try{
           if(!actions.exists())
               actions.createNewFile();
       } catch(IOException e){
           System.out.println("Error");
       }
   }

    public Teacher(String surname, String name, String department, double salary, JobTitle jt){
        this.surname = surname;
        this.name = name;
        this.department = department;
        this.salary = salary;
        actions = new File(Main.initpath + "\\" + this.surname + this.name + "Teacher");
        try{
            if(!actions.exists())
                actions.createNewFile();
        } catch(IOException e){
            System.out.println("Error");
        }
        this.jt = jt;
    }
    public String toString(){
        return "My name is " + this.surname + " " + this.name + ". I am teacher";
    }

    void setSalary(double salary){ this.salary = salary;}
    double getSalary() {return this.salary;}

    void addCourse(Course c){
       this.mycourses.add(c);
        try{
            FileWriter fw = new FileWriter(this.actions, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("Teacher added the course " + c.courseTitle);
            bw.newLine();

            bw.close();

        } catch(IOException e) {
            System.out.println("Error");
        }
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
        try{
            FileWriter fw = new FileWriter(this.actions, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("Teacher deleted the course" + nameOfCourse);
            bw.newLine();

            bw.close();

        } catch(IOException e) {
            System.out.println("Error");
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
         try{
             FileWriter fw = new FileWriter(this.actions, true);
             BufferedWriter bw = new BufferedWriter(fw);

             bw.write("Teacher putted the the mark " + mark + " to student " + s.name + " " + s.surname);
             bw.newLine();

             bw.close();

         } catch(IOException e) {
             System.out.println("Error");
         }
     }
    public boolean equals(Object o){
        Teacher t = (Teacher)o;
        if(t.surname.equals(this.surname) && t.name.equals(this.name)) return true;
        return false;
    }

    public int hashCode(){
        return this.surname.hashCode() * this.name.hashCode() * this.department.hashCode() * (int)this.salary * 31;
    }

    public int compareTo(Teacher t){
       String test = this.surname + this.name;
       String test1 = t.surname + this.name;
       return test.compareTo(test1);
    }
}
