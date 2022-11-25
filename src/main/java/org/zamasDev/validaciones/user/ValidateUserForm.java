package org.zamasDev.validaciones.user;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.zamasDev.entity.EntityUser;
import org.zamasDev.mantenimiento.GestionUserDAO;
import org.zamasDev.utils.Decorations;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class ValidateUserForm {

    Decorations decor = new Decorations();
    GestionUserDAO gUser = new GestionUserDAO();
    EntityUser userEntity = new EntityUser();

    public void validatedUserForm(JTextField txtUser, JTextField txtEmail, JPasswordField password, JPasswordField confirmPassword, JSeparator spUsername, JSeparator spEmail, JSeparator spPassword, JSeparator spConfirmPassword) {

        String user = getUsername(txtUser, spUsername);
        String email = getEmail(txtEmail, spEmail);
        String pass = getPassword(password, spPassword);
        String confirmPass = getConfirmedPassword(confirmPassword, spConfirmPassword);

        if (user == null || email == null || pass == null || confirmPass == null) {

        } else if (user.equals("Username") || email.equals("Email") || pass.equals("Password") || confirmPass.equals("Confirm Password")) {
            JOptionPane.showMessageDialog(null, "Please fill all the fields");
        } else if (!user.matches(RegexUser.USERNAME)) {
            JOptionPane.showMessageDialog(null, "Username must start with U and have 4 digits");
        } else if (!email.matches(RegexUser.EMAIL)) {
            JOptionPane.showMessageDialog(null, "Email must be valid");
        } else if (!pass.matches(RegexUser.PASSWORD)) {
            JOptionPane.showMessageDialog(null, "Password must have 8 characters, 1 uppercase, 1 lowercase, 1 number and 1 special character");
        } else if (!pass.equals(confirmPass)) {
            JOptionPane.showMessageDialog(null, "Passwords do not match");
        } else {

            String bcryptHashString = BCrypt.withDefaults().hashToString(12,pass.toCharArray());

            userEntity.setUsername(user);
            userEntity.setEmail(email);
            userEntity.setPassword(bcryptHashString);

            int res = gUser.addUser(userEntity);

            if(res == 1) {
                JOptionPane.showMessageDialog(null, "User registered successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Error registering user or user already exists");
            }
        }
    }

    private String getUsername (JTextField txtUser, JSeparator spUsername) {
        String user = null;
        if(txtUser.getText().equals("Username")) {
            JOptionPane.showMessageDialog(null, "Please fill the username field");
            decor.setErrorText(txtUser);
            decor.setSeparatorColor(spUsername, Color.RED);
        } else {
            user = txtUser.getText();
        }

        return user;
    }

    private String getEmail (JTextField txtEmail, JSeparator spEmail) {
        String email = null;
        if(txtEmail.getText().equals("Email")) {
            JOptionPane.showMessageDialog(null, "Please fill the email field");
            decor.setErrorText(txtEmail);
            decor.setSeparatorColor(spEmail, Color.RED);
        } else {
            email = txtEmail.getText();
        }

        return email;
    }

    private String getPassword (JPasswordField password, JSeparator spPassword) {
        String pass = null;

        if(password.getPassword().length == 0 || Objects.equals(password.getText(), "Password")) {
            JOptionPane.showMessageDialog(null, "Please fill the password field");
            decor.setErrorPass(password);
            decor.setSeparatorColor(spPassword, Color.RED);
        } else {
            pass = String.valueOf(password.getPassword());
        }
        return pass;
    }

    private String getConfirmedPassword (JPasswordField confirmPassword, JSeparator spConfirmPassword) {
        String confirmPass = null;

        if(confirmPassword.getPassword().length == 0 || Objects.equals(confirmPassword.getText(), "Confirm Password")) {
            JOptionPane.showMessageDialog(null, "Please fill the confirm password field");
            decor.setErrorPass(confirmPassword);
            decor.setSeparatorColor(spConfirmPassword, Color.RED);
        } else {
            confirmPass = String.valueOf(confirmPassword.getPassword());
        }
        return confirmPass;
    }

}
