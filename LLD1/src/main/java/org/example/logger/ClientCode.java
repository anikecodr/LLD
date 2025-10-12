package org.example.logger;

public class ClientCode {

  public static void main(String[] args) {

    LogProcessor errorLogInfo = new ErrorLogInfo(null);
    errorLogInfo.addAppender(new ConsoleAppender());

    LogProcessor debugLogProcessor = new DebugLogProcessor(errorLogInfo);
    debugLogProcessor.addAppender(new FileAppender());
    debugLogProcessor.addAppender(new ConsoleAppender());


    LogProcessor logProcessor = new InfoLogProcessor(debugLogProcessor);
    logProcessor.addAppender(new FileAppender());


    logProcessor.log(LogLevel.ERROR);
  }
}
