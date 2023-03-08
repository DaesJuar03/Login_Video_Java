

<%@page import="Login.Login"%>

        <%@ page import="java.sql.*" %>
        <%
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if (username != null && password != null) {
                String jdbcDriver = "com.mysql.jdbc.Driver";
                String dbUrl = "jdbc:mysql://localhost:UR_PORT/DB_NAME";
                String dbUser = "user";
                String dbPassword = "password";

                Login login = new Login(jdbcDriver, dbUrl, dbUser, dbPassword);
                boolean valid = login.validate(username, password);

                if (valid) {
                    // Usuario y contraseña válidos
                    HttpSession sesion = request.getSession();
                    sesion.setAttribute("username", username);
                    response.sendRedirect("home.jsp");
                    return;
                } else {
                    // Usuario y contraseña inválidos
                    response.sendRedirect("Index.jsp");
                }
            }

        %>

     

