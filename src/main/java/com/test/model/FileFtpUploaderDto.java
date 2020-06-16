package com.test.model;

import org.springframework.stereotype.Component;

@Component
public class FileFtpUploaderDto {
    private String directoryToFile;
    private String fileName;
    private String hostName;
    private String userName;
    private String password;

    public String getDirectoryToFile() {
        return directoryToFile;
    }

    public void setDirectoryToFile(String directoryToFile) {
        this.directoryToFile = directoryToFile;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
