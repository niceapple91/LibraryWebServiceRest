package com.service.daos.interfaces;

import com.service.exceptions.ExceptionChangeData;

import java.util.List;

/**
 * Created by Olha_Pidhorna on 7/21/2016.
 */
public interface DaoInterface<E> {

    public <E>List<E> getAll();
    public <E> E getOne(int id);
    public void setOne(int id) throws ExceptionChangeData;
    public void changeOne(int id1, int id2) throws ExceptionChangeData;
    public <E>List<E> getById(int idToGet);
}
