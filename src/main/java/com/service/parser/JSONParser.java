package com.service.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.parser.interfaces.Parser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olha_Pidhorna on 7/20/2016.
 */
public class JSONParser implements Parser {

    public <T>List<T> readerJSON(T object, InputStream inputStream) throws IOException {
        List<T> list = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        list = mapper.readValue(inputStream, mapper.getTypeFactory().constructCollectionType(List.class, object.getClass()));
        return list;
    }

    public <T> void writeJSON(List<T> list, OutputStream outputStream) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
//        FileWriter fw = new FileWriter(fileName, false);
        mapper.writeValue(outputStream, list);
    }

}
