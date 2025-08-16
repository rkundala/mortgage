package com.example.ingest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.ingest.dto.RecordDto;
import com.example.ingest.model.RecordEntity;
import com.example.ingest.repository.RecordRepository;
import com.example.ingest.util.Mapper;

import java.util.concurrent.CompletableFuture;

@Service
public class AsyncService {

    @Autowired
    private RecordRepository recordRepository;

    @Async
    public CompletableFuture<RecordEntity> processIngestAsync(RecordDto recordDto) {
        RecordEntity recordEntity = Mapper.toEntity(recordDto);
        RecordEntity savedRecord = recordRepository.save(recordEntity);
        return CompletableFuture.completedFuture(savedRecord);
    }
}