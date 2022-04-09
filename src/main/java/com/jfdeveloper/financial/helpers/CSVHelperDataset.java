package com.jfdeveloper.financial.helpers;

import com.jfdeveloper.financial.entities.Dataset;
import org.apache.commons.csv.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVHelperDataset {

    private static final String TYPE="text/csv";
    private final String[] HEADERS={"Source","Target","Weight","typeTrans","fraud"};

    public static boolean hasCSVFormat(MultipartFile file){

        if (TYPE.equals(file.getContentType()) || file.getContentType().equals("application/vnd.ms-excel")){

            return true;
        }
        return false;
    }

    public static List<Dataset> csvToDatasets(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Dataset> DatasetList = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Dataset dataset = new Dataset(
                        csvRecord.get("Source"),
                        csvRecord.get("Target"),
                        Double.parseDouble(csvRecord.get("Weight")),
                        csvRecord.get("typeTrans"),
                        Integer.parseInt(csvRecord.get("fraud"))
                );

                DatasetList.add(dataset);
            }

            return DatasetList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
        public static ByteArrayInputStream datasetsToCSV(List<Dataset> DatasetList) {
            final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

            try (ByteArrayOutputStream out = new ByteArrayOutputStream();
                 CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
                for (Dataset dataset : DatasetList) {
                    List<String> data = Arrays.asList(
                            dataset.getSource(),
                            dataset.getTarget(),
                            String.valueOf(dataset.getWeight()),
                            dataset.getTypeTrans(),
                            String.valueOf(dataset.getFraud())
                    );

                    csvPrinter.printRecord(data);
                }

                csvPrinter.flush();
                return new ByteArrayInputStream(out.toByteArray());
            } catch (IOException e) {
                throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
            }
        }
    }

