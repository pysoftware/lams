package com.example.demo.configuration;

import com.example.demo.cache.FileCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileCacheConfiguration {

    @Bean
    public FileCache getFileCache() {
        return FileCache.getInstance();
    }
}
