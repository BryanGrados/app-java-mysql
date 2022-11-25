package org.zamasDev.validaciones.user;


import org.zamasDev.entity.EntityUser;
import org.zamasDev.gui.FormDashboard;
import org.zamasDev.mantenimiento.GestionUserDAO;
import org.zamasDev.utils.Decorations;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class ValidateUserLoginForm {

    Decorations decor = new Decorations();

    GestionUserDAO gUser = new GestionUserDAO();

    FormDashboard guiDashboardForm = new FormDashboard();
    public static EntityUser userEntity = new EntityUser();

    public void validateUserLogin(JTextField txtUser, JPasswordField txtPass, JSeparator spUser, JSeparator spPass) {

        String user, pass;

        user = getUser(txtUser, spUser);
        pass = getPass(txtPass, spPass);

        if (user == null || pass == null) {

        } else if (!user.matches(RegexUser.USERNAME) && !user.matches(RegexUser.EMAIL)) {
            JOptionPane.showMessageDialog(null, "Username must start with U and have 4 digits" + "\n" + "Email must be valid" + "\n" + "Password must have 8 characters, 1 uppercase, 1 lowercase, 1 number and 1 special character");
        } else if (!pass.matches(RegexUser.PASSWORD)) {
            JOptionPane.showMessageDialog(null, "Password must have at least 8 characters, 1 uppercase, 1 lowercase, 1 number and 1 special character");
        } else {

            userEntity = gUser.loginUser(user, pass);

            if (userEntity != null) {
                JOptionPane.showMessageDialog(null, "Welcome " + userEntity.getUsername());
                guiDashboardForm.setVisible(true);
                guiDashboardForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect username or password");
            }

        }

    }

    private String getPass(JPasswordField txtPass, JSeparator spPass) {
        String pass = null;
        if(txtPass.getPassword().length == 0 || Objects.equals(txtPass.getText(), "Password")) {
            JOptionPane.showMessageDialog(null, "Please fill the password field");
            decor.setErrorPass(txtPass);
            decor.setSeparatorColor(spPass, Color.RED);
        } else {
            pass = String.valueOf(txtPass.getPassword());
        }

        return pass;
    }

    private String getUser(JTextField txtUser, JSeparator spUser) {
        String user = null;
        if(txtUser.getText().equals("Username or Email")) {
            JOptionPane.showMessageDialog(null, "Please fill the username field");
            decor.setErrorText(txtUser);
            decor.setSeparatorColor(spUser, Color.RED);
        } else {
            user = txtUser.getText().trim();
        }

        return user;
    }

}
