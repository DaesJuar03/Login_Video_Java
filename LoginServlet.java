package JAVA;

//Agregamos estos paquetes, este error me sale ya que vscode no lo configure para esto,
//por eso es recomendado hacerlo con alguna IDE que pueda agregar esto, ejemplo: netbeans.
//Ignoraremos el error.

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet ("/LoginServlet")
public class LoginServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    private static final String JDBC_DRIVER = "com.sql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:urport/bd_name";
    private static final String DB_USER = "USER";
    private static final String DB_PASSWORD = "PASSWORD";

    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Login login = new Login(password, password, username, password);

        boolean isValid = Login.validate(username, password);

        if (isValid){
            //Se obtiene desde la db el nombre del usuario correspondiente.

            HttpSession session = request.getSession();
            response.sendRedirect("main.jsp");

        }else {
            response.sendRedirect("Login.jsp");
        }
        
    }
}
