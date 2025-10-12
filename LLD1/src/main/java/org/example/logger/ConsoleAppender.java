package org.example.logger;

public class ConsoleAppender  implements Appender{

    @Override
    public void append(LogLevel level) {
    System.out.println("This is console appender and the log level is" + level.name());
    }
}
