package org.zamasDev.mantenimiento;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.zamasDev.entity.EntityUser;
import org.zamasDev.interfaces.InterfaceUserDAO;
import org.zamasDev.mysql.MySQLConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GestionUserDAO implements InterfaceUserDAO {

    @Override
    public int addUser(EntityUser user) {

        int res = 0;

        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = MySQLConnector.getConnection();
            String sql = "insert into tb_user values (null,?,?,?)";
            pstm = con.prepareStatement(sql);

            pstm.setString(1, user.getUsername());
            pstm.setString(2, user.getEmail());
            pstm.setString(3, user.getPassword());

            res = pstm.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error >>> en la instrucción SQL de registrar "+e.getMessage());
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
    public EntityUser loginUser(String user, String pass) {

        EntityUser entityUser = null;
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res;

        try {
            con = MySQLConnector.getConnection();
            String sql = "SELECT * FROM tb_user WHERE user= ? Or email= ?";
            pstm = con.prepareStatement(sql);

            pstm.setString(1, user);
            pstm.setString(2, user);

            res = pstm.executeQuery();

            while(res.next()) {
                if(BCrypt.verifyer().verify(pass.toCharArray(), res.getString("password")).verified) {
                    entityUser = new EntityUser();
                    entityUser.setUsername(res.getString("user"));
                    entityUser.setEmail(res.getString("email"));
                    entityUser.setPassword(res.getString("password"));
                }
            }
        } catch (Exception e) {
            System.out.println("Error >>> en la instrucción SQL de login "+e.getMessage());
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
        return entityUser;
    }

}
