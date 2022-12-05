package com.atabs.atabbe.entity;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "backup")
public class DatabaseEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column(name = "backupId")
    private long id;

    private String location;

    private LocalDateTime timestamp;

    @PrePersist
    protected void onCreate() {
        timestamp = LocalDateTime.now();
    }


    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }



}
