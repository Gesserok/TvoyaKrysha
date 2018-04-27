package ua.com.tvoyakrysha.loggers;

import ua.com.tvoyakrysha.model.Event;

import java.io.IOException;

public interface EventLogger {
    void logEvent(Event event) throws IOException;

}
