package com.learn.coding.chain;

public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level){
        // 赋值给 继承过来的 level
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Console::Logger:" + message);
    }
}
