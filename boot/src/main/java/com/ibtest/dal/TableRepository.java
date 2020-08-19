package com.ibtest.dal;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.ibtest.model.FileItem;

import org.springframework.stereotype.Service;

@Service
public class TableRepository {
    private ArrayList<FileItem> files = null;

    public TableRepository() {
        this.files = new ArrayList<FileItem>() {
            {
                add(new FileItem("image.jpg", 54896, new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date())));
                add(new FileItem("grocery.txt", 777, new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date())));
                add(new FileItem("map.pdf", 596, new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date())));
            }
        };
    }

    public ArrayList<FileItem> getFileDetailsDAL() {
        return this.files;
    }

    public void addFileDetailsDAL(FileItem fileItem) {
        this.files.add(fileItem);
    }

}