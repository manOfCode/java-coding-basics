package com.shreeda.example.javabasiccoding;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

class Student{
    private String name;
    private String id;
    private String email;

    public String getName() {
        return name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void anothermethod(){  }

}

public class ReflectionBasic {

    public static void main(String[] args){
        Class student = Student.class;
        Method[] methods = student.getDeclaredMethods();

        ArrayList<String> methodList = new ArrayList<>();
        for(Method m : methods){
            String method = m.toString().split("\\(",0)[0];
            String[] subnames = method.split("\\.",0);
            //System.out.println(subnames[subnames.length-1]);
            methodList.add(subnames[subnames.length-1]);
        }
        Collections.sort(methodList);
        for(String name: methodList){
            System.out.println(name);
        }
    }

}