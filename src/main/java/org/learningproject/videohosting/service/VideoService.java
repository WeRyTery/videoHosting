package org.learningproject.videohosting.service;

import org.learningproject.videohosting.model.Video;
import org.learningproject.videohosting.repository.VideoRepository;
import org.springframework.stereotype.Service;

@Service
public class VideoService {
    private final VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public Video saveVideo(String fileName, String contentType) {
        Video video = new Video();

        video.setFileName(fileName);
        video.setContentType(contentType);

        videoRepository.save(video);
        return video;
    }

    public Iterable<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    public Video getVideo(Integer id) {
        return videoRepository.findById(id).orElse(null);
    }

}
