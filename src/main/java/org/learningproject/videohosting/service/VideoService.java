package org.learningproject.videohosting.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.learningproject.videohosting.model.Video;
import org.learningproject.videohosting.repository.VideoRepository;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

@Service
public class VideoService {
    private final VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public Video saveVideo(String fileName, String contentType, byte[] data) {
        Video video = new Video();

        video.setFileName(fileName);
        video.setContentType(contentType);
        video.setData(data);

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
