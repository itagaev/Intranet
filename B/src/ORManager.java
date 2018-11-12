public class ORManager extends User {
    public ORManager() {};

    public ORManager(String surname, String name){
        super(surname, name);
    }

    public String toString(){
        return "My name is " + this.surname + " " + this.name + ". I am from OR";
    }

    public boolean equals(Object o){
        ORManager or = (ORManager)o;
        if(or.surname.equals(this.surname) && or.name.equals(this.name)) return true;
        return false;
    }

    public int hashCode(){
        return (int)this.surname.hashCode() * this.name.hashCode();
    }
}
