package com.atabs.atabbe.model;


public class Response {

    private long Id;
    private Object data;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

