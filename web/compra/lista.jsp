<%@page import="com.ipn.mx.modelo.pojos.orm.CompraDAOImpl"%>
<%@page import="com.ipn.mx.modelo.pojos.Compra"%>
<%@page import="com.ipn.mx.modelo.entidades.Usuario"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Lista de Compras</title>
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
            <h2>Tabla de Compras</h2>
            <p>Tabla ordenada por id</p>  
            <table class="table">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Fecha</th>
                        <th>Precio</th>
                        <th>IdDistribuidora</th>
                        <th>Matricula</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Compra> compras = new CompraDAOImpl().getResults(conexion.prepareStatement("select * from compra").executeQuery());
                        for (Compra compra : compras) {
                            out.print("<tr><td>" + compra.getIdcompra() + "</td><td>" + compra.getFechacompra() + "</td><td>" + compra.getPreciocompra() + "</td><td>"
                                    + compra.getIddistribuidor() + "</td><td>" + compra.getMatricula() + "</td><td>"
                                    + "<a href=../borrarCompra?txtId=" + compra.getIdcompra() + ">Borrar</a> "
                                    + "<a href=actualizar.jsp?txtId=" + compra.getIdcompra()
                                    + "&txtFecha=" + compra.getFechacompra()
                                    + "&txtPrecio=" + compra.getPreciocompra()
                                    + "&txtIdDistribuidor=" + compra.getIddistribuidor()
                                    + "&txtMatricula=" + compra.getMatricula()
                                    + ">Actualizar</a></td></tr>");
                        }
                    %>
                </tbody>
            </table>
            <a href="../compra/crear.jsp" class="btn btn-info" role="button">Crear Nueva Compra</a>
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
