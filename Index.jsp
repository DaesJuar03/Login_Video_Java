

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Kanit:ital@1&family=Open+Sans:wght@400;600&family=Roboto:wght@700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="SRC/css/Style.css">
    <body>
        <div class="login">
            <div class="TextBoxArea">
                <img src="SRC/IMG/zarla-escpate-1x1-2400x2400-20210603-pdgb4mmp4ghqyfwxm437.png" alt="" class="logo">
                <form action="Login.jsp" class="formulario__login" method="post">
                    <input type="text" placeholder="Usuario" name="username">
                    <input type="password" placeholder="Contraseña" name="password">
                    <button type="submit" value="Iniciar sesión">Entrar</button>
                </form>
                <div class="forgotenPassword">
                    <p><a href="">Recuperar mi cuenta</a></p>
                </div>
                <div class="CreateAccont">
                    <p>¿Eres nuevo?</p> <a href="Register.jsp">Registrate</a>
                </div>
            </div>
            <div class="img">
                <img src="SRC/IMG/20945114.jpg" alt="" height="720px" style="margin-right: 0.5cm;">
            </div>
        </div>

    </body>

</html>