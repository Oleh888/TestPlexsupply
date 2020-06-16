package com.test.controller;

import com.test.model.FileFtpUploader;
import com.test.model.FileFtpUploaderDto;
import com.test.model.FileReaderDto;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetRestRequest {
    private final FileReaderDto fileReaderDto;
    private final FileFtpUploader fileFtpUploader;

    public GetRestRequest(FileReaderDto fileReaderDto, FileFtpUploader fileFtpUploader) {
        this.fileReaderDto = fileReaderDto;
        this.fileFtpUploader = fileFtpUploader;
    }

    @GetMapping("/")
    public String getRequest() {
        return "Files was downloaded";
    }

    @GetMapping("/file")
    public List<String> getAll(@RequestParam String directory) {
        return fileReaderDto.getAll(directory);
    }

    @PostMapping("/upload")
    public void uploadToFtpServer(@RequestBody FileFtpUploaderDto uploaderDto) {
        fileFtpUploader.uploadFile(uploaderDto);
    }
}
