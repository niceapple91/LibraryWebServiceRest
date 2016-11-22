package com.service.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SinglePropertiesReader {
	private SinglePropertiesReader() {
	}

	private static InputStream inputStream;
	private static Properties instance;
	private static final String FILE_PROPERTY = "src/main/resources/books.properties";

	public static Properties getInstance() {
		if (instance == null) {
			try {
				instance = new Properties();
				inputStream = new FileInputStream(FILE_PROPERTY);
				instance.load(inputStream);
			} catch (Exception e) {
				System.out.println("Exception: " + e);
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					System.out.println("Exception: " + e);
					e.printStackTrace();
				}
			}
		}
		return instance;
	}

}
