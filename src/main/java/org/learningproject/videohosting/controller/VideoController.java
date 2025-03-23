package org.learningproject.videohosting.controller;

import org.learningproject.videohosting.model.Video;
import org.learningproject.videohosting.repository.VideoRepository;
import org.learningproject.videohosting.service.VideoService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@RestController
public class VideoController {

    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping("/videos")
    public Iterable<Video> getVideoList(){
        return videoService.getAllVideos();
    }

    @GetMapping("/video/{id}")
    public Video getVideoById(@PathVariable Integer id){
        Video video = videoService.getVideo(id);
        if(video == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return video;
    }

    @PostMapping("/videos")
    public Video createVideo(@RequestPart("data") MultipartFile videoFile) throws IOException {
        return videoService.saveVideo(videoFile.getOriginalFilename(), videoFile.getContentType(), videoFile.getBytes());
    }
}
