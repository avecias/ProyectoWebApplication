<%@page import="com.ipn.mx.modelo.pojos.Distribuidor"%>
<%@page import="com.ipn.mx.modelo.pojos.orm.DistribuidorDAOImpl"%>
<%@page import="com.ipn.mx.modelo.entidades.Usuario"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Lista de Distribuidores</title>
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
            <h2>Tabla de Distribuidores</h2>
            <p>Tabla ordenada por id</p>  
            <table class="table">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Ciudad</th>
                        <th>Direccion</th>
                        <th>Telefono</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Distribuidor> distribuidores = new DistribuidorDAOImpl().getResults(conexion.prepareStatement("select * from distribuidor").executeQuery());
                        for (Distribuidor distribuidor : distribuidores) {
                            out.print("<tr><td>" + distribuidor.getIddistribuidor() + "</td><td>" + distribuidor.getNombredistribuidor() + "</td><td>" + distribuidor.getCuidaddistribuidor() + "</td><td>"
                                    + distribuidor.getDirecciondistribuidor() + "</td><td>" + distribuidor.getTelefonodistribuidor() + "</td><td>"
                                    + "<a href=../borrarDistribuidor?txtId=" + distribuidor.getIddistribuidor() + ">Borrar</a> "
                                    + "<a href=actualizar.jsp?txtId=" + distribuidor.getIddistribuidor()
                                    + "&txtNombre=" + distribuidor.getNombredistribuidor().replace(' ', '+')
                                    + "&txtCiudad=" + distribuidor.getCuidaddistribuidor().replace(' ', '+')
                                    + "&txtDireccion=" + distribuidor.getDirecciondistribuidor().replace(' ', '+')
                                    + "&txtTelefono=" + distribuidor.getTelefonodistribuidor().replace(' ', '+')
                                    + ">Actualizar</a></td></tr>");
                        }
                    %>
                </tbody>
            </table>
            <a href="../distribuidor/crear.jsp" class="btn btn-info" role="button">Crear Nuevo Distribuidor</a>
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

