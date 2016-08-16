/*
 * This java source file is generated by DAO4J v1.19
 * Generated on Fri Jun 03 15:58:02 CDT 2016
 * For more information, please contact b-i-d@163.com
 * Please check http://sourceforge.net/projects/dao4j/ for the latest version.
 */

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
import com.ipn.mx.modelo.dao.DistribuidorDAO;

/**
 * This class provides methods to populate DB Table of distribuidor
 */
public class DistribuidorDAOImpl implements DistribuidorDAO {
    /* SQL to insert data */
    private static final String SQL_INSERT =
        "INSERT INTO distribuidor ("
        + "idDistribuidor, nombreDistribuidor, cuidadDistribuidor, direccionDistribuidor, telefonoDistribuidor"
        + ") VALUES (?, ?, ?, ?, ?)";

    /* SQL to select data */
    private static final String SQL_SELECT =
        "SELECT "
        + "idDistribuidor, nombreDistribuidor, cuidadDistribuidor, direccionDistribuidor, telefonoDistribuidor "
        + "FROM distribuidor WHERE "
        + "idDistribuidor = ?";

    /* SQL to update data */
    private static final String SQL_UPDATE =
        "UPDATE distribuidor SET "
        + "nombreDistribuidor = ?, cuidadDistribuidor = ?, direccionDistribuidor = ?, telefonoDistribuidor = ? "
        + "WHERE "
        + "idDistribuidor = ?";

    /* SQL to delete data */
    private static final String SQL_DELETE =
        "DELETE FROM distribuidor WHERE "
        + "idDistribuidor = ?";

    /**
     * Create a new record in Database.
     * @param bean   The Object to be inserted.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void create(Distribuidor bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setInt(1, bean.getIddistribuidor());
            ps.setString(2, bean.getNombredistribuidor());
            ps.setString(3, bean.getCuidaddistribuidor());
            ps.setString(4, bean.getDirecciondistribuidor());
            ps.setString(5, bean.getTelefonodistribuidor());
            ps.executeUpdate();
        }finally {
            close(ps);
        }
    }

    /**
     * Retrive a record from Database.
     * @param beanKey   The PK Object to be retrived.
     * @param conn      JDBC Connection.
     * @exception       SQLException if something is wrong.
     */
    public Distribuidor load(DistribuidorKey key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(SQL_SELECT);
            ps.setInt(1, key.getIddistribuidor());
            rs = ps.executeQuery();
            List results = getResults(rs);
            if (results.size() > 0)
                return (Distribuidor) results.get(0);
            else
                return null;
        }finally {
            close(rs);
            close(ps);
        }
    }

    /**
     * Update a record in Database.
     * @param bean   The Object to be saved.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void update(Distribuidor bean, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, bean.getNombredistribuidor());
            ps.setString(2, bean.getCuidaddistribuidor());
            ps.setString(3, bean.getDirecciondistribuidor());
            ps.setString(4, bean.getTelefonodistribuidor());
            ps.setInt(5, bean.getIddistribuidor());
            ps.executeUpdate();
        }finally {
            close(ps);
        }
    }

    /**
     * Create a new record in Database.
     * @param bean   The PK Object to be deleted.
     * @param conn   JDBC Connection.
     * @exception    SQLException if something is wrong.
     */
    public void delete(DistribuidorKey key, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, key.getIddistribuidor());
            ps.executeUpdate();
        }finally {
            close(ps);
        }
    }
    
    /**
     * Populate the ResultSet.
     * @param rs     The ResultSet.
     * @return       The Object to retrieve from DB.
     * @exception    SQLException if something is wrong.
     */
    public List<Distribuidor> getResults(ResultSet rs) throws SQLException {
        List results = new ArrayList<>();
        while (rs.next()) {
            Distribuidor bean = new Distribuidor();
            bean.setIddistribuidor(rs.getInt("idDistribuidor"));
            bean.setNombredistribuidor(rs.getString("nombreDistribuidor"));
            bean.setCuidaddistribuidor(rs.getString("cuidadDistribuidor"));
            bean.setDirecciondistribuidor(rs.getString("direccionDistribuidor"));
            bean.setTelefonodistribuidor(rs.getString("telefonoDistribuidor"));
            results.add(bean);
        }
        return results;
    }

    /**
     * Close JDBC Statement.
     * @param stmt  Statement to be closed.
     */
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