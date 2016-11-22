package com.service.daos.implementation;

import com.service.daos.interfaces.DaoInterface;
import com.service.exceptions.ExceptionChangeData;
import com.service.models.Autor;
import com.service.models.Book;
import com.service.parser.JSONParser;
import com.service.parser.interfaces.Parser;
import com.service.properties.PropertiesCreator;
import com.service.properties.SimplePropertyCreator;

import java.io.*;
import java.util.List;

/**
 * Created by Olha_Pidhorna on 7/21/2016.
 */
public class AutorDao implements DaoInterface<Autor>{

    private List<Autor> autors;
    private Parser parser;
    private String FILE_NAME;
    private static final String FILE_NAME_KEY = "file.autors";
    private InputStream inputStream;

    private void initialising(){
        parser = new JSONParser();
        try {
            autors = parser.readerJSON(new Autor(),inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void propertyInitialise(){
        PropertiesCreator property = new SimplePropertyCreator();
        FILE_NAME = property.getProperty(FILE_NAME_KEY);
        try {
            inputStream = new FileInputStream(FILE_NAME);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public AutorDao() {
        propertyInitialise();
        initialising();
    }

    @Override

    public List<Autor> getAll() {
        return autors;
    }

    @Override
    public Autor getOne(int id) {
        return null;
    }

    @Override
    public void setOne(int id) throws ExceptionChangeData {

    }

    @Override
    public void changeOne(int id1, int id2) throws ExceptionChangeData {

    }

    @Override
    public List<Autor> getById(int idToGet) {
        return null;
    }
}
