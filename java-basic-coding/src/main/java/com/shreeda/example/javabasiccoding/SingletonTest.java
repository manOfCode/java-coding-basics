package com.shreeda.example.javabasiccoding;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.reflect.*;


class Singleton{

    public String str;
    private static Singleton instance;
    private Singleton() {

    }

    public static Singleton getSingleInstance(){
        if (instance == null) {
            return new Singleton();
        } else {
            return instance;
        }
    }
}


public class SingletonTest {

    public static void main(String[] args) {
        Singleton s = Singleton.getSingleInstance();
    }
}
