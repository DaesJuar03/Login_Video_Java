

<%@page import="Login.Login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    </head>
    <body>
        <%@ page import="java.sql.*" %>
        <%
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if (username != null && password != null) {
                String jdbcDriver = "com.mysql.jdbc.Driver";
                String dbUrl = "jdbc:mysql://localhost:3306/agencia_vuelo";
                String dbUser = "root";
                String dbPassword = "1213";

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

        <script>

            Swal.fire({
                title: 'Error!',
                text: 'Do you want to continue',
                icon: 'error',
                confirmButtonText: 'Cool'
            })
        </script>

    </body>
</html>