package com.learn.coding.chain;

public class ChainPatternDemo {

    // 实现责任链规定 error -> file -> console
    public static AbstractLogger getChainOfLoggers(){
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();
        loggerChain.logMessage(AbstractLogger.INFO,"控制台信息");
        loggerChain.logMessage(AbstractLogger.DEBUG, "调试信息");
        loggerChain.logMessage(AbstractLogger.ERROR, "错误提示信息");
    }

}
