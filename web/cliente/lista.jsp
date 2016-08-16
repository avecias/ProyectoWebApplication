<%@page import="com.ipn.mx.modelo.entidades.Usuario"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@page import="com.ipn.mx.modelo.pojos.Cliente"%>
<%@page import="com.ipn.mx.modelo.pojos.orm.ClienteDAOImpl"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Lista de Clientes</title>
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
            <h2>Tabla de Clientes</h2>
            <p>Tabla ordenada por id</p>  
            <table class="table">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Usuario</th>
                        <th>Clave</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Cliente> clientes = new ClienteDAOImpl().getResults(conexion.prepareStatement("select * from cliente").executeQuery());
                        for (Cliente cliente : clientes) {
                            out.print("<tr><td>" + cliente.getIdcliente() + "</td><td>" + cliente.getNombrecliente() + "</td><td>" + cliente.getApellidocliente() + "</td><td>"
                                    + cliente.getUsuario() + "</td><td>" + cliente.getContrasena() + "</td><td>"
                                    + "<a href=../borrarCliente?txtId=" + cliente.getIdcliente() + ">Borrar</a> "
                                    + "<a href=actualizar.jsp?txtId=" + cliente.getIdcliente()
                                    + "&txtNombre=" + cliente.getNombrecliente().replace(' ', '+')
                                    + "&txtApellido=" + cliente.getApellidocliente().replace(' ', '+')
                                    + "&txtUsuario=" + cliente.getUsuario().replace(' ', '+')
                                    + "&txtClave=" + cliente.getContrasena().replace(' ', '+')
                                    + ">Actualizar</a></td></tr>");
                        }
                    %>
                </tbody>
            </table>
            <a href="../cliente/crear.jsp" class="btn btn-info" role="button">Crear Nuevo Cliente</a>
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
