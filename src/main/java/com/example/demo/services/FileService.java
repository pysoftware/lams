package com.example.demo.services;

import com.example.demo.cache.FileCache;
import com.example.demo.models.FileEntity;
import com.example.demo.requests.CreationFileRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileService {


    private final FileCache fileCache;

    public FileService(FileCache fileCache) {
        this.fileCache = fileCache;
    }

    public void createFile(CreationFileRequest creationFileRequest) throws IOException {
        // Забираем данные о файле который мы загрузили к нам на сервер
        MultipartFile file = creationFileRequest.getFile();

        // эту модель мы храним в нашем кеше - класс с данными о нашем файле
        FileEntity fileEntity = new FileEntity(
                file.getOriginalFilename(),
                file.getSize(),
                file.getBytes()
        );

        fileCache.createFile(fileEntity);
    }
}
