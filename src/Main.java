import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/endterm_oop";
        String user = "postgres";
        String password = "13062013";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("фывапролд");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
