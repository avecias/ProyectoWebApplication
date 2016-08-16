<%@page import="com.ipn.mx.modelo.entidades.Usuario"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Crear un nuevo Distribuidor</title>
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
        String ciudad = request.getParameter("txtCiudad");
        String direccion = request.getParameter("txtDireccion");
        String telefono = request.getParameter("txtTelefono");
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
            <h2>Actualizar Distribuidor</h2>
            <p>Llenar todos los campos</p>  
            <fieldset>
                <form class="form-signin" action="../actualizarDistribuidor" method="post">
                    <h2 class="form-signin-heading">Actualizar Distribuidor</h2>
                    <input class="form-control" placeholder="Id" required="" autofocus="" type="text" title="Campo requerido" name="txtId" value="<%=id%>" readonly="">
                    <input class="form-control" placeholder="Nombre" required="" autofocus="" type="text" title="Campo requerido" name="txtNombre" value="<%=nombre%>">
                    <input class="form-control" placeholder="Ciudad" required="" autofocus="" type="text" title="Campo requerido" name="txtCiudad" value="<%=ciudad%>">
                    <input class="form-control" placeholder="Direccion" required="" autofocus="" type="text" title="Campo requerido" name="txtDireccion" value="<%=direccion%>">
                    <input class="form-control" placeholder="Telefono" required="" autofocus="" type="text" title="Campo requerido" name="txtTelefono" value="<%=telefono%>">
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


