package com.ipn.mx.controlador.servlets.compra;

import com.ipn.mx.modelo.pojos.Compra;
import com.ipn.mx.modelo.pojos.orm.CompraDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "actualizarCompra", urlPatterns = {"/actualizarCompra"})
public class actualizarCompra extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String estado = "Error al actualizar la compra";
        int id = Integer.valueOf(request.getParameter("txtId"));
        Date fecha = Date.valueOf(request.getParameter("txtFecha"));
        float precio = Float.valueOf(request.getParameter("txtPrecio"));
        int idDistribuidor = Integer.valueOf(request.getParameter("txtIdDistribuidor"));
        String matricula = request.getParameter("txtMatricula");
        try {
            HttpSession session = request.getSession();
            Connection conexion = (Connection) session.getAttribute("conexion");
            Compra compra = new Compra();
            compra.setIdcompra(id);
            compra.setFechacompra(fecha);
            compra.setPreciocompra(precio);
            compra.setIddistribuidor(idDistribuidor);
            compra.setMatricula(matricula);
            new CompraDAOImpl().update(compra, conexion);
            estado = "Compra actualizada con exito";
        } catch (SQLException e) {
            System.err.println("Algo salio mal al actualizar la compra " + e);
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
            out.println("Datos de la  compra actualizada, Id= " + id + ", Fecha= " + fecha + ", Precio= " + precio + ", idDistribuidor= " + idDistribuidor + ", matricula= " + matricula);
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
