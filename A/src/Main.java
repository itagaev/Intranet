import java.sql.Connection;
import java.sql.DriverManager;
im

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
          String username = "postgres";
          String password = "postgres";
          String conURL = "jdbc:postgresql://localhost:5432/postgres";

          try{
              Connection connection = DriverManager.getConnection(conURL, username, password);
             System.out.println("We're connectted");
          }  catch(java.sql.SQLException e){
              e.printStackTrace();
          }
    }
}
