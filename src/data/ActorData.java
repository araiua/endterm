import java.sql.*;

public class ActorData {
    private static final String url = "jdbc:postgresql://localhost:5432/endterm_oop";
    private static final String user = "postgres";
    private static final String password = "13062013";

    public void addActor(String firstName, String lastName) {
        String sql = "INSERT INTO actors (first_name, last_name) VALUES (?, ?)";

        try (
                Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.executeUpdate();

            System.out.println("Actor added successfully");

        } catch (SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public void listActors() {
        String sql = "SELECT * FROM actors";

        try (
                Connection conn = DriverManager.getConnection(url, user, password);
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql)
        ) {
            while (rs.next()) {
                System.out.println(
                        rs.getInt("aid") + " | " +
                                rs.getString("first_name") + " " +
                                rs.getString("last_name")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error");
        }
    }
}
