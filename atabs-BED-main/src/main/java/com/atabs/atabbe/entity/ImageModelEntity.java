package com.atabs.atabbe.entity;

import javax.persistence.*;

@Entity
@Table(name = "image_model")
public class ImageModelEntity {

    @Id
    @GeneratedValue(generator = "image_seq", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "image_seq", sequenceName = "image_sequence", initialValue = 101, allocationSize = 10000000)
    @Column(name = "image_id")
    private long imageId;
    private String name;
    private String type;
    @Column(length = 50000000)
    private byte[] picByte;

    public ImageModelEntity() {

    }

    public long getImageId() {
        return imageId;
    }

    public void setImageId(long imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getPicByte() {
        return picByte;
    }

    public void setPicByte(byte[] picByte) {
        this.picByte = picByte;
    }

    public ImageModelEntity(String name, String type, byte[] picByte) {
        this.name = name;
        this.type = type;
        this.picByte = picByte;
    }
}
