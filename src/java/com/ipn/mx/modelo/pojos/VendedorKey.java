/*
 * This java source file is generated by DAO4J v1.19
 * Generated on Fri Jun 03 15:58:02 CDT 2016
 * For more information, please contact b-i-d@163.com
 * Please check http://sourceforge.net/projects/dao4j/ for the latest version.
 */

package com.ipn.mx.modelo.pojos;

public class VendedorKey implements java.io.Serializable, Cloneable {
    /* numEmpleado */
    protected int numempleado;

    /* numEmpleado */
    public int getNumempleado() {
        return numempleado;
    }

    /* numEmpleado */
    public void setNumempleado(int numempleado) {
        this.numempleado = numempleado;
    }

    /* Calculate hash code */
    public int hashCode() {
        int hashCode = 0;
        hashCode += new Integer(numempleado).hashCode();
        return hashCode;
    }
    
    /* Indicates whether some other object is "equal to" this one. */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof VendedorKey))
            return false;

        VendedorKey key = (VendedorKey) obj;

        if (this.numempleado != key.numempleado)
            return false;

        return true;
    }

    /* Creates and returns a copy of this object. */
    public Object clone()
    {
        VendedorKey key = new VendedorKey();
        key.numempleado = this.numempleado;
        return key;
    }

    /* Returns a string representation of the object. */
    public String toString() {
        String sep = "\r\n";
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getName()).append(sep);
        sb.append("[").append("numempleado").append(" = ").append(numempleado).append("]");
        return sb.toString();
    }
}