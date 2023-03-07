
package Login_Register;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/agencia_vuelo";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1213";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Login login = new Login(JDBC_DRIVER, DB_URL, DB_USER, DB_PASSWORD);

        boolean isValid = login.validate(username, password);
        if (isValid) {
            // Obtener el nombre de usuario correspondiente al correo electrónico
          
            HttpSession session = request.getSession();
            response.sendRedirect("home.jsp");
        } else {
            response.sendRedirect("Index.jsp");
        }

    }

}