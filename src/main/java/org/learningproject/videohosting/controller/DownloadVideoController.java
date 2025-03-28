//package org.learningproject.videohosting.controller;
//
//import org.learningproject.videohosting.model.Video;
//import org.learningproject.videohosting.service.VideoService;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.server.ResponseStatusException;
//
//@RestController
//public class DownloadVideoController {
//    private final VideoService videoService;
//
//    public DownloadVideoController(VideoService videoService) {
//        this.videoService = videoService;
//    }
//
//    @GetMapping("/video/watch/{id}")
//    public ResponseEntity<byte[]> watchVideoById(@PathVariable Integer id){
//        Video video = videoService.getVideo(id);
//        if(video == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.parseMediaType(video.getContentType()));
//        headers.set("Content-Disposition", "inline; mfilename=\"" + video.getFileName() + "\"");
//        byte[] data = video.getData();
//
//        return new ResponseEntity<>(data, headers, HttpStatus.OK);
//    }
//}
