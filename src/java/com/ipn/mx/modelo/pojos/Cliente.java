
package com.ipn.mx.modelo.pojos;


public class Cliente implements java.io.Serializable, Cloneable {
    private ClienteKey _key = new ClienteKey();

    /* idCliente, PK */
    protected int idcliente;

    /* nombreCliente */
    protected String nombrecliente;

    /* apellidoCliente */
    protected String apellidocliente;

    /* usuario */
    protected String usuario;

    /* contrasena */
    protected String contrasena;

    /* Return the key object. */
    public ClienteKey getKeyObject() {
        return _key;
    }

    /* idCliente, PK */
    public int getIdcliente() {
        return idcliente;
    }

    /* idCliente, PK */
    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
        _key.setIdcliente(idcliente);
    }

    /* nombreCliente */
    public String getNombrecliente() {
        return nombrecliente;
    }

    /* nombreCliente */
    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

    /* apellidoCliente */
    public String getApellidocliente() {
        return apellidocliente;
    }

    /* apellidoCliente */
    public void setApellidocliente(String apellidocliente) {
        this.apellidocliente = apellidocliente;
    }

    /* usuario */
    public String getUsuario() {
        return usuario;
    }

    /* usuario */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /* contrasena */
    public String getContrasena() {
        return contrasena;
    }

    /* contrasena */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /* Indicates whether some other object is "equal to" this one. */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof Cliente))
            return false;

        Cliente bean = (Cliente) obj;

        if (this.idcliente != bean.idcliente)
            return false;

        if (this.nombrecliente == null) {
            if (bean.nombrecliente != null)
                return false;
        }
        else if (!this.nombrecliente.equals(bean.nombrecliente)) 
            return false;

        if (this.apellidocliente == null) {
            if (bean.apellidocliente != null)
                return false;
        }
        else if (!this.apellidocliente.equals(bean.apellidocliente)) 
            return false;

        if (this.usuario == null) {
            if (bean.usuario != null)
                return false;
        }
        else if (!this.usuario.equals(bean.usuario)) 
            return false;

        if (this.contrasena == null) {
            if (bean.contrasena != null)
                return false;
        }
        else if (!this.contrasena.equals(bean.contrasena)) 
            return false;

        return true;
    }

    /* Creates and returns a copy of this object. */
    public Object clone()
    {
        Cliente bean = new Cliente();
        bean.idcliente = this.idcliente;
        bean.nombrecliente = this.nombrecliente;
        bean.apellidocliente = this.apellidocliente;
        bean.usuario = this.usuario;
        bean.contrasena = this.contrasena;
        return bean;
    }

    /* Returns a string representation of the object. */
    public String toString() {
        String sep = "\r\n";
        StringBuffer sb = new StringBuffer();
        sb.append("[").append("idcliente").append(" = ").append(idcliente).append("]").append(sep);
        sb.append("[").append("nombrecliente").append(" = ").append(nombrecliente).append("]").append(sep);
        sb.append("[").append("apellidocliente").append(" = ").append(apellidocliente).append("]").append(sep);
        sb.append("[").append("usuario").append(" = ").append(usuario).append("]").append(sep);
        sb.append("[").append("contrasena").append(" = ").append(contrasena).append("]").append(sep);
        return sb.toString();
    }
}