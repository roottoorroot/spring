package com.yet.spring.core.loggers;

import com.yet.spring.core.beans.Event;

import java.io.IOException;
import java.util.ArrayList;

public class CasheFileLogger extends FileEventLogger {

    private int cacheSize;
    private List<Event> cache;

    public CasheFileLogger(String name, int cacheSize) {
        super(name);
        this.cacheSize = cacheSize;
        this.cache = new ArrayList<Event>(cacheSize);
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);

        if (cache.size() == cacheSize) {
            writeEventFromCache();
           cache.clear();
        }

    }

    public void writeEventFromCache() {
        cache.stream().forEach(super::logEvent);

    }

    public void destroy() throws IOException {
        if (!cache.isEmpty()) {
            writeEventFromCache();
        }
    }

}
