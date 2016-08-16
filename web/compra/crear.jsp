<%@page import="java.sql.SQLException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.ipn.mx.modelo.entidades.Usuario"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Crear un nueva Compra</title>
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
        List<String> matriculas = new ArrayList();
        List<String> idDis = new ArrayList();
        List<String> nomDis = new ArrayList();
        try {
            ResultSet rs1 = conexion.createStatement().executeQuery("select matricula from auto");
            ResultSet rs2 = conexion.createStatement().executeQuery("select idDistribuidor,nombreDistribuidor from distribuidor");
            while (rs1.next()) {
                matriculas.add(rs1.getString("matricula"));
            }
            while (rs2.next()) {
                idDis.add(String.valueOf(rs2.getInt("idDistribuidor")));
                nomDis.add(rs2.getString("nombreDistribuidor"));
            }
        } catch (SQLException e) {
            out.print("Algo salio muy mal " + e);
        }
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
            <h2>Crear un nuevo Compra</h2>
            <p>Llenar todos los campos</p>  
            <fieldset>
                <form class="form-signin" action="../crearCompra" method="post">
                    <h2 class="form-signin-heading">Nueva Compra</h2>
                    <input class="form-control" required="" autofocus="" type="date" title="Campo requerido" name="txtFecha">
                    <input class="form-control" placeholder="Precio" required="" autofocus="" type="number" title="Campo requerido" name="txtPrecio" min="0" max="99999999">
                    <select class="form-control" name="txtIdDistribuidor" required="" autofocus="" title="Campo requerido">
                        <%                        
                            for (int i = 0; i < idDis.size(); i++) {
                                out.print("<option value='" + idDis.get(i) + "'>" + nomDis.get(i) + "</option>");
                            }
                        %>
                    </select>
                    <select class="form-control" name="txtMatricula" required="" autofocus="" title="Campo requerido">
                        <%                        
                            for (int i = 0; i < matriculas.size(); i++) {
                                out.print("<option value='" + matriculas.get(i) + "'>" + matriculas.get(i) + "</option>");
                            }
                        %>
                    </select>
                    <!--<input class="form-control" placeholder="Id Distribuidor" required="" autofocus="" type="text" title="Campo requerido" name="txtIdDistribuidor">-->
                    <!--<input class="form-control" placeholder="Matricula" required="" autofocus="" type="text" title="Campo requerido" name="txtMatricula">-->
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

