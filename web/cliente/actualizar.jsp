<%@page import="com.ipn.mx.modelo.entidades.Usuario"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Actualizar un nuevo Cliente</title>
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
        int id = Integer.valueOf(request.getParameter("txtId"));
        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        String usua = request.getParameter("txtUsuario");
        String clave = request.getParameter("txtClave");
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
            <h2>Actualizar Cliente</h2>
            <p>Llenar todos los campos</p>  
            <fieldset>
                <form class="form-signin" action="../actualizarCliente" method="post">
                    <h2 class="form-signin-heading">Actualizar Cliente</h2>
                    <input class="form-control" placeholder="Nombre" required="" autofocus="" type="text" title="Campo requerido" name="txtId" value="<%=id%>" readonly="">
                    <input class="form-control" placeholder="Nombre" required="" autofocus="" type="text" title="Campo requerido" name="txtNombre" value="<%=nombre%>">
                    <input class="form-control" placeholder="Apellido" required="" autofocus="" type="text" title="Campo requerido" name="txtApellido" value="<%=apellido%>">
                    <input class="form-control" placeholder="Usuario" required="" autofocus="" type="text" title="Campo requerido" name="txtUsuario" value="<%=usua%>">
                    <input class="form-control" placeholder="clave" required="" autofocus="" type="password" title="Campo requerido" name="txtClave" value="<%=clave%>">
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


