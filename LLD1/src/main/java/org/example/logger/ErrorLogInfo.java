package org.example.logger;

public class ErrorLogInfo extends LogProcessor {
  public ErrorLogInfo(LogProcessor nextLogProcessor) {
    super(nextLogProcessor);
  }

  @Override
  public void log(LogLevel level) {
//    if(nextLogProcessor == null) return;
    if (level == LogLevel.ERROR) {
      System.out.println("Error: The debug value is not within the limits");
      appendLogToObervers(level);
    } else if(nextLogProcessor != null) {
      nextLogProcessor.log(level);
    }
  }

  @Override
  public void addAppender(Appender appender) {
    appenders.add(appender);
  }

  @Override
  public void appendLogToObervers(LogLevel level) {
  for (Appender appender: appenders) {
    appender.append(level);
  }
  }
}
