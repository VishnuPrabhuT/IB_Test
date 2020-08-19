package com.ibtest.model;

import java.io.Serializable;

public class FileItem implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    // private @Id @GeneratedValue int fileID;
    private String fileName;
    private long size;
    private String processedTime;

    public FileItem(String fileName, long size, String processedTime) {
        // super();
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