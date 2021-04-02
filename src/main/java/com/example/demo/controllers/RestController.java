package com.example.demo.controllers;

import com.example.demo.requests.CreationFileRequest;
import com.example.demo.services.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/url")
@Slf4j
public class RestController {
//    /files - get
//    /files - post (данные)
//    /files/{id} - put/ patch (данные)
//    /files/{id} - delete

    private final FileService fileService;

    public RestController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/files")
    // Почитать про ResponseEntity - бест практайс
    public ResponseEntity<?> createFile(@ModelAttribute CreationFileRequest creationFileRequest) throws IOException {

        fileService.createFile(creationFileRequest);

       return ResponseEntity.ok().build();
    }

}