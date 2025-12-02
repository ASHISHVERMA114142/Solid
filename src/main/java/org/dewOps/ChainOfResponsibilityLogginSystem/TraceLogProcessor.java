package org.dewOps.ChainOfResponsibilityLogginSystem;

public class TraceLogProcessor extends LogProcessor{

    TraceLogProcessor(LogProcessor nextLogProcessor){
        super(nextLogProcessor);
    }
    public void info(LogLevel logLevel,String message){
        if(logLevel==LogLevel.TRACE){
            System.out.println("TRACE log level " + message);
        }else{
            super.info(logLevel,message);
        }
    }
}
