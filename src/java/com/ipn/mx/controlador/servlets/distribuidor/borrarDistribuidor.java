
package com.ipn.mx.controlador.servlets.distribuidor;

import com.ipn.mx.modelo.pojos.DistribuidorKey;
import com.ipn.mx.modelo.pojos.orm.DistribuidorDAOImpl;
import com.sun.xml.internal.ws.client.dispatch.DispatchImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "borrarDistribuidor", urlPatterns = {"/borrarDistribuidor"})
public class borrarDistribuidor extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String estado = "Error al borrar el Distribuidor";
        int id = Integer.valueOf(request.getParameter("txtId"));
        try {
            HttpSession session = request.getSession();
            Connection conexion = (Connection) session.getAttribute("conexion");
            DistribuidorKey dk = new DistribuidorKey();
            dk.setIddistribuidor(id);
            new DistribuidorDAOImpl().delete(dk, conexion);
            estado = "Distribuidor borrado con exito";
        } catch (SQLException e) {
            System.err.println("Algo salio mal al borrar el Distribuidor " + e);
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>\n"
                    + "<html lang=\"en\">\n"
                    + "    <head>\n"
                    + "        <title>Operacion</title>\n"
                    + "        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.css\">\n"
                    + "        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.min.css\">\n"
                    + "        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/sticky-footer.css\">\n"
                    + "        <link href=\"css/signin.css\" rel=\"stylesheet\" type=\"text/css\">\n"
                    + "    </head>\n"
                    + "    <body>\n"
                    + "        <div class=\"container-fluid\">\n"
                    + "            <div class=\"btn-group\" role=\"group\" aria-label=\"...\">\n"
                    + "                <a href=\"index.html\" class=\"btn btn-info\" role=\"button\">Inicio</a>\n"
                    + "                <a href=\"cliente/lista.jsp\" class=\"btn btn-info\" role=\"button\">Cliente</a>\n"
                    + "                <a href=\"distribuidora/lista.jsp\" class=\"btn btn-info\" role=\"button\">Distribuidora</a>\n"
                    + "                <a href=\"auto/lista.jsp\" class=\"btn btn-info\" role=\"button\">Auto</a>\n"
                    + "                <a href=\"compra/lista.jsp\" class=\"btn btn-info\" role=\"button\">Compra</a>\n"
                    + "                <a href=\"salir.jsp\" class=\"btn btn-info\" role=\"button\">Salir</a>\n"
                    + "                <!--<button type=\"button\" class=\"btn btn-default\">Salir</button>-->\n"
                    + "            </div>");
            out.println("<h2>Resultado</h2><p>");
            out.println("Distribuidor con id= " + id);
            out.println("<p>" + estado);
            out.println("</div>\n"
                    + "        <footer class=\"footer\">\n"
                    + "            <div class=\"container\">\n"
                    + "                <p class=\"text-muted\">Proyecto de Web Application.</p>\n"
                    + "            </div>\n"
                    + "        </footer>\n"
                    + "    </body>\n"
                    + "</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
