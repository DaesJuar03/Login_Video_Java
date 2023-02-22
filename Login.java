package JAVA;

import java.sql.*;

public class Login {
    private final String jdbcDriver;
    private final String DB_URL;
    private final String DbUser;
    private final String DbPassword;

    public Login(String jdbcDriver, String dbUrl, String dbUser, String dbPassword) {
        this.jdbcDriver = jdbcDriver;
        this.DB_URL = dbUrl;
        this.DbUser = dbUser;
        this.DbPassword = dbPassword;
    }

public boolean validar (String username, String password){


    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try{
        Class.forName(jdbcDriver);
        

        // Abre la conexion
        conn = DriverManager.getConnection(password, username, password);

        //Ejecuta el query
        String sql = "SELECT username, password FROM db_name WHERE username = ? AND password = ?";
        stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            rs = stmt.executeQuery();

            //Valida si el usuario y contraseña son reales

            if (rs.next()){
                //Abre la conexion
                rs.close();
                stmt.close();
                conn.close();
                return true;

            }else {
                //Cierra la conexion
                rs.close();
                rs.close();
                stmt.close();
                conn.close();
                return false;
            }
    } catch (SQLException se){
        se.printStackTrace();

    } catch (Exception e){
        e.printStackTrace();
    } finally {
        // Cierra la conexion por cualquier error
        //Esto me lo saltare ya que es igual a la otra clase.
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
