package org.dewOps.ChainOfResponsibilityLogginSystem;

public class Main {
    public static void main(String[] args) {
        System.out.println("this is example of chain of responsibiltiy");

        LogProcessor logProcessor=new InfoLogProcessor(new ErrorLogProcessor(new TraceLogProcessor(null)));
        logProcessor.info(LogLevel.INFO," this is message first");
        System.out.println("=========================");
        logProcessor.info(LogLevel.TRACE,"this is logProcessor2 ");
        System.out.println("=========================");
        logProcessor.info(LogLevel.DEBUG,"this is logProcessor 3");
    }
}
