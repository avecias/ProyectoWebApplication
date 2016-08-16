/*
 * This java source file is generated by DAO4J v1.19
 * Generated on Fri Jun 03 15:58:02 CDT 2016
 * For more information, please contact b-i-d@163.com
 * Please check http://sourceforge.net/projects/dao4j/ for the latest version.
 */

package com.ipn.mx.modelo.pojos;

/*
 * For Table vendedor
 */
public class Vendedor implements java.io.Serializable, Cloneable {
    private VendedorKey _key = new VendedorKey();

    /* numEmpleado, PK */
    protected int numempleado;

    /* nombreEmpleado */
    protected String nombreempleado;

    /* apellidoEmpleado */
    protected String apellidoempleado;

    /* usuario */
    protected String usuario;

    /* contrasena */
    protected String contrasena;

    /* idDistribuidor */
    protected int iddistribuidor;

    /* Return the key object. */
    public VendedorKey getKeyObject() {
        return _key;
    }

    /* numEmpleado, PK */
    public int getNumempleado() {
        return numempleado;
    }

    /* numEmpleado, PK */
    public void setNumempleado(int numempleado) {
        this.numempleado = numempleado;
        _key.setNumempleado(numempleado);
    }

    /* nombreEmpleado */
    public String getNombreempleado() {
        return nombreempleado;
    }

    /* nombreEmpleado */
    public void setNombreempleado(String nombreempleado) {
        this.nombreempleado = nombreempleado;
    }

    /* apellidoEmpleado */
    public String getApellidoempleado() {
        return apellidoempleado;
    }

    /* apellidoEmpleado */
    public void setApellidoempleado(String apellidoempleado) {
        this.apellidoempleado = apellidoempleado;
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

    /* idDistribuidor */
    public int getIddistribuidor() {
        return iddistribuidor;
    }

    /* idDistribuidor */
    public void setIddistribuidor(int iddistribuidor) {
        this.iddistribuidor = iddistribuidor;
    }

    /* Indicates whether some other object is "equal to" this one. */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof Vendedor))
            return false;

        Vendedor bean = (Vendedor) obj;

        if (this.numempleado != bean.numempleado)
            return false;

        if (this.nombreempleado == null) {
            if (bean.nombreempleado != null)
                return false;
        }
        else if (!this.nombreempleado.equals(bean.nombreempleado)) 
            return false;

        if (this.apellidoempleado == null) {
            if (bean.apellidoempleado != null)
                return false;
        }
        else if (!this.apellidoempleado.equals(bean.apellidoempleado)) 
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

        if (this.iddistribuidor != bean.iddistribuidor)
            return false;

        return true;
    }

    /* Creates and returns a copy of this object. */
    public Object clone()
    {
        Vendedor bean = new Vendedor();
        bean.numempleado = this.numempleado;
        bean.nombreempleado = this.nombreempleado;
        bean.apellidoempleado = this.apellidoempleado;
        bean.usuario = this.usuario;
        bean.contrasena = this.contrasena;
        bean.iddistribuidor = this.iddistribuidor;
        return bean;
    }

    /* Returns a string representation of the object. */
    public String toString() {
        String sep = "\r\n";
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getName()).append(sep);
        sb.append("[").append("numempleado").append(" = ").append(numempleado).append("]").append(sep);
        sb.append("[").append("nombreempleado").append(" = ").append(nombreempleado).append("]").append(sep);
        sb.append("[").append("apellidoempleado").append(" = ").append(apellidoempleado).append("]").append(sep);
        sb.append("[").append("usuario").append(" = ").append(usuario).append("]").append(sep);
        sb.append("[").append("contrasena").append(" = ").append(contrasena).append("]").append(sep);
        sb.append("[").append("iddistribuidor").append(" = ").append(iddistribuidor).append("]").append(sep);
        return sb.toString();
    }
}