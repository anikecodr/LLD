package org.example.logger;

public class InfoLogProcessor extends LogProcessor {
  public InfoLogProcessor(LogProcessor nextLogProcessor) {
    super(nextLogProcessor);
  }

  @Override
  public void log(LogLevel level) {
      if(nextLogProcessor == null) return;
    if (level == LogLevel.INFO) {
      System.out.println("Info: Warning: The added value is not within the limits");
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
