package org.zamasDev.validaciones.global;

public class RegexG {


    public static final String NOMBRE = "^[a-zA-Z\\s]{3,30}$";
    public static final String APELLIDO = "^[a-zA-Z\\s]{3,30}$";
    public static final String DNI = "^[0-9]{8}$";
    public static final String TELEFONO = "^[0-9]{9}$";
    public static final String EMAIL = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
    public static final String DINERO = "^[0-9]{1,5}(\\.[0-9]{1,2})?$";
    public static final String FECHA = "^(19|20)\\d\\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$";

}
