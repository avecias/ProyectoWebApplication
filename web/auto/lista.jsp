<%@page import="com.ipn.mx.modelo.pojos.orm.AutoDAOImpl"%>
<%@page import="com.ipn.mx.modelo.pojos.Auto"%>
<%@page import="com.ipn.mx.modelo.pojos.Auto"%>
<%@page import="com.ipn.mx.modelo.entidades.Usuario"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Lista de Autos</title>
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
            <h2>Tabla de Autos</h2>
            <p>Tabla ordenada por id</p>  
            <table class="table">
                <thead>
                    <tr>
                        <th>Matricula</th>
                        <th>Marca</th>
                        <th>Modelo</th>
                        <th>Anio</th>
                        <th>Precio</th>
                        <th>Color</th>
                        <th>Foto</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Auto> autos = new AutoDAOImpl().getResults(conexion.prepareStatement("select * from auto").executeQuery());
                        for (Auto auto : autos) {
                            out.print("<tr><td>" + auto.getMatricula()
                                    + "</td><td>" + auto.getMarca()
                                    + "</td><td>" + auto.getModelo()
                                    + "</td><td>" + auto.getAnio()
                                    + "</td><td>" + auto.getPrecio()
                                    + "</td><td>" + auto.getColor()
                                    + "</td><td><img src='data:image/png;base64," + auto.getImagen64() + "' alt='imagen' height='100' width='100'>"
                                    + "</td><td><a href=../borrarAuto?txtMatricula=" + auto.getMatricula() + ">Borrar</a> "
                                    + "<a href=actualizar.jsp?txtMatricula=" + auto.getMatricula()
                                    + "&txtMarca=" + auto.getMarca()
                                    + "&txtModelo=" + auto.getModelo()
                                    + "&txtAnio=" + auto.getAnio()
                                    + "&txtPrecio=" + auto.getPrecio()
                                    + "&txtColor=" + auto.getColor()
                                    + ">Actualizar</a></td></tr>");
                        }
                    %>
                </tbody>
            </table>
            <a href="../auto/crear.jsp" class="btn btn-info" role="button">Crear Nueva Auto</a>
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

