package org.eagleinvsys.test.converters.impl;

import org.eagleinvsys.test.converters.StandardConverter;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StandardCsvConverter implements StandardConverter {

    private CsvConverter csvConverter = null;

    public StandardCsvConverter(CsvConverter csvConverter) {
        this.csvConverter = csvConverter;
    }

    public StandardCsvConverter() {

    }

    /**
     * Converts given {@link List<Map>} to CSV and outputs result as a text to the provided {@link OutputStream}
     *
     * @param collectionToConvert collection to convert to CSV format. All maps must have the same set of keys
     * @param outputStream        output stream to write CSV conversion result as text to
     */
    @Override
    public void convert(List<Map<String, String>> collectionToConvert, OutputStream outputStream) throws IOException {

        List<Collection<String>> lists = new ArrayList<>();
        lists.add(collectionToConvert.get(0).keySet());
        for (var c : collectionToConvert) {
            lists.add(c.values());
        }

        List<String> collects = lists.stream().map(Object::toString).collect(Collectors.toList());
        String row;
        for (var collect : collects) {
            row = collect.substring(1, collect.length() - 1);
            row = row.replace(",", ";") + "\n";
            outputStream.write(row.getBytes());
        }
    }
}