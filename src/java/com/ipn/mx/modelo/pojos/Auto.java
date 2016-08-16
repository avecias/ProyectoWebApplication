package com.ipn.mx.modelo.pojos;

import java.io.InputStream;

public class Auto implements java.io.Serializable, Cloneable {
    private AutoKey _key = new AutoKey();

    /* matricula, PK */
    protected String matricula;

    /* marca */
    protected String marca;

    /* modelo */
    protected String modelo;

    /* anio */
    protected int anio;

    /* precio */
    protected float precio;

    /* color */
    protected String color;

    /* foto */
    protected java.sql.Blob foto;
    
    private String imagen64;

    /* Return the key object. */
    public AutoKey getKeyObject() {
        return _key;
    }

    /* matricula, PK */
    public String getMatricula() {
        return matricula;
    }

    /* matricula, PK */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
        _key.setMatricula(matricula);
    }

    /* marca */
    public String getMarca() {
        return marca;
    }

    /* marca */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /* modelo */
    public String getModelo() {
        return modelo;
    }

    /* modelo */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /* anio */
    public int getAnio() {
        return anio;
    }

    /* anio */
    public void setAnio(int anio) {
        this.anio = anio;
    }

    /* precio */
    public float getPrecio() {
        return precio;
    }

    /* precio */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /* color */
    public String getColor() {
        return color;
    }

    /* color */
    public void setColor(String color) {
        this.color = color;
    }

    /* foto */
    public java.sql.Blob getFoto() {
        return foto;
    }

    /* foto */
    public void setFoto(java.sql.Blob foto) {
        this.foto = foto;
    }

    public String getImagen64() {
        return imagen64;
    }

    public void setImagen64(String imagen64) {
        this.imagen64 = imagen64;
    }

    
    /* Indicates whether some other object is "equal to" this one. */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof Auto))
            return false;

        Auto bean = (Auto) obj;

        if (this.matricula == null) {
            if (bean.matricula != null)
                return false;
        }
        else if (!this.matricula.equals(bean.matricula)) 
            return false;

        if (this.marca == null) {
            if (bean.marca != null)
                return false;
        }
        else if (!this.marca.equals(bean.marca)) 
            return false;

        if (this.modelo == null) {
            if (bean.modelo != null)
                return false;
        }
        else if (!this.modelo.equals(bean.modelo)) 
            return false;

        if (this.anio != bean.anio)
            return false;

        if (this.precio != bean.precio)
            return false;

        if (this.color == null) {
            if (bean.color != null)
                return false;
        }
        else if (!this.color.equals(bean.color)) 
            return false;

        if (this.foto == null) {
            if (bean.foto != null)
                return false;
        }
        else if (!this.foto.equals(bean.foto)) 
            return false;

        return true;
    }

    /* Creates and returns a copy of this object. */
    public Object clone()
    {
        Auto bean = new Auto();
        bean.matricula = this.matricula;
        bean.marca = this.marca;
        bean.modelo = this.modelo;
        bean.anio = this.anio;
        bean.precio = this.precio;
        bean.color = this.color;
        bean.foto = this.foto;   // The field (java.sql.Blob) is not cloned actually.
        return bean;
    }

    /* Returns a string representation of the object. */
    public String toString() {
        String sep = "\r\n";
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getName()).append(sep);
        sb.append("[").append("matricula").append(" = ").append(matricula).append("]").append(sep);
        sb.append("[").append("marca").append(" = ").append(marca).append("]").append(sep);
        sb.append("[").append("modelo").append(" = ").append(modelo).append("]").append(sep);
        sb.append("[").append("anio").append(" = ").append(anio).append("]").append(sep);
        sb.append("[").append("precio").append(" = ").append(precio).append("]").append(sep);
        sb.append("[").append("color").append(" = ").append(color).append("]").append(sep);
        return sb.toString();
    }
}