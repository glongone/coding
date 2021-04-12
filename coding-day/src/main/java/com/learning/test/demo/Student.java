package com.learning.test.demo;

/**
 * @author glongone
 * @date 2021/3/28 5:18 下午
 * @desc
 */
public class Student {
    //成员方法
    private String name;
    private  int age;
    private int studyNum;
    private  String address;


    //构造方法
    public Student(){

    }
    public Student(String name,int age,int studyNum,String address){
        this.name = name;
        this.age = age;
        this.studyNum = studyNum;
        this.address = address;
        //System.out.println(name +": "+age);
    }
    public void setName(String name){
        this.name = name;
    }
    public  String getName(){
        return name;
    }
    public void  setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    public  void setStudyNum(int studyNum){
        this.studyNum = studyNum;
    }
    public int getStudyNum(){
        return studyNum;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public  String getAddress(){
        return address;
    }

}
