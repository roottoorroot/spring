package com.yet.spring.core.loggers;

import java.util.Collections;

public class CombineEventLogger implements EventLogger{
    private final Collections<EventLogger> loggers;

    public CombineEventLogger(Collections<EventLogger> loggers) {
        super();
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) {
        for ( EventLogger eventLogger : loggers ) {
            eventLogger.logEvent(event);
        }

    }
}
