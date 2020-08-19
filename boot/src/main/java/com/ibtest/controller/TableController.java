package com.ibtest.controller;

import java.time.Duration;

import com.ibtest.dal.TableRepository;
import com.ibtest.model.FileItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@CrossOrigin
public class TableController {
    @Autowired
    TableRepository _tableRepository = null;

    // @GetMapping("/")
    // public String home() {
    // return "Hello from Spring Boot!";
    // }

    @GetMapping("/getStorageLimit")
    public int getStorageLimit() {

        return _tableRepository.getStorageLimit();
    }

    /*
     * Requirement 1
     */
    @GetMapping("/getFileDetails")
    public String getFileDetails() {

        return _tableRepository.getFileDetailsDAL().toString();
    }

    /*
     * Requirement 1
     */
    @Async
    @GetMapping(path = "/streamFileDetails", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> streamFileDetails() {

        return Flux.interval(Duration.ofSeconds(5)).map(sequence -> _tableRepository.getFileDetailsDAL().toString());
    }

    /*
     * Requirement 2
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/addFileDetails", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addFileDetails(@RequestBody FileItem fileItem) {

        _tableRepository.addFileDetailsDAL(fileItem);
    }

}