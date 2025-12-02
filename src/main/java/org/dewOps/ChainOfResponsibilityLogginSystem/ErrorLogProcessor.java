package org.dewOps.ChainOfResponsibilityLogginSystem;

public class ErrorLogProcessor extends LogProcessor{

    ErrorLogProcessor(LogProcessor nextLogProcessor){
        super(nextLogProcessor);
    }
    public void info(LogLevel logLevel,String message){
        if(logLevel==LogLevel.ERROR){
            System.out.println("ERROR log leveal "+message);
        }else{
            System.out.println("moving to trace log processor");
            super.info(logLevel,message);
        }
    }
}
