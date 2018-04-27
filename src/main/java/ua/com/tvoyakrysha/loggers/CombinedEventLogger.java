package ua.com.tvoyakrysha.loggers;

import ua.com.tvoyakrysha.model.Event;

import java.io.IOException;
import java.util.Collection;

public class CombinedEventLogger implements EventLogger{
    Collection<EventLogger> loggers;

    public CombinedEventLogger(Collection<EventLogger> loggers) {
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) throws IOException {

    }
}
