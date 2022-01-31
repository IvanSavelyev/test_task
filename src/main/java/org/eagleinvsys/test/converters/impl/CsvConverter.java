package org.eagleinvsys.test.converters.impl;

import org.eagleinvsys.test.converters.Converter;
import org.eagleinvsys.test.converters.ConvertibleCollection;
import org.eagleinvsys.test.converters.ConvertibleMessage;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.stream.Collectors;

public class CsvConverter implements Converter {

    /**
     * Converts given {@link ConvertibleCollection} to CSV and outputs result as a text to the provided {@link OutputStream}
     *
     * @param collectionToConvert collection to convert to CSV format
     * @param outputStream        output stream to write CSV conversion result as text to
     */
    @Override
    public void convert(ConvertibleCollection collectionToConvert, OutputStream outputStream) throws IOException {
        Collection<String> headers = collectionToConvert.getHeaders();
        int headersNum = headers.size();
        String headerInCsv = String.join(",", headers);//String.join(",", headers);
        outputStream.write(headerInCsv.getBytes());
        Iterable<ConvertibleMessage> recordsInCsv = collectionToConvert.getRecords();
        recordsInCsv.forEach(convertibleMessage -> {

//            outputStream.write(convertibleMessage.getElement().getBytes());
        });
        // TODO: implement
    }

}