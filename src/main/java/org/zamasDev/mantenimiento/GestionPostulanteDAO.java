package org.zamasDev.mantenimiento;


import org.zamasDev.entity.EntityPostulante;
import org.zamasDev.interfaces.InterfacePostulanteDAO;
import org.zamasDev.mysql.MySQLConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GestionPostulanteDAO implements InterfacePostulanteDAO {

    @Override
    public int insertarPostulante(EntityPostulante postulante) {

        int res = 0;

        Connection con = null;
        PreparedStatement pstm = null;

        try {

            con = MySQLConnector.getConnection();
            String sql = "insert into tb_postulante values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pstm = con.prepareStatement(sql);

            pstm.setInt(1, postulante.getId());
            pstm.setString(2, postulante.getNombre());
            pstm.setString(3, postulante.getApellido());
            pstm.setString(4, postulante.getDni());
            pstm.setString(5, postulante.getTelefono());
            pstm.setString(6, postulante.getEmail());
            pstm.setString(7, postulante.getCiudad());
            pstm.setString(8, postulante.getEstado());
            pstm.setString(9, postulante.getGenero());

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
    public int actualizarPostulante(EntityPostulante postulante) {

        int res = 0;

        Connection con = null;
        PreparedStatement pstm = null;

        try {

            con = MySQLConnector.getConnection();
            String sql = "update tb_postulante set nombre = ?, apellido = ?, dni = ?, telefono = ?, email = ?, estado = ?, ciudad = ?, genero = ? where id_postulante = ?";
            pstm = con.prepareStatement(sql);

            pstm.setString(1, postulante.getNombre());
            pstm.setString(2, postulante.getApellido());
            pstm.setString(3, postulante.getDni());
            pstm.setString(4, postulante.getTelefono());
            pstm.setString(5, postulante.getEmail());
            pstm.setString(6, postulante.getEstado());
            pstm.setString(7, postulante.getCiudad());
            pstm.setString(8, postulante.getGenero());
            pstm.setInt(9, postulante.getId());

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
    public int eliminarPostulante(int id) {

        int res = 0;

        Connection con = null;
        PreparedStatement pstm = null;

        try {

            con = MySQLConnector.getConnection();
            String sql = "delete from tb_postulante where id_postulante = ?";
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
    public ArrayList<EntityPostulante> listarPostulante() {
        ArrayList<EntityPostulante> lista = new ArrayList<EntityPostulante>();

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;

        try {

            con = MySQLConnector.getConnection();
            String sql = "select * from tb_postulante";
            pstm = con.prepareStatement(sql);
            res = pstm.executeQuery();

            while (res.next()) {
                EntityPostulante postulante = new EntityPostulante();
                postulante.setId(res.getInt("id_postulante"));
                postulante.setNombre(res.getString("nombre"));
                postulante.setApellido(res.getString("apellido"));
                postulante.setDni(res.getString("dni"));
                postulante.setTelefono(res.getString("telefono"));
                postulante.setEmail(res.getString("email"));
                postulante.setEstado(res.getString("estado"));
                postulante.setCiudad(res.getString("ciudad"));
                postulante.setGenero(res.getString("genero"));
                lista.add(postulante);
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
    public ArrayList<EntityPostulante> listarPostulanteAprobado() {
        ArrayList<EntityPostulante> lista = new ArrayList<EntityPostulante>();

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;

        try {

            con = MySQLConnector.getConnection();
            String sql = "select * from tb_postulante where estado = 'aprobado'";
            pstm = con.prepareStatement(sql);
            res = pstm.executeQuery();

            while (res.next()) {
                EntityPostulante postulante = new EntityPostulante();
                postulante.setId(res.getInt("id_postulante"));
                postulante.setNombre(res.getString("nombre"));
                postulante.setApellido(res.getString("apellido"));
                postulante.setDni(res.getString("dni"));
                postulante.setTelefono(res.getString("telefono"));
                postulante.setEmail(res.getString("email"));
                postulante.setEstado(res.getString("estado"));
                postulante.setCiudad(res.getString("ciudad"));
                postulante.setGenero(res.getString("genero"));
                lista.add(postulante);
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
