package org.dewOps.ChainOfResponsibilityLogginSystem;

public abstract class LogProcessor {
    LogProcessor nextLogProcessor;
    LogProcessor(LogProcessor nextLogProcessor){
        this.nextLogProcessor=nextLogProcessor;
    }
    public void info(LogLevel logLevel,String message){
        if(nextLogProcessor!=null){
            nextLogProcessor.info(logLevel,message);
        }
    }
}
