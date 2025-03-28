package org.learningproject.videohosting.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@RestController
public class VideoViewController {

    private String videoStoragePath = "C:\\Users\\Ghost\\Downloads\\testDemo\\videoHosting\\uploads\\videos";

    private final ResourceLoader resourceLoader;

    public VideoViewController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @GetMapping("/video/{fileName}")
    public ResponseEntity<Resource> getVideo(@PathVariable String fileName) {
        try {
            File file = new File(videoStoragePath + "/" + fileName);
            Resource resource = resourceLoader.getResource("file:" + file.getAbsolutePath());

            // Определяем тип содержимого файла
            String contentType = Files.probeContentType(file.toPath());
            MediaType mediaType = MediaType.parseMediaType(contentType != null ? contentType : "application/octet-stream");

            return ResponseEntity.ok()
                    .contentType(mediaType)
                    .body(resource);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}