package org.zamasDev.interfaces;

import org.zamasDev.entity.EntityPostulante;
import org.zamasDev.entity.EntityPracticante;

import java.util.ArrayList;

public interface InterfaceConsultarPracticantes {

    public ArrayList<EntityPracticante> consultarPracticantePorNombre(String nombre);
    public ArrayList<EntityPracticante> consultarPracticantePorDni(String dni);
    public ArrayList<EntityPracticante> consultarPracticantePorFecha(String fecha);
    public ArrayList<EntityPracticante> consultarPracticantePorSueldo(String sueldo, String sueldo2);
    public String totalPracticantesEnMySQL();

}
