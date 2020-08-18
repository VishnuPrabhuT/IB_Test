package com.ibtest.dal;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.ibtest.model.FileItem;

public class TableRepository {
    public static ArrayList<FileItem> files = null;

    public TableRepository() {
        TableRepository.files = new ArrayList<FileItem>() {
            {
                add(new FileItem("file1", 54896, new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date())));
                add(new FileItem("file2", 54896, new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date())));
                add(new FileItem("file3", 54896, new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date())));
                add(new FileItem("file4", 54896, new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date())));

            }
        };
    }

    public ArrayList<FileItem> getFileDetailsDAL() {
        return TableRepository.files;
    }

}