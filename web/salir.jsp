<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Fin de Sesion</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/sticky-footer.css">
        <link href="css/signin.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class="container-fluid">
            <div class="btn-group" role="group" aria-label="...">
                <a href="index.html" class="btn btn-info" role="button">Inicio</a>
                <a href="cliente/lista.jsp" class="btn btn-info" role="button">Cliente</a>
                <a href="distribuidor/lista.jsp" class="btn btn-info" role="button">Distribuidora</a>
                <a href="auto/lista.jsp" class="btn btn-info" role="button">Auto</a>
                <a href="compra/lista.jsp" class="btn btn-info" role="button">Compra</a>
                <a href="venta/lista.jsp" class="btn btn-info" role="button">Venta</a>
                <a href="salir.jsp" class="btn btn-info" role="button">Salir</a>
                <!--<button type="button" class="btn btn-default">Salir</button>-->
            </div>
            <h2>Cierre de sesion</h2>
            <p>
            <%
                try{
                    out.print(session.toString());
                    session.invalidate();
                    out.print(": Exito al cerrar la sesion");
                }catch(IllegalAccessError e){
                    out.print(": Error al cerrar la sesion");
                }
            %>
            </p>
        </div>
        <footer class="footer">
            <div class="container">
                <p class="text-muted">Proyecto de Web Application.</p>
            </div>
        </footer>
    </body>
</html>