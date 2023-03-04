package com.atabs.atabbe.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "holiday")
public class HolidayEntity {

    public enum Type{
        REGULAR,
        SPECIAL
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "holidayId")
    private long id;
    private LocalDate date;
    @Enumerated(EnumType.ORDINAL)
    private Type type;
    private String description;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}