package com.example.csvreader.service;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.example.csvreader.model.WeightData;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class CsvReaderService {

    private final String csvFilePath = "src/main/resources/data.csv"; // Path to your CSV file

    public List<WeightData> readCsv() throws IOException {
        File csvFile = new File(csvFilePath);

        CsvMapper csvMapper = new CsvMapper();
        CsvSchema csvSchema = csvMapper.schemaFor(WeightData.class).withHeader().withColumnReordering(true);

        MappingIterator<WeightData> data = csvMapper.readerFor(WeightData.class)
                                                     .with(csvSchema)
                                                     .readValues(csvFile);

        return data.readAll();
    }
}
