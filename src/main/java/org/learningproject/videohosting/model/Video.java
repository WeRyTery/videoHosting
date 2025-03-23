package org.learningproject.videohosting.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

public class Video {
    @Id
    private Integer id;

    @NotEmpty
    private String fileName;

    private String contentType;

    @JsonIgnore
    private byte[] data;

    public Video() {
    }

    public Video(Integer id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
