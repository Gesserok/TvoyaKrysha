package ua.com.tvoyakrysha;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.com.tvoyakrysha.loggers.EventLogger;
import ua.com.tvoyakrysha.model.Client;
import ua.com.tvoyakrysha.model.Event;

import java.io.IOException;
import java.util.Map;

public class App {

    private static ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

    private Client client;
    private Map<String, EventLogger> mapEventLoggers;

    public App(Client client, Map<String, EventLogger> mapEventLoggers) {
        this.client = client;
        this.mapEventLoggers = mapEventLoggers;
    }

    private void logEvent(Event event, String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);
        try {
            eventLogger.logEvent(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");

        for (int i = 0; i < 33; i++) {

            Event event = ctx.getBean(Event.class);
            app.logEvent(event, "Some event for " + i);

            try {
                Thread.sleep(1002);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        event = ctx.getBean(Event.class);
//        app.logEvent(event, "Some event for 2");

        ctx.close();

//        app.logEvent("Some event for user 1");
//        app.logEvent("Some event for user 2");

//        app.client = new Client("1", "John Smith");
//        app.eventLogger = new ConsoleEventLogger();

    }

    public static ConfigurableApplicationContext getCtx() {
        return ctx;
    }
}
