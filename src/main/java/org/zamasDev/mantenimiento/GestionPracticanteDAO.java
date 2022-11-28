package org.zamasDev.mantenimiento;

import org.zamasDev.entity.EntityPracticante;
import org.zamasDev.interfaces.InterfacePracticanteDAO;
import org.zamasDev.mysql.MySQLConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GestionPracticanteDAO implements InterfacePracticanteDAO {
    @Override
    public int insertarPracticante(EntityPracticante practicante) {
        int res = 0;

        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = MySQLConnector.getConnection();
            String sql = "insert into tb_practicante values (?, ? , ? , ? , ?, ?)";
            pstm = con.prepareStatement(sql);

            pstm.setInt(1, practicante.getId());
            pstm.setString(2, practicante.getNombre());
            pstm.setString(3, practicante.getApellido());
            pstm.setString(4, practicante.getFechaIngreso());
            pstm.setDouble(5, practicante.getSueldo());
            pstm.setString(6, practicante.getDni());

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
            String sql = "update tb_practicante set fechaIngreso = ?, sueldo = ? where id_practicante = ?";
            pstm = con.prepareStatement(sql);

            pstm.setString(1, practicante.getFechaIngreso());
            pstm.setDouble(2, practicante.getSueldo());
            pstm.setInt(3, practicante.getId());

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
                practicante.setFechaIngreso(res.getString("fechaIngreso"));
                practicante.setSueldo(res.getDouble("sueldo"));
                practicante.setDni(res.getString("dni"));

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

    @Override
    public EntityPracticante buscarPracticante(String dni) {
        EntityPracticante practicante = new EntityPracticante();

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;

        try {

            con = MySQLConnector.getConnection();
            String sql = "select * from tb_postulante where dni = ?";
            pstm = con.prepareStatement(sql);

            pstm.setString(1, dni);

            res = pstm.executeQuery();

            while (res.next()) {

                practicante.setId(res.getInt("id_postulante"));
                practicante.setNombre(res.getString("nombre"));
                practicante.setApellido(res.getString("apellido"));
                practicante.setDni(res.getString("dni"));
            }

        } catch (Exception e) {

            System.out.println("Error >>> en la instrucción SQL de buscar " + e.getMessage());

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
        return practicante;
    }

    @Override
    public int actualizarEstadoPostulante(String dni) {
        int res = 0;

        Connection con = null;
        PreparedStatement pstm = null;

        try {

            con = MySQLConnector.getConnection();
            String sql = "update tb_postulante set estado = ? where dni = ?";
            pstm = con.prepareStatement(sql);

            pstm.setString(1, "P");
            pstm.setString(2, dni);

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
}
