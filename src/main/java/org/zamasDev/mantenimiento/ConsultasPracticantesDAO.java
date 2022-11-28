package org.zamasDev.mantenimiento;

import org.zamasDev.entity.EntityPostulante;
import org.zamasDev.entity.EntityPracticante;
import org.zamasDev.interfaces.InterfaceConsultarPracticantes;
import org.zamasDev.mysql.MySQLConnector;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConsultasPracticantesDAO implements InterfaceConsultarPracticantes {
    @Override
    public ArrayList<EntityPracticante> consultarPracticantePorNombre(String nombre) {
        ArrayList<EntityPracticante> lista = new ArrayList<EntityPracticante>();

        Connection con = null;
        try {
            con = MySQLConnector.getConnection();
            con.setAutoCommit(false);
            String sql = "SELECT * FROM tb_practicante WHERE nombre LIKE ?";

            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + nombre + "%");
            java.sql.ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EntityPracticante practicante = new EntityPracticante();
                practicante.setId(rs.getInt("id_practicante"));
                practicante.setNombre(rs.getString("nombre"));
                practicante.setApellido(rs.getString("apellido"));
                practicante.setFechaIngreso(rs.getString("fechaIngreso"));
                practicante.setSueldo(rs.getDouble("sueldo"));
                practicante.setDni(rs.getString("dni"));
                lista.add(practicante);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public ArrayList<EntityPracticante> consultarPracticantePorDni(String dni) {
        ArrayList<EntityPracticante> lista = new ArrayList<EntityPracticante>();

        Connection con = null;
        try {
            con = MySQLConnector.getConnection();
            con.setAutoCommit(false);
            String sql = "SELECT * FROM tb_practicante WHERE dni LIKE ?";

            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + dni + "%");
            java.sql.ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EntityPracticante practicante = new EntityPracticante();
                practicante.setId(rs.getInt("id_practicante"));
                practicante.setNombre(rs.getString("nombre"));
                practicante.setApellido(rs.getString("apellido"));
                practicante.setFechaIngreso(rs.getString("fechaIngreso"));
                practicante.setSueldo(rs.getDouble("sueldo"));
                practicante.setDni(rs.getString("dni"));
                lista.add(practicante);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public ArrayList<EntityPracticante> consultarPracticantePorFecha(String fecha) {
        ArrayList<EntityPracticante> lista = new ArrayList<EntityPracticante>();

        Connection con = null;
        try {
            con = MySQLConnector.getConnection();
            con.setAutoCommit(false);
            String sql = "SELECT * FROM tb_practicante WHERE fechaIngreso LIKE ?";

            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + fecha + "%");
            java.sql.ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EntityPracticante practicante = new EntityPracticante();
                practicante.setId(rs.getInt("id_practicante"));
                practicante.setNombre(rs.getString("nombre"));
                practicante.setApellido(rs.getString("apellido"));
                practicante.setFechaIngreso(rs.getString("fechaIngreso"));
                practicante.setSueldo(rs.getDouble("sueldo"));
                practicante.setDni(rs.getString("dni"));
                lista.add(practicante);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public ArrayList<EntityPracticante> consultarPracticantePorSueldo(String sueldo, String sueldo2) {
        ArrayList<EntityPracticante> lista = new ArrayList<EntityPracticante>();

        Connection con = null;
        try {
            con = MySQLConnector.getConnection();
            con.setAutoCommit(false);
            String sql = "SELECT * FROM tb_practicante WHERE sueldo BETWEEN ? AND ?";

            java.sql.PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sueldo);
            ps.setString(2, sueldo2);
            java.sql.ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EntityPracticante practicante = new EntityPracticante();
                practicante.setId(rs.getInt("id_practicante"));
                practicante.setNombre(rs.getString("nombre"));
                practicante.setApellido(rs.getString("apellido"));
                practicante.setFechaIngreso(rs.getString("fechaIngreso"));
                practicante.setSueldo(rs.getDouble("sueldo"));
                practicante.setDni(rs.getString("dni"));
                lista.add(practicante);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public String totalPracticantesEnMySQL() {
        String total = "";
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            con = MySQLConnector.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("SELECT COUNT(*) FROM tb_practicante");
            while (rs.next()) {
                total = rs.getString(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener el total de postulantes");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
            }
        }
        return total;
    }
}
