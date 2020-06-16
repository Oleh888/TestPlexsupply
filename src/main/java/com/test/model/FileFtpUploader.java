package com.test.model;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class FileFtpUploader {
    private static final Logger LOGGER = Logger.getLogger(FileReaderDto.class);

    public void uploadFile(FileFtpUploaderDto uploader) {
        FTPClient ftpClient = new FTPClient();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try (InputStream stream = classLoader.getResourceAsStream(uploader.getDirectoryToFile())) {
            ftpClient.connect(uploader.getHostName());
            ftpClient.login(uploader.getUserName(), uploader.getPassword());
            ftpClient.storeFile(uploader.getFileName(), stream);
            ftpClient.logout();
        } catch (IOException e) {
            LOGGER.error("Can not upload file with directory " + uploader.getDirectoryToFile());
        } finally {
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                LOGGER.info("Trouble with disconnecting from ftpClient");
            }
        }
    }
}
