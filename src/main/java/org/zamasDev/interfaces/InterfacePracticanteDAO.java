package org.zamasDev.interfaces;

import org.zamasDev.entity.EntityPracticante;

import java.util.ArrayList;

public interface InterfacePracticanteDAO {

    public int insertarPracticante(EntityPracticante practicante);
    public int actualizarPracticante(EntityPracticante practicante);
    public int eliminarPracticante(int id);

    public ArrayList<EntityPracticante> listarPracticante();


}
