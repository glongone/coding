package com.learn.coding.prototype;

/**
 * 原型模式：
 * 利用已有的一个原型对象，快速地生成和原型对象一样的实例
 * */

public abstract class Shape implements Cloneable{

    private String id;
    protected String type;

    abstract void draw();

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType(){
        return type;
    }

    public String getId(){
        return id;
    }

    // 重写 Object 中的 clone()
    public Object clone(){
        Object clone = null;
        try{
            clone = super.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return clone;
    }
}
