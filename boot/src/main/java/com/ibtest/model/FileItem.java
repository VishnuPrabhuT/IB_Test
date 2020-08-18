package com.ibtest.model;

import java.io.Serializable;

public class FileItem implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private int fileID;
    String fileName;
    long size;
    String processedTime;

    public FileItem(String fileName, long size, String processedTime) {
        super();
        this.fileID = 1;
        this.fileName = fileName;
        this.size = size;
        this.processedTime = processedTime;
    }

    @Override
    public String toString() {
        return "{\"fileName\":\"" + fileName + "\", \"size\":\"" + size + "\", \"processedTime\":\"" + processedTime
                + "\"}";
    }
}