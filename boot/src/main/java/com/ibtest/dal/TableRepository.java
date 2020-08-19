package com.ibtest.dal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CopyOnWriteArrayList;

import com.ibtest.model.FileItem;

import org.springframework.stereotype.Service;

@Service
public class TableRepository {
    private CopyOnWriteArrayList<FileItem> files = null;

    private int limit = 3;

    public TableRepository() {
        this.files = new CopyOnWriteArrayList<FileItem>() {
            {
                add(new FileItem("image.jpg", 54896, new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date())));
                add(new FileItem("grocery.txt", 777, new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date())));
            }
        };
    }

    public CopyOnWriteArrayList<FileItem> getFileDetailsDAL() {
        return this.files;
    }

    public synchronized void addFileDetailsDAL(FileItem fileItem) {
        this.files.add(fileItem);
    }

    public int getStorageLimit() {
        return this.limit;
    }

}