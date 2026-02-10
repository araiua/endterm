import java.sql.*;

public class MovieData {

    private static final String url = "jdbc:postgresql://localhost:5432/endterm_oop";
    private static final String user = "postgres";   // твой пользователь
    private static final String password = "13062013"; // твой пароль

    public void addMovie(String title, int year) {
        String sql = "INSERT INTO movies (title, year) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, title);
            ps.setInt(2, year);
            ps.executeUpdate();

            System.out.println("Movie added: " + title + " (" + year + ")");

        } catch (SQLException e) {
            System.out.println("Error while adding movie");
            e.printStackTrace();
        }
    }

    public void listMovies() {
        String sql = "SELECT * FROM movies";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("mid") + " | " +
                                rs.getString("title") + " (" +
                                rs.getInt("year") + ")"
                );
            }

        } catch (SQLException e) {
            System.out.println("Error while listing movies");
            e.printStackTrace();
        }
    }

    public void findMovieById(int mid) {
        String sql = "SELECT * FROM movies WHERE mid = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, mid);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println(
                        rs.getInt("mid") + " | " +
                                rs.getString("title") + " (" +
                                rs.getInt("year") + ")"
                );
            } else {
                System.out.println("Movie not found with id: " + mid);
            }

        } catch (SQLException e) {
            System.out.println("Error while finding movie");
            e.printStackTrace();
        }
    }
}