package org.zamasDev.interfaces;

import org.zamasDev.entity.EntityEmpleador;

import java.util.ArrayList;

public interface InterfaceEmpleadorDAO {

    public int insertarEmpleador(EntityEmpleador empleador);
    public int actualizarEmpleador(EntityEmpleador empleador);
    public int eliminarEmpleador(int id);
    public ArrayList<EntityEmpleador> listarEmpleador();

}
