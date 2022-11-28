package org.zamasDev.interfaces;

import org.zamasDev.entity.EntityPostulante;

import java.util.ArrayList;

public interface InterfaceConsultarPostulantes {

    public ArrayList consultarPostulantePorNombre(String nombre);
    public ArrayList consultarPostulantePorDni(String dni);
    public ArrayList consultarPostulantePorCiudad(String ciudad);
    public ArrayList consultarPostulantePorEstado(String estado);
    public String totalPostulantesEnMySQL();

}
