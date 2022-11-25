package org.zamasDev.validaciones.user;

public class RegexUser {

    public final static String USERNAME = "^[U][0-9]-[0-9]{3}$";
    public final static String EMAIL = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
    public final static String PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
    //example: "Password1@"

}
