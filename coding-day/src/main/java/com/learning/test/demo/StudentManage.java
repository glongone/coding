package com.learning.test.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author glongone
 * @date 2021/3/28 5:18 下午
 * @desc
 */
public class StudentManage {

    public static void main(String[] args) {
        Map<Integer, Student> array = new HashMap<>();
        System.out.println("----------欢迎来到学生管理系统----------");
        System.out.println("1、添加学生信息\n2、删除学生信息\n3、修改学生信息\n" + "4、查找学生信息\n5、退出");
        boolean flag = true;
        while (flag) {
            System.out.println("请输入你的选择");
            Scanner sc = new Scanner(System.in);
            int number = sc.nextInt();
            switch (number) {
                case 1:
                    addStudent(array);
                    break;
                case 2:
                    deStudent(array);
                    break;
                case 3:
                    setStudent(array);
                    break;
                case 4:
                    getStudent(array);
                    break;
                default:
                    System.out.println("退出");
                    flag = false;
                    break;
            }
        }
    }

    //创建一个方法用于添加学生信息
    public static void addStudent(Map<Integer, Student> map) {
        System.out.println("请输入要添加学生的姓名、年龄、学号、住址");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        int age = sc.nextInt();
        int studyNum = sc.nextInt();
        String address = sc.next();


        Student s = new Student(name, age, studyNum, address);
        map.put(studyNum, s);

    }

    //创建一个方法用于删除学生信息
    public static void deStudent(Map<Integer, Student> array) {
        System.out.println("请输入要删除学生的学号:");
        Scanner sc = new Scanner(System.in);
        int instudyNum = sc.nextInt();
        Student student = array.get(instudyNum);
        if (null != student) {
            array.remove(instudyNum);
        } else {
            System.out.println("学号："+ instudyNum + "学生不存在");
        }
        /*System.out.println("删除后学生信息为:");
        for(int x = 0; x < array.size(); x++){
            Student st = array.get(x);
            System.out.println("姓名  年龄  学号  住址");
            System.out.println(st.getName()+"  "+st.getAge()+"  "+st.getStudyNum()+"  "+st.getAddress());
        }*/
    }

    //创建一个方法用于修改学生的信息
    public static void setStudent(Map<Integer, Student> array) {
        System.out.println("请输入要修改学生的学号:");
        Scanner sc = new Scanner(System.in);
        int instudyNum = sc.nextInt();

        Student st = new Student();
        Scanner sd = new Scanner(System.in);
        String inName = sd.nextLine();
        st.setName(inName);
        String inaddress = sd.nextLine();
        st.setAddress(inaddress);
        int inage = sd.nextInt();
        st.setAge(inage);
        int inNum = sd.nextInt();
        st.setStudyNum(inNum);

        Student student = array.get(instudyNum);
        if (null != student) {
            array.put(instudyNum, student);
        }
        System.out.println("修改后学生信息为:");
        for (Student stu : array.values()) {
            System.out.println("姓名  年龄  学号  住址");
            System.out.println(stu.getName() + "  " + stu.getAge() + "  " + stu.getStudyNum() + "  " + stu.getAddress());
        }
    }

    //创建一个方法用于查找学生的信息
    public static void getStudent(Map<Integer, Student> array) {
        System.out.println("请输入查找学生的学号:");
        Scanner sc = new Scanner(System.in);
        int instudyNum = sc.nextInt();
        Student st = array.get(instudyNum);
        if (null != st) {
            System.out.println("姓名  年龄  学号  住址");
            System.out.println(st.getName() + "  " + st.getAge() + "  " + st.getStudyNum() + "  " + st.getAddress());
            return;
        }
        System.out.println("查找的学生不存在:");
    }
}
