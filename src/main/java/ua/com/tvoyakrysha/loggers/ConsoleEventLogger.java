package ua.com.tvoyakrysha.loggers;

import ua.com.tvoyakrysha.model.Event;

public class ConsoleEventLogger implements EventLogger {
    public void logEvent(Event event) {
        System.out.println(event);
    }
}
