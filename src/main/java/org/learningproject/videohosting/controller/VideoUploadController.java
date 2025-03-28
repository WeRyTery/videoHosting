package org.learningproject.videohosting.controller;

import org.learningproject.videohosting.model.Video;
import org.learningproject.videohosting.service.VideoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class VideoUploadController {

    private final VideoService videoService;
    public VideoUploadController(VideoService videoService) {
        this.videoService = videoService;
    }

    private static final String UPLOAD_DIR = "C:\\Users\\Ghost\\Downloads\\testDemo\\videoHosting\\uploads\\videos\\";

    @PostMapping("/videos")
    public String uploadVideo(@RequestParam("data") MultipartFile file) {
        try {
            File dir = new File(UPLOAD_DIR);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            if(!(file.getContentType().equals("video/mp4") || file.getContentType().equals("video/mkv") || file.getContentType().equals("video/webm") || file.getContentType().equals("video/x-matroska")) ) {
                return "Saving unsuccessful.\nGiven data should be of format: mp4, mkv or webm.\nProvided data: " + file.getContentType();
            }

            file.transferTo(new File(UPLOAD_DIR + file.getOriginalFilename()));
            videoService.saveVideo(file.getOriginalFilename(), file.getContentType());
            return "Saving was successful";
        } catch (IOException e) {
            e.printStackTrace();
            return "Saving was unsuccessful";
        }
    }
}