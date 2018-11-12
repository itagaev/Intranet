import java.io.*;
import java.util.*;

public class Student extends User implements Viewable, Cloneable, Serializable {
    public static int id  = 1;
    int realid;

    public String department, speciality, surname, name;
    public double GPA;
    public HashMap<Course, Integer> studycourses;
    String path;

    public int yearOfStudy;
    File actions;
    public Student() {}

    public Student(String surname, String name, String department, String speciality, int yearOfStudy, double GPA){
       this.surname = surname;
       this.name = name;
        this.department = department;
        this.speciality = speciality;
        studycourses = new HashMap<Course, Integer>();
        this.yearOfStudy = yearOfStudy;
        actions = new File(Main.initpath + "\\" + this.surname + this.name);
        try{
            if(!actions.exists())
            actions.createNewFile();
        } catch(IOException e){
            System.out.println("Error");
        }
         this.GPA = GPA;
        this.realid = this.id;
        this.id++;
       path = "student" + this.realid + ".ser";
    }

    public Student(String surname, String name, String department, String speciality){
        this.surname = surname;
        this.name = name;
        this.department = department;
        this.speciality = speciality;
        studycourses = new HashMap<Course, Integer>();
        this.yearOfStudy = 1;
        actions = new File(Main.initpath + "\\" + this.surname + this.name);
        try{
            if(!actions.exists())
                actions.createNewFile();
        } catch(IOException e){
            System.out.println("Error");
        }
        path = "student" + this.realid + ".ser";
    }

    void registerForCourse(Course c){
        this.studycourses.put(c, null);

        try{
            FileWriter fw = new FileWriter(this.actions, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("Student registered for the course " + c.courseTitle);
            bw.newLine();

             bw.close();

        } catch(IOException e) {
            System.out.println("Error");
        }
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

    public void viewTranscript(){
        Iterator it = this.studycourses.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " " + pair.getValue());
        }

    }


   public void view(){
        for(Student s : Main.students){
            System.out.println(s);
        }
   }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
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

    void serialize(){

        try {


            FileOutputStream fos = new FileOutputStream(this.path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            Student s = null;
            try {
               s = (Student) this.clone();


            }catch(CloneNotSupportedException e){
                System.out.println("Error clone");
            }
            oos.writeObject(s);
            oos.close();
            fos.close();
        } catch(IOException e){
            System.out.println("Error io");
        }
    }
    Student deSerialize(){
        Student s = null;
        try{
            FileInputStream fis = new FileInputStream(this.path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            s = (Student)ois.readObject();
            System.out.println(s);
            ois.close();
            fis.close();
        }catch(IOException e){
            System.out.println("Error");
        } catch(ClassNotFoundException e){
            System.out.println("Error class");
        }
        return s;
    }
}
