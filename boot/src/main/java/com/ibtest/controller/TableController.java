package com.ibtest.controller;

import com.ibtest.dal.TableRepository;
import com.ibtest.model.FileItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TableController {
    @Autowired
    TableRepository _tableRepository = null;

    @GetMapping("/")
    public String home() {
        return "Hello from Spring Boot!";
    }

    @GetMapping(path = "/getFileDetails", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public String getFileDetails() {

        return _tableRepository.getFileDetailsDAL().toString();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/addFileDetails", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addFileDetails(@RequestBody FileItem fileItem) {

        _tableRepository.addFileDetailsDAL(fileItem);
    }

}