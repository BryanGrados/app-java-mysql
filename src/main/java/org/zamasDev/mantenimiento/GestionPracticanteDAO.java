package org.zamasDev.mantenimiento;

import org.zamasDev.entity.EntityPracticante;
import org.zamasDev.interfaces.InterfacePracticanteDAO;
import org.zamasDev.mysql.MySQLConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

//tb_practicante contains the fields: id_practicante, nombre, apellido, fechaInicio, sueldo, id_postulante

public class GestionPracticanteDAO implements InterfacePracticanteDAO {
    @Override
    public int insertarPracticante(EntityPracticante practicante) {
        int res = 0;

        Connection con = null;
        PreparedStatement pstm = null;

        try {

            con = MySQLConnector.getConnection();
            String sql = "insert into tb_practicante values (?, ?, ?, ?, ?, ?)";
            pstm = con.prepareStatement(sql);

            pstm.setInt(1, practicante.getId());
            pstm.setString(2, practicante.getNombre());
            pstm.setString(3, practicante.getApellido());
            pstm.setString(4, practicante.getFechaIngreso());
            pstm.setDouble(5, practicante.getSueldo());
            pstm.setInt(6, practicante.getIdPostulante());

            res = pstm.executeUpdate();

        } catch (Exception e) {

            System.out.println("Error >>> en la instrucción SQL de registrar " + e.getMessage());

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
    public int actualizarPracticante(EntityPracticante practicante) {
        int res = 0;

        Connection con = null;
        PreparedStatement pstm = null;

        try {

            con = MySQLConnector.getConnection();
            String sql = "update tb_practicante set nombre = ?, apellido = ?, fechaInicio = ?, sueldo = ?, id_postulante = ? where id_practicante = ?";
            pstm = con.prepareStatement(sql);

            pstm.setString(1, practicante.getNombre());
            pstm.setString(2, practicante.getApellido());
            pstm.setString(3, practicante.getFechaIngreso());
            pstm.setDouble(4, practicante.getSueldo());
            pstm.setInt(5, practicante.getIdPostulante());
            pstm.setInt(6, practicante.getId());

            res = pstm.executeUpdate();

        } catch (Exception e) {

            System.out.println("Error >>> en la instrucción SQL de actualizar " + e.getMessage());

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
    public int eliminarPracticante(int id) {
        int res = 0;

        Connection con = null;
        PreparedStatement pstm = null;

        try {

            con = MySQLConnector.getConnection();
            String sql = "delete from tb_practicante where id_practicante = ?";
            pstm = con.prepareStatement(sql);

            pstm.setInt(1, id);

            res = pstm.executeUpdate();

        } catch (Exception e) {

            System.out.println("Error >>> en la instrucción SQL de eliminar " + e.getMessage());

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
    public ArrayList<EntityPracticante> listarPracticante() {

        ArrayList<EntityPracticante> lista = new ArrayList<EntityPracticante>();

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;

        try {

            con = MySQLConnector.getConnection();
            String sql = "select * from tb_practicante";
            pstm = con.prepareStatement(sql);

            res = pstm.executeQuery();

            while (res.next()) {

                EntityPracticante practicante = new EntityPracticante();

                practicante.setId(res.getInt("id_practicante"));
                practicante.setNombre(res.getString("nombre"));
                practicante.setApellido(res.getString("apellido"));
                practicante.setFechaIngreso(res.getString("fechaInicio"));
                practicante.setSueldo(res.getDouble("sueldo"));
                practicante.setIdPostulante(res.getInt("id_postulante"));

                lista.add(practicante);
            }

        } catch (Exception e) {

            System.out.println("Error >>> en la instrucción SQL de listar " + e.getMessage());

        } finally {

            try {

                if (res != null) {
                    res.close();
                }
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
        
        return lista;
    }
}
