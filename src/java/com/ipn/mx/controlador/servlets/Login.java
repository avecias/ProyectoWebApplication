package com.ipn.mx.controlador.servlets;

import com.ipn.mx.controlador.xml.ArchivoXML;
import com.ipn.mx.modelo.conexion.Conexion;
import com.ipn.mx.modelo.entidades.Usuario;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class Login extends HttpServlet {
    
    private Usuario usuarioEncontrado;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        buscar(request.getParameter("txtId"), request.getParameter("txtClave"));
        if(usuarioEncontrado != null){
            Connection conexion = new Conexion().conectar();
            System.out.println("Conexion con exito");
            HttpSession session = request.getSession();
            session.setAttribute("conexion", conexion);
            session.setAttribute("usuario", usuarioEncontrado);
            response.sendRedirect("cliente/lista.jsp");
        }
        else{
            response.sendRedirect("index.html");
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
    
    private void buscar(String id, String clave) {
        ArrayList<Usuario> usuarios = ArchivoXML.leerUsuarios();
        for (Usuario usuario : usuarios) {
            if (usuario.getClave().equals(clave) && usuario.getIdUsuario().equals(Integer.valueOf(id))) {
                usuarioEncontrado = usuario;
                break;
            }
        }
        
    }

}
