import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBlogic {




    // create

    public void addUser (String username, String password) {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";

    try (Connection conn = DatabaseConnection.getConnection();
    PreparedStatement pstmt = conn.prepareStatement(sql);
    ) {
        pstmt.setString(1, username);
        pstmt.setString(2, password);

        int rowsInserted = pstmt.executeUpdate();

        if(rowsInserted > 0) {
            System.out.println("User added successfully!");
        }
    } catch (SQLException e) {
        e.printStackTrace();
     }
    }






    // update

    public void updateUser (String password,  int id) {
        String sql = "UPDATE users set password = ? where id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, password);
            pstmt.setInt(2, id);

            int rowsInserted = pstmt.executeUpdate();

            if(rowsInserted > 0) {
                System.out.println("User updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    // delete

    public void deleteUser (int id) {
        String sql = "DELETE FROM users WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setInt(1, id);
            int rowsInserted = pstmt.executeUpdate();

            if(rowsInserted > 0) {
                System.out.println("User deleted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





    // select

    public void getUsers() {
        String sql = "SELECT * FROM users";
        try (Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery();
             ) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Username : " + rs.getString("username"));
                System.out.println("Password : " + rs.getString("password"));
                System.out.println("-------------------------");
            }

            } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
