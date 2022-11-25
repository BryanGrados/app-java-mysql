package org.zamasDev.interfaces;

import org.zamasDev.entity.EntityUser;

import java.util.ArrayList;

public interface InterfaceUserDAO {

    //register user
    public int addUser(EntityUser user);
    public EntityUser loginUser(String user, String pass);

}
