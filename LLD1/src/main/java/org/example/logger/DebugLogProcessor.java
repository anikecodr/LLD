package org.example.logger;

public class DebugLogProcessor extends LogProcessor {

  public DebugLogProcessor(LogProcessor nextLogProcessor) {
    super(nextLogProcessor);
  }

  @Override
  public void log(LogLevel level) {
    if(nextLogProcessor == null) return;
    if (level == LogLevel.DEBUG) {
      System.out.println("Debug: The debug value is not within the limits");
      appendLogToObervers(level);
    } else {
      nextLogProcessor.log(level);
    }
  }

  @Override
  public void addAppender(Appender appender) {
    appenders.add(appender);
  }

  @Override
  public void appendLogToObervers(LogLevel level) {
    for(Appender appender: appenders) {
      appender.append(level);
    }
  }
}
