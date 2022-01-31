package org.eagleinvsys.test.converters;

import org.eagleinvsys.test.converters.impl.StandardCsvConverter;

import java.io.*;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("test.csv");
        OutputStream stream = new FileOutputStream(file);
        List<Map<String, String>> test = List.of(
                Map.of("1", "dada", "2", "mama", "3", "fafa"),
                Map.of("1", "dada", "2", "mama", "3", "fafa"),
                Map.of("1", "dada", "2", "mama", "3", "fafa"),
                Map.of("1", "dada", "2", "mama", "3", "fafa"));

        StandardConverter standardConverter = new StandardCsvConverter();
        standardConverter.convert(test, stream);
    }
}
