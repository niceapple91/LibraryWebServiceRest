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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olha_Pidhorna on 7/21/2016.
 */
public class BookDao implements DaoInterface<Book>{

    private List<Book> books;
    private Parser parser;
    private String FILE_NAME;
    private static final String FILE_NAME_KEY = "file.books";
    private InputStream inputStream;
    private OutputStream outputStream;
    private DaoInterface<Autor> autorDao;

    public BookDao() {
        propertyInitialise();
        initialising();
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

    private void initialising(){
        autorDao = new AutorDao();
        parser = new JSONParser();
        try {
            books = parser.readerJSON(new Book(),inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Book> getAll() {
        return getAllPrivate();
    }

    @Override
    public Book getOne(int id) {
        return getOnePrivate(id);
    }

    @Override
    public void setOne(int id) throws ExceptionChangeData {
        setOnePrivate(id);
    }

    @Override
    public void changeOne(int id1, int id2) throws ExceptionChangeData {
        changeOnePrivate(id1, id2);
    }

    @Override
    public List<Book> getById(int idToGet) {
        return getByIdPrivate(idToGet);
    }

    private List<Book> getAllPrivate() {
        return books;
    }

    private Book getOnePrivate(int id) {
        for (Book book: books) {
            if (book.getId() == id)
            return book;
        }
        return null;
    }

    private void setOnePrivate(int id) throws ExceptionChangeData {
        boolean flagChanges = false;
        for (Book book: books) {
            if (book.getId() == id) {
                book.setCount(book.getCount() + 1);
                saveBooksChanges();
                flagChanges = true;
            }
        }
        if (!flagChanges){
            throw new ExceptionChangeData();
        }
    }

    private void changeOnePrivate(int id1, int id2) throws ExceptionChangeData {
        boolean flagChanges = false;
        for (Book book: books) {
            if (book.getId() == id1) {
                book.setCount(book.getCount() + 1);
                saveBooksChanges();
                flagChanges = true;
            }
            if (book.getId() == id2) {
                book.setCount(book.getCount() - 1);
                saveBooksChanges();
                flagChanges = true;
            }
        }
        if (!flagChanges){
            throw new ExceptionChangeData();
        }
    }

    private List<Book> getByIdPrivate(int idToGet) {
        List<Autor> autors = autorDao.getAll();
        String autorName = null;
        if (autors != null) {
            for (Autor autor : autors) {
                if (autor.getId() == idToGet) {
                    autorName = autor.getFirstName() + " " + autor.getLastName();
                }
            }
        }
        if (autorName != null){
            List<Book> bookAutor = new ArrayList<>();
            for (Book book: books) {
                if (book.getAutor().equalsIgnoreCase(autorName)) {
                    bookAutor.add(book);
                }
            }
            return bookAutor.size() > 5 ? bookAutor.subList(0,5) : bookAutor;
        }
        return null;
    }

    private void saveBooksChanges(){
        try {
            outputStream = new FileOutputStream(FILE_NAME, false);
            parser.writeJSON(books,outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
