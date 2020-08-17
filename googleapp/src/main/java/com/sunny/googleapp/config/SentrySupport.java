package com.sunny.googleapp.config;

import org.springframework.context.annotation.Configuration;

import io.sentry.Sentry;
import io.sentry.event.Event;
import io.sentry.event.EventBuilder;

@Configuration
public class SentrySupport {

	public SentrySupport() {
		System.out.println("------------------------------------ SentrySuppert init()");
		Sentry.init("https://6aedaed7cc624c19acfc7de6cbeb9e76@o434911.ingest.sentry.io/5392551");
	}
	
    public void logSimpleMessage(String msg) {
        EventBuilder eventBuilder = new EventBuilder()
                        .withMessage(msg)
                        .withLevel(Event.Level.ERROR)
                        .withLogger(SentrySupport.class.getName());

        Sentry.capture(eventBuilder);
    }
}