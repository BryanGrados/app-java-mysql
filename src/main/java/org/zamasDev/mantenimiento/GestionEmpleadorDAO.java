package org.zamasDev.mantenimiento;

import org.zamasDev.entity.EntityEmpleador;
import org.zamasDev.interfaces.InterfaceEmpleadorDAO;
import org.zamasDev.mysql.MySQLConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class GestionEmpleadorDAO implements InterfaceEmpleadorDAO {
    @Override
    public int insertarEmpleador(EntityEmpleador empleador) {
        int res = 0;

        Connection con = null;
        try {
            con = MySQLConnector.getConnection();
            String sql = "INSERT INTO tb_empleador (id_empleador, nombre, apellido, dni, telefono, localidad, categoria) VALUES (?,?,?,?,?,?,?)";
            java.sql.PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, empleador.getId());
            ps.setString(2, empleador.getNombre());
            ps.setString(3, empleador.getApellido());
            ps.setString(4, empleador.getDni());
            ps.setString(5, empleador.getTelefono());
            ps.setString(6, empleador.getLocalidad());
            ps.setString(7, empleador.getCategoria());

            res = ps.executeUpdate();
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return res;
    }

    @Override
    public int actualizarEmpleador(EntityEmpleador empleador) {
        int res = 0;

        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = MySQLConnector.getConnection();
            String sql = "UPDATE tb_empleador SET nombre = ?, apellido = ?, dni = ?, telefono = ?, localidad = ?, categoria = ? WHERE id_empleador = ?";
            pstm = con.prepareStatement(sql);

            pstm.setString(1, empleador.getNombre());
            pstm.setString(2, empleador.getApellido());
            pstm.setString(3, empleador.getDni());
            pstm.setString(4, empleador.getTelefono());
            pstm.setString(5, empleador.getLocalidad());
            pstm.setString(6, empleador.getCategoria());
            pstm.setInt(7, empleador.getId());

            res = pstm.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {

            try {

                if (pstm != null) {
                    pstm.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (Exception e) {
                System.out.println("Error >>> en el cierre de la conexión " + e.getMessage());
            }
        }
        return res;
    }

    @Override
    public int eliminarEmpleador(int id) {
        int res = 0;

        Connection con = null;
        try {
            con = MySQLConnector.getConnection();
            String sql = "DELETE FROM tb_empleador WHERE id_empleador = ?";
            java.sql.PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            res = ps.executeUpdate();
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return res;
    }

    @Override
    public ArrayList<EntityEmpleador> listarEmpleador() {

        ArrayList<EntityEmpleador> lista = new ArrayList<EntityEmpleador>();

        Connection con = null;
        try {
            con = MySQLConnector.getConnection();
            String sql = "SELECT * FROM tb_empleador";
            java.sql.PreparedStatement ps = con.prepareStatement(sql);

            java.sql.ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                EntityEmpleador empleador = new EntityEmpleador();
                empleador.setId(rs.getInt("id_empleador"));
                empleador.setNombre(rs.getString("nombre"));
                empleador.setApellido(rs.getString("apellido"));
                empleador.setDni(rs.getString("dni"));
                empleador.setTelefono(rs.getString("telefono"));
                empleador.setLocalidad(rs.getString("localidad"));
                empleador.setCategoria(rs.getString("categoria"));

                lista.add(empleador);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return lista;
    }
}
