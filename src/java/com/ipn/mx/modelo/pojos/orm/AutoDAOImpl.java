
package com.ipn.mx.modelo.pojos.orm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.ArrayList;
import com.ipn.mx.modelo.pojos.*;
import com.ipn.mx.modelo.dao.AutoDAO;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.io.InputStream;
import java.sql.Blob;


public class AutoDAOImpl implements AutoDAO {
    /* SQL to insert data */
    private static final String SQL_INSERT =
        "INSERT INTO auto ("
        + "matricula, marca, modelo, anio, precio, color, foto"
        + ") VALUES (?, ?, ?, ?, ?, ?, ?)";

    /* SQL to select data */
    private static final String SQL_SELECT =
        "SELECT "
        + "matricula, marca, modelo, anio, precio, color, foto "
        + "FROM auto WHERE "
        + "matricula = ?";

    /* SQL to update data */
    private static final String SQL_UPDATE =
        "UPDATE auto SET "
        + "marca = ?, modelo = ?, anio = ?, precio = ?, color = ?, foto = ? "
        + "WHERE "
        + "matricula = ?";

    /* SQL to delete data */
    private static final String SQL_DELETE =
        "DELETE FROM auto WHERE "
        + "matricula = ?";

    public void create(Auto bean, Connection conn, InputStream inputStream, int tama) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1, bean.getMatricula());
            ps.setString(2, bean.getMarca());
            ps.setString(3, bean.getModelo());
            ps.setInt(4, bean.getAnio());
            ps.setFloat(5, bean.getPrecio());
            ps.setString(6, bean.getColor());
            ps.setBinaryStream(7,inputStream, tama);
            ps.executeUpdate();
        }finally {
            close(ps);
        }
    }

    @Override
    public Auto load(AutoKey key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECT);
            ps.setString(1, key.getMatricula());
            rs = ps.executeQuery();
            List results = getResults(rs);
            if (results.size() > 0)
                return (Auto) results.get(0);
            else
                return null;
        }finally {
            close(rs);
            close(ps);
        }
    }

    @Override
    public void update(Auto bean, Connection conn,InputStream inputStream, int tama) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, bean.getMarca());
            ps.setString(2, bean.getModelo());
            ps.setInt(3, bean.getAnio());
            ps.setFloat(4, bean.getPrecio());
            ps.setString(5, bean.getColor());
            ps.setBinaryStream(6,inputStream, tama);
            ps.setString(7, bean.getMatricula());
            ps.executeUpdate();
        }finally {
            close(ps);
        }
    }

    @Override
    public void delete(AutoKey key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setString(1, key.getMatricula());
            ps.executeUpdate();
        }finally {
            close(ps);
        }
    }
    
    /**
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    public List<Auto> getResults(ResultSet rs) throws SQLException {
        List results = new ArrayList<>();
        while (rs.next()) {
            Auto bean = new Auto();
            bean.setMatricula(rs.getString("matricula"));
            bean.setMarca(rs.getString("marca"));
            bean.setModelo(rs.getString("modelo"));
            bean.setAnio(rs.getInt("anio"));
            bean.setPrecio(rs.getFloat("precio"));
            bean.setColor(rs.getString("color"));
            Blob blob = rs.getBlob("foto");
            byte[] data = blob.getBytes(1, (int)blob.length());
            bean.setImagen64(Base64.encode(data));
            results.add(bean);
        }
        return results;
    }

    protected void close(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            }catch(SQLException e){}
        }
    }

    /**
     * Close JDBC ResultSet.
     * @param rs  ResultSet to be closed.
     */
    protected void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            }catch(SQLException e){}
        }
    }
}