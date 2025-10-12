package org.example.logger;

public class FileAppender implements Appender{

    @Override
    public void append(LogLevel level) {
    System.out.println("The output is appended in the File and the log leve is" + level.name());
    }
}
