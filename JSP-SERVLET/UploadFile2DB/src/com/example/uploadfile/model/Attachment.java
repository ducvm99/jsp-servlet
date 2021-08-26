package com.example.uploadfile.model;

import java.sql.*;

public class Attachment {
    private long id;
    private String file_name;
    private Blob file_data;
    private String description;

    public Attachment(long id, String file_name, Blob file_data, String description) {
        this.id = id;
        this.file_name = file_name;
        this.file_data = file_data;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public Blob getFile_data() {
        return file_data;
    }

    public void setFile_data(Blob file_data) {
        this.file_data = file_data;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
