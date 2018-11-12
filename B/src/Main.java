import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static String initpath;
   public static ArrayList<Student> students;
    public static ArrayList<Teacher> teachers;
    public static ArrayList<Course> coursesreg;
    public static int currentyear = 2018;
    public static void main(String[] args){
        initpath = "D:\\ProjectAttempts\\B\\src\\actions";
        HashMap<String, String> courses = new HashMap<String, String>();

        students = new ArrayList<Student>();
        teachers = new ArrayList<Teacher>();
        coursesreg = new ArrayList<Course>();
        try{
            FileReader fr = new FileReader("D:\\ProjectAttempts\\B\\src\\courses.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while(line != null){
                String[] c = line.split(" ", 2);
                courses.put(c[0], c[1]);
                line = br.readLine();
            }
            br.close();
        } catch(IOException e){ e.printStackTrace();}

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

         ArrayList<String> o = new ArrayList<String>();
         o.add("VTIPO");
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


         Student s = new Student("Tagaev", "Ilas", "FIT", "lu4wiy", 2, 4);

         s.serialize();
         Student d = s.deSerialize();
        System.out.println(d);
    }
}
