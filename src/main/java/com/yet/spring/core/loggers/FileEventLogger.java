package com.yet.spring.core.loggers;

import org.apache.commons.io.FileUtils;
import sun.java2d.pipe.hw.AccelDeviceEventNotifier;
import java.io.File;

import java.io.IOException;

public class FileEventLogger implements EventLogger {

    private String name;
    private File fileName;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public void init() {
        file = new File(fileName);
        if (file.exists() && !file.canWrite()) {
            throw new IllegalArgumentException("Can't write to file " + fileName);
        } else if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                throw new IllegalArgumentException("Can't create file " + fileName, e);
            }
        }


    }

    @Override
    public void logEvent(Event event) {
     try {
         FileUtils.writeStringToFile(file, event.toString(), true);
     } catch (IOException e) {
         e.printStackTrace();
     }
    }
}
