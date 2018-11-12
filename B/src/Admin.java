public class Admin extends User {
    public Admin() {}
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
                 stu = new Student(a[0], a[1], a[2], a[3], Integer.parseInt(a[4]));
             Main.students.set(index, stu);
        }
        if(o instanceof Teacher) {
            Teacher s = (Teacher)o;
            int index = Main.teachers.indexOf(s);
            Teacher stu = new Teacher(a[0], a[1], a[2], Double.parseDouble(a[3]));
            Main.teachers.set(index, stu);
        }
    }



    public String toString(){
        return  this.surname + " " + this.name +  ". I am admin";
    }

    public boolean equals(Object o){
        Student s = (Student)o;
        if(s.surname.equals(this.surname) && s.name.equals(this.name)) return true;
        return false;
    }

    public int hashCode(){
        return this.surname.hashCode() * this.name.hashCode();
    }
}
