<%@page import="com.ipn.mx.modelo.entidades.Usuario"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Crear un nuevo Auto</title>
        <link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="../css/sticky-footer.css">
        <link href="../css/signin.css" rel="stylesheet" type="text/css">
    </head>
    <%
        /*Con esta linea se verifica que el inicio de la conexion es exitosa
        y por lo tanto puede ver estas paginas*/
        Connection conexion = (Connection) session.getAttribute("conexion");
        if (conexion == null) {
            response.sendRedirect("../index.html");
            return;
        }
        Usuario usuario = (Usuario) session.getAttribute("usuario");
    %>
    <body>
        <div class="container-fluid">
            <div class="btn-group" role="group" aria-label="...">
                <a href="../index.html" class="btn btn-info" role="button">Inicio</a>
                <a href="../cliente/lista.jsp" class="btn btn-info" role="button">Cliente</a>
                <a href="../distribuidor/lista.jsp" class="btn btn-info" role="button">Distribuidora</a>
                <a href="../auto/lista.jsp" class="btn btn-info" role="button">Auto</a>
                <a href="../compra/lista.jsp" class="btn btn-info" role="button">Compra</a>
                <a href="../salir.jsp" class="btn btn-info" role="button">Salir</a>
            </div>
            <h2>Crear un nuevo Auto</h2>
            <p>Llenar todos los campos</p>  
            <fieldset>
                <form class="form-signin" action="../crearAuto" method="post" enctype="multipart/form-data">
                    <h2 class="form-signin-heading">Nuevo Auto</h2>
                    <input class="form-control" placeholder="Matricula" required="" autofocus="" type="text" title="Campo requerido" name="txtMatricula">
                    <input class="form-control" placeholder="Marca" required="" autofocus="" type="text" title="Campo requerido" name="txtMarca">
                    <input class="form-control" placeholder="Modelo" required="" autofocus="" type="text" title="Campo requerido" name="txtModelo">
                    <input class="form-control" placeholder="Anio" required="" autofocus="" type="text" title="Campo requerido" name="txtAnio">
                    <input class="form-control" placeholder="Precio" required="" autofocus="" type="text" title="Campo requerido" name="txtPrecio">
                    <input class="form-control" placeholder="Color" required="" autofocus="" type="text" title="Campo requerido" name="txtColor">
                    <input class="form-control" required="" autofocus="" type="file" title="Campo requerido" name="foto">
                    <br>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Enviar</button>
                </form>
            </fieldset>
        </div>
        <div class="container">
            <h3><%=usuario%></h3>
        </div>
        <footer class="footer">
            <div class="container">
                <p class="text-muted">Proyecto de Web Application.</p>
            </div>
        </footer>
    </body>
</html>

