package JAVA;

//Importamos las dependencias SQL
import java.sql.*;

//Esta clase engloba a todo al package que manejes, manejara a las clases
// Login,Login Servlet y register.

public class Db_Connect{

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:porthere/tudb";
    private static final String USER = "User_DB";
    private static final String PASS = "Password";

    public static boolean validar (String username, String password){
        
        boolean status = false;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try{

            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(password, username, password);
            String sql = "SELECT * FROM name_table WHERE name_row=? AND name_row=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            status = rs.next();

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if (rs != null){
                    rs.close();
                }
                if (stmt != null){
                    stmt.close();
                }
                if (conn != null){
                    conn.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }

        return status;
        


    }
}