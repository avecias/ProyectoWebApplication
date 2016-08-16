package com.ipn.mx.controlador.xml;

import com.ipn.mx.modelo.entidades.Usuario;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class ArchivoXML {

    public static void guardarUsuarios(ArrayList<Usuario> usuarios) {
        try {
            //Leer todos los usuarios
            Document documento = new Document();
            Element us = new Element("usuarios");
            for (Usuario usuario : usuarios) {
                Element u = new Element("usuario");
                u.setAttribute(new Attribute("idUsuario", String.valueOf(usuario.getIdUsuario())));
                u.addContent(new Element("nombre").setText(usuario.getNombre()));
                u.addContent(new Element("clave").setText(usuario.getClave()));
                us.addContent(u);
            }
            documento.setRootElement(us);
            // crear objeto XMLOutput
            XMLOutputter xmlOutput = new XMLOutputter();
            // Fijar formato
            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(documento, new FileWriter("XMLs/Usuarios.xml"));
            System.out.println("Archivo guardado con exito!");
            JOptionPane.showMessageDialog(null, "Exito al guardar");
        } catch (IOException ex) {
            System.err.println("Error al guardar el archivo " + ex);
            JOptionPane.showMessageDialog(null, "Error al guardar el archivo " + ex, "Error al escribir", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static ArrayList<Usuario> leerUsuarios(){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {
            SAXBuilder saxBuilder = new SAXBuilder();
            //Document documento = saxBuilder.build("../../../../../XMLs/Usuarios.xml");
            Document documento = saxBuilder.build("/home/hyper/NetBeansProjects/WAD/XMLs/Usuarios.xml");
            List<Element> us = documento.getRootElement().getChildren();
            for (Element u : us) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(Integer.valueOf(u.getAttributeValue("idUsuario")));
                usuario.setNombre(u.getChildText("nombre"));
                usuario.setClave(u.getChildText("clave"));
                usuarios.add(usuario);
            }
            return usuarios;
        } catch (JDOMException ex) {
            System.err.println("Error en jdom " + ex);
            return usuarios;
        } catch (IOException ex) {
            System.err.println("Error al leer el archivo " + ex);
            return usuarios;
        }
    }

//    public static void main(String[] args) {
//        ArrayList<Usuario> usuarios = new ArrayList<>();
//        Usuario u1 = new Usuario(1, "Nash", "avecias");
//        Usuario u2 = new Usuario(2, "Pedro", "picapiedra");
//        usuarios.add(u1);
//        usuarios.add(u2);
//        ArchivoXML.guardarUsuarios(usuarios);
//        List<Usuario> usuarios = ArchivoXML.leerUsuarios();
//        for (Usuario usuario : usuarios) {
//            System.out.println(usuario.toString());
//        }
//    }
}
