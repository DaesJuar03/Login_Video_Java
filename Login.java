package Login_Register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

    private final String jdbcDriver;
    private final String dbUrl;
    private final String dbUser;
    private final String dbPassword;

    public Login(String jdbcDriver, String dbUrl, String dbUser, String dbPassword) {
        this.jdbcDriver = jdbcDriver;
        this.dbUrl = dbUrl;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
    }

    public boolean validate(String username, String password) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Registra el JDBC driver
            Class.forName(jdbcDriver);

            // Abre la conexion
            System.out.println("Connecting to the database...");
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

            // Ejecuta el query
            String sql = "SELECT username, password FROM user WHERE username = ? AND password = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            rs = stmt.executeQuery();

            // Valida si el usuario y contraseña es verdadero
            if (rs.next()) {
                // Cierra la conexion
                rs.close();
                stmt.close();
                conn.close();
                return true;
            } else {
                // Cierra la conexion
                rs.close();
                stmt.close();
                conn.close();
                return false;
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cierra la conexion por cualquier error
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return false;
    }
}
