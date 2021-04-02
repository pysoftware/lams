package com.example.demo.models;

import lombok.Data;

@Data
// эту модель мы храним в нашем кеше - класс с данными о нашем файле
public class FileEntity {

    private final String fileName;
    private final long fileSize;
    private final byte[] fileContent;

}
