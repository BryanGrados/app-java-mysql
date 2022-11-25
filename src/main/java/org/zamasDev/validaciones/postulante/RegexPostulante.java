package org.zamasDev.validaciones.postulante;

public class RegexPostulante {


    public static final String NOMBRE = "^[a-zA-Z\\s]{3,30}$";
    public static final String APELLIDO = "^[a-zA-Z\\s]{3,30}$";
    public static final String DNI = "^[0-9]{8}$";
    public static final String TELEFONO = "^[0-9]{9}$";
    public static final String EMAIL = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";

}
