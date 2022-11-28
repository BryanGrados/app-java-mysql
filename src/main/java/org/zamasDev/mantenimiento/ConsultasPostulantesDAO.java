package org.zamasDev.mantenimiento;

import org.zamasDev.entity.EntityPostulante;
import org.zamasDev.entity.EntityPracticante;
import org.zamasDev.interfaces.InterfaceConsultarPostulantes;
import org.zamasDev.mysql.MySQLConnector;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class ConsultasPostulantesDAO implements InterfaceConsultarPostulantes {


    @Override
    public ArrayList<EntityPostulante> consultarPostulantePorNombre(String nombre) {

        ArrayList<EntityPostulante> lista = new ArrayList<EntityPostulante>();

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;

        try {

            con = MySQLConnector.getConnection();
            String sql = "Select * FROM sistema.tb_postulante where nombre regexp '^" + nombre + "' or nombre regexp '" + nombre + "'";
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
                postulante.setCiudad(res.getString("ciudad"));
                postulante.setEstado(res.getString("estado"));
                postulante.setGenero(res.getString("genero"));

                lista.add(postulante);
            }

        } catch (Exception e) {

            System.out.println("Error >>> en la instrucción SQL de consultar " + e.getMessage());

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
    public ArrayList<EntityPostulante> consultarPostulantePorDni(String dni) {
        ArrayList<EntityPostulante> lista = new ArrayList<EntityPostulante>();

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;

        try {

            con = MySQLConnector.getConnection();
            String sql = "Select * FROM sistema.tb_postulante where dni regexp '^" + dni + "' or dni regexp '" + dni + "'";
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
                postulante.setCiudad(res.getString("ciudad"));
                postulante.setEstado(res.getString("estado"));
                postulante.setGenero(res.getString("genero"));

                lista.add(postulante);
            }

        } catch (Exception e) {

            System.out.println("Error >>> en la instrucción SQL de consultar " + e.getMessage());

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
    public ArrayList<EntityPostulante> consultarPostulantePorCiudad(String ciudad) {

        ArrayList<EntityPostulante> lista = new ArrayList<EntityPostulante>();

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;

        try {

            con = MySQLConnector.getConnection();
            String sql = "Select * FROM sistema.tb_postulante where ciudad = '" + ciudad + "'";
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
                postulante.setCiudad(res.getString("ciudad"));
                postulante.setEstado(res.getString("estado"));
                postulante.setGenero(res.getString("genero"));

                lista.add(postulante);
            }

        } catch (Exception e) {

            System.out.println("Error >>> en la instrucción SQL de consultar " + e.getMessage());

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
    public ArrayList<EntityPostulante> consultarPostulantePorEstado(String estado) {

        ArrayList<EntityPostulante> lista = new ArrayList<EntityPostulante>();

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;

        try {

            con = MySQLConnector.getConnection();
            String sql = "Select * FROM sistema.tb_postulante where estado = '" + estado + "'";
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
                postulante.setCiudad(res.getString("ciudad"));
                postulante.setEstado(res.getString("estado"));
                postulante.setGenero(res.getString("genero"));

                lista.add(postulante);
            }

        } catch (Exception e) {

            System.out.println("Error >>> en la instrucción SQL de consultar " + e.getMessage());

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
    public String totalPostulantesEnMySQL() {
        String total = "";
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            con = MySQLConnector.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("SELECT COUNT(*) FROM tb_postulante");
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
