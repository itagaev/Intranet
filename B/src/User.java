public abstract class User {
    public String name, surname;

    public User() {}

    public User(String surname, String name){
        this.name = name;
        this.surname = surname;
    }

    public abstract String toString();
    public abstract int hashCode();
    public abstract boolean equals(Object o);
}
