package com.example.demo.cache;

import com.example.demo.models.FileEntity;
import lombok.Setter;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class FileCache {

    @Setter
    private static FileCache instance;

    // Конкрант хеш мап нужен т.к. может быть проблема с тредами (потоками). Почитай, но не углубляйся.
    // Если спросят - скажи в инете увидел
    private final ConcurrentHashMap<String, FileEntity> files = new ConcurrentHashMap<>();

    private FileCache() {}

    public static FileCache getInstance() {
        if (Objects.isNull(instance)) {
            instance = new FileCache();
        }

        return instance;
    }

    // храним в кеше файлы (название файла: его данные)
    public void createFile(FileEntity fileEntity) {
        files.put(fileEntity.getFileName(), fileEntity);
    }
}