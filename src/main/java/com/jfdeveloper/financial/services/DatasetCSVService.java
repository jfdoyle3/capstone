package com.jfdeveloper.financial.services;


import com.jfdeveloper.financial.entities.Dataset;
import com.jfdeveloper.financial.helpers.CSVHelper;
import com.jfdeveloper.financial.helpers.CSVHelperDataset;
import com.jfdeveloper.financial.respositories.DatasetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class DatasetCSVService {

    @Autowired
    DatasetRepository repository;

    public void save(MultipartFile file){
        try{
            List<Dataset> datasets= CSVHelperDataset.csvToDatasets(file.getInputStream());
                repository.saveAll(datasets);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public ByteArrayInputStream load() {
        List<Dataset> datasets = repository.findAll();

        ByteArrayInputStream in = CSVHelperDataset.datasetsToCSV(datasets);
        return in;
    }

    public List<Dataset> getAllDatasets() {
        return repository.findAll();
    }
}
