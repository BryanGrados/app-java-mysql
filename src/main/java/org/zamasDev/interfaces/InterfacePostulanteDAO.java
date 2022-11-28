package org.zamasDev.interfaces;

import org.zamasDev.entity.EntityPostulante;

import java.util.ArrayList;

public interface InterfacePostulanteDAO {
    public int insertarPostulante(EntityPostulante postulante);
    public int actualizarPostulante(EntityPostulante postulante);
    public int eliminarPostulante(int id);
    public ArrayList<EntityPostulante> listarPostulante();

}

