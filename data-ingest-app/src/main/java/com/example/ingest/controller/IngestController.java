package com.example.ingest.controller;

import com.example.ingest.dto.RecordDto;
import com.example.ingest.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/ingest")
public class IngestController {

    private final AsyncService asyncService;

    @Autowired
    public IngestController(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    @PostMapping
    public CompletableFuture<ResponseEntity<String>> ingestData(@RequestBody RecordDto recordDto) {
        return asyncService.processIngestAsync(recordDto)
                .thenApply(result -> ResponseEntity.ok("Data ingestion initiated: " + result))
                .exceptionally(ex -> ResponseEntity.status(500).body("Error during ingestion: " + ex.getMessage()));
    }
}