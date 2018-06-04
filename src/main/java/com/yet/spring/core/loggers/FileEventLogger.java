package com.yet.spring.core.loggers;

import com.yet.spring.core.beans.Event;
import org.apache.commons.io.FileUtils;

import java.io.File;

import java.io.IOException;

public class FileEventLogger implements EventLogger {

    private String fileName;
    private File file;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

   public void init() throws IOException {
        file = new File(fileName);
        if (file.exists() && !file.canWrite()) {
            throw new IllegalArgumentException("Cant't write to file " + fileName);
        } else if (!file.exists()) {
            file.createNewFile();
        }
   }

    @Override
    public void logEvent(Event event) {
     try {
         FileUtils.writeStringToFile(file, event.toString() + "\n", true);
     } catch (IOException e) {
         e.printStackTrace();
     }
    }
}
