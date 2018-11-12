import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

public class Admin extends User {
    String surname, name;
    public Admin() {}
    public Admin(String surname, String name){
        this.surname = surname;
        this.name = name;
    }
    public void addUser(Object o){
         if(o instanceof Student) {
             Student s = (Student)o;
             Main.students.add(s);
         }
        if(o instanceof Teacher) {
            Teacher s = (Teacher)o;
            Main.teachers.add(s);
        }
    }

    public void removeUser(Object o ){
        if(o instanceof Student) {
            Student s = (Student)o;
            Main.students.remove(s);
        }

        if(o instanceof Teacher) {
            Teacher s = (Teacher)o;
            Main.teachers.remove(s);
        }
    }
    public void updateUser(Object o, String ...a){
        if(o instanceof Student) {
             Student s = (Student)o;
             int index = Main.students.indexOf(s);
             Student stu = null;
             if(a.length == 4)
                 stu = new Student(a[0], a[1], a[2], a[3]);
             if(a.length == 5)
                 stu = new Student(a[0], a[1], a[2], a[3], Integer.parseInt(a[4]), Double.parseDouble(a[5]));
             Main.students.set(index, stu);
        }
        if(o instanceof Teacher) {
            Teacher s = (Teacher)o;
            int index = Main.teachers.indexOf(s);
            Teacher stu = new Teacher(a[0], a[1], a[2], Double.parseDouble(a[3]));
            Main.teachers.set(index, stu);
        }
    }

    public void seeLogFiles(Object o){
        if(o instanceof  Student){
            Student s = (Student)o;
            try {
                FileReader fr = new FileReader(s.actions);
                BufferedReader br = new BufferedReader(fr);
                String line = br.readLine();
                System.out.println(line);
                while(line != null){
                    line = br.readLine();
                    System.out.println(line);
                }

            } catch(IOException e){
                System.out.println("Error");
            }
        }
        if(o instanceof  Teacher){
            Teacher s = (Teacher)o;
            try {
                FileReader fr = new FileReader(s.actions);
                BufferedReader br = new BufferedReader(fr);
                String line = br.readLine();
                System.out.println(line);
                while(line != null){
                    line = br.readLine();
                    System.out.println(line);
                }

            } catch(IOException e){
                System.out.println("Error");
            }
        }
    }



    public String toString(){
        return  this.surname + " " + this.name +  ". I am admin";
    }

    public boolean equals(Object o){
        Admin s = (Admin)o;
        if(s.surname.equals(this.surname) && s.name.equals(this.name)) return true;
        return false;
    }

    public int hashCode(){
        return this.surname.hashCode() * this.name.hashCode();
    }
}
