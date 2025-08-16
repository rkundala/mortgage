package com.example.ingest.service;

import com.example.ingest.model.RecordEntity;
import com.example.ingest.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class IngestService {

    private final RecordRepository recordRepository;

    @Autowired
    public IngestService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public CompletableFuture<RecordEntity> saveRecord(RecordEntity recordEntity) {
        return CompletableFuture.supplyAsync(() -> recordRepository.save(recordEntity));
    }
}