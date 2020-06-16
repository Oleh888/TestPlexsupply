package com.test.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class FileReaderDto {
    private static final Logger LOGGER = Logger.getLogger(FileReaderDto.class);

    public List<String> getAll(String directory) {
        List<String> list = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(directory))) {
            list = Files.readAllLines(Paths.get(directory));
            LOGGER.info("Information from file with directory " + directory + "was read");
        } catch (IOException e) {
            LOGGER.error("Can not read from file with directory " + directory);
        }
        return list;
    }
}
