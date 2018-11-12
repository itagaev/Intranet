import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
   public static ArrayList<Student> students;
    public static ArrayList<Teacher> teachers;
    public static int currentyear = 2018;
    public static void main(String[] args){
        HashMap<String, String> courses = new HashMap<String, String>();
        students = new ArrayList<Student>();
        teachers = new ArrayList<Teacher>();
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


    }
}
