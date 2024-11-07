package com.example.csvreader.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Map;

@Service
public class CsvReaderService {

    private final CsvMapper csvMapper = new CsvMapper();

    public List<Map<String, String>> readCsvFile(String fileName) {
        try {
            // Create a schema with headers automatically detected
            CsvSchema schema = CsvSchema.emptySchema().withHeader();

            // Use TypeReference to specify the exact type for readValues
            return csvMapper
                    .readerFor(new TypeReference<Map<String, String>>() {})
                    .with(schema)
                    .<Map<String, String>>readValues(new File("src/main/resources/" + fileName))
                    .readAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}