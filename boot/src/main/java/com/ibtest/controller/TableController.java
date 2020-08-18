package com.ibtest.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.ibtest.model.FileItem;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TableController {
    @GetMapping("/")
    public String home() {
        return "Hello from Spring Boot!";
    }

    @GetMapping("/getFileDetails")
    public String getFileDetails() {

        ArrayList<FileItem> files = new ArrayList<FileItem>() {
            {
                add(new FileItem("file1", 54896, new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date())));
                add(new FileItem("file2", 54896, new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date())));
                add(new FileItem("file3", 54896, new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date())));
                add(new FileItem("file4", 54896, new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date())));

            }
        };

        return files.toString();
    }

}