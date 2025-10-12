package org.example.logger;

import java.util.ArrayList;
import java.util.List;

public abstract class LogProcessor {
    LogProcessor nextLogProcessor;
    List<Appender> appenders;

    public LogProcessor(LogProcessor nextLogProcessor) {
        this.nextLogProcessor = nextLogProcessor;
        appenders = new ArrayList<>();
    }

    public abstract void log(LogLevel level);

    public abstract void addAppender(Appender appender);

    public abstract void appendLogToObervers(LogLevel level);

}
