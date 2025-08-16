package com.example.ingest.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "records")
public class RecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDateTime timestamp;

    public RecordEntity() {
    }

    public RecordEntity(String name, LocalDateTime timestamp) {
        this.name = name;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}