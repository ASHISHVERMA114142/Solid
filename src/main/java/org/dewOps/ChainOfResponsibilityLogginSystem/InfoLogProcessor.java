package org.dewOps.ChainOfResponsibilityLogginSystem;

public class InfoLogProcessor extends LogProcessor{
    InfoLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }
    public void info(LogLevel logLevel,String message){
        if(logLevel==LogLevel.INFO){
            System.out.println("INFO log logLevel "+message);
        }else{
            System.out.println("Moving to error log processor ");
            super.info(logLevel,message);
        }
    }
}
