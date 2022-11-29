package org.zamasDev.mantenimiento;

import org.zamasDev.interfaces.InterfaceTransaccionDAO;
import org.zamasDev.mysql.MySQLConnector;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TransaccionDAO implements InterfaceTransaccionDAO {


    @Override
    public String idTransaccion(String code) {
        String id = "";

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            con = MySQLConnector.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("SELECT COUNT(*) FROM tb_transacciones");

            while (rs.next()) {
                id = rs.getString(1);
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
                JOptionPane.showMessageDialog(null, "Error al obtener el total de postulantes");
            }
        }
        return id;
    }
}
