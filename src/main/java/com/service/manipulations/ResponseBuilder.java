package com.service.manipulations;

import com.service.daos.implementation.BookDao;
import com.service.daos.interfaces.DaoInterface;
import com.service.exceptions.ExceptionChangeData;
import com.service.models.Book;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Olha_Pidhorna on 7/21/2016.
 */
public class ResponseBuilder {

    private DaoInterface<Book> bookDao;

    public ResponseBuilder() {
        bookDao = new BookDao();
    }

    public Response getAll(){
        List<Book> books = bookDao.getAll();
        if (books != null &&!books.isEmpty()){
            return Response.status(200).entity(books).build();
        }
        return Response.status(200).entity("Any books in DB").build();
    }

    public Response getOne(int id){
        Book book = bookDao.getOne(id);
        if (book != null){
            return Response.status(200).entity(book).build();
        }
        return Response.status(200).entity("Any book with current id").build();
    }

    public Response setOne(int id){
        try {
            bookDao.setOne(id);
        } catch (ExceptionChangeData exceptionChangeData) {
            return Response.status(201).entity("Failer by returning book. Book was not given").build();
        }
        return Response.status(200).entity("Book was successfully given").build();
    }

    public Response changeOne(int id1, int id2){
        try {
            bookDao.changeOne(id1,id2);
        } catch (ExceptionChangeData exceptionChangeData) {
            return Response.status(201).entity("Failer by changing books. Books were not changed").build();
        }
        return Response.status(200).entity("Books were successfully changed").build();
    }

    public Response getById(int id){
        List <Book> books = bookDao.getById(id);
        if (!books.isEmpty()){
            return Response.status(200).entity(books).build();
        }
        return Response.status(200).entity("Any book with current autor").build();
    }

}
