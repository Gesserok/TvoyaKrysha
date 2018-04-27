package ua.com.tvoyakrysha.loggers;


import ua.com.tvoyakrysha.model.Event;

import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger{
    private int cacheSize;
    private List<Event> cache;

    @Override
    public void logEvent(Event event) {
        cache.add(event);
        if (cache.size() == cacheSize) {
            writeEventsFromCache(cache);
            cache.clear();
            System.out.println("Cache has been cleared");
        }
    }

    private void writeEventsFromCache(List<Event> events) {
//        events.stream().peek(super::logEvent).close();
        for (Event event : events) {
            super.logEvent(event);
        }

    }

    public CacheFileEventLogger(int cacheSize) {
        this.cacheSize = cacheSize;
        this.cache = new ArrayList<>();
    }

    public void destroy() {
        if (!cache.isEmpty()) {
            writeEventsFromCache(cache);
            cache.clear();
            System.out.println("Cache has been cleared");
        }
    }

    public int getCacheSize() {
        return cacheSize;
    }

    public void setCacheSize(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    public List<Event> getCache() {
        return cache;
    }

    public void setCache(List<Event> cache) {
        this.cache = cache;
    }

}
