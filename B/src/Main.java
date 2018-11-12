import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static String initpath;
   public static ArrayList<Student> students;
    public static ArrayList<Teacher> teachers;
    public static ArrayList<Course> coursesreg;
    public static int currentyear;
    public static void main(String[] args){

        initpath = "D:\\ProjectAttempts\\B\\src\\actions";
        currentyear = 2018;
        students = new ArrayList<Student>();
        teachers = new ArrayList<Teacher>();
        coursesreg = new ArrayList<Course>();
        students.add(new Student("Makatov", "Samat", "FIT", "VTIPO", 2, 2.9));
        students.add(new Student("Saidagali", "Adil", "FIT", "VTIPO", 2, 3.34));
        students.add(new Student("Tagaev", "Ilyas", "FIT", "VTIPO", 2, 3.35));
        students.add(new Student("Tursyn", "Makhmut", "FIT", "AU", 2, 3.5));
        teachers.add(new Teacher("Baisakov", "Beisenbek", "FIT"));
        teachers.add(new Teacher("Akshabayev", "Askar", "FIT"));
        teachers.add(new Teacher("Mukhsimbayev", "Bobur", "FIT"));
        ArrayList<String> fit = new ArrayList<String>();

        coursesreg.add(new Course("OOP", "Good subject", 2, "FIT", "IS", "VTIPO"));
        coursesreg.add(new Course("Algorithms and Data Structures", "Hard subject", 2, "FIT", "VTIPO", "IS", "AU"));
        coursesreg.add(new Course("Finance", "Excellent",1,"Finance", "Audit"));

        CourseFile file1 = new CourseFile("Object book", "D:\\ProjectAttempts\\B\\src\\files\\oop.txt");
        coursesreg.get(0).files.add(file1);
        coursesreg.get(0).dialStudents();
        coursesreg.get(1).dialStudents();
        Iterator it = coursesreg.get(0).students.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        Iterator it1 = coursesreg.get(1).students.iterator();
        while(it1.hasNext()){
            System.out.println(it1.next());
        }






    }
}
   /* Student s = new Student("Tagayev", "Ilyas", "FIT", "VTIPO" , 2, 4);
         Course c = new Course("OOP", "F", 2, o);

         Teacher t = new Teacher("O", "OO", "FIT", 400000);
         s.registerForCourse(c);
         t.addCourse(c);
         t.deleteCourse("OOP");
         t.putMark(s, c, 30);
         Admin petuh = new Admin();
         petuh.seeLogFiles(t);
         */
       /* Teacher t = new Teacher("O", "OO", "FIT", 400000);
        Teacher t2 = new Teacher("A", "AA", "BS", 45000);
        teachers.add(t);
        teachers.add(t2);
        Manager m = new Manager();
        m.viewInfo("Teachers");
        */


       /* test delete, add courses
        Teacher t = new Teacher("Ivan", "Ivanov", "FIT", 500000);
        Iterator it = courses.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            String j = (String)pair.getKey();
            String[] fit = j.split("/");
            if(fit[0].equals(t.department)){
                String o = (String)pair.getValue();

                t.addCourse(new Course(o, "JAi"));
            }
            it.remove();
        }
        t.viewCourses();
        t.deleteCourse("Programming Principles 2018");
        t.viewCourses();
        */

       /*
       Student s = new Student("Tagaev", "Ilas", "FIT", "lu4wiy", 2, 4);

         s.serialize();
         Student d = s.deSerialize();
        System.out.println(d);
        */