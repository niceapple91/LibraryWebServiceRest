package com.service.parser.interfaces;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by Olha_Pidhorna on 7/21/2016.
 */
public interface Parser {
    public <T>List<T> readerJSON(T object, InputStream inputStream) throws IOException;
    public <T> void writeJSON(List<T> list, OutputStream outputStream) throws IOException;
}
