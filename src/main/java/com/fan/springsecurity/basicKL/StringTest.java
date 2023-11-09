package com.fan.springsecurity.basicKL;

import org.apache.commons.lang3.StringUtils;

public class StringTest {
    public static void main(String[] args) {
//        String s = new String();
//        System.out.println(s == null);
        Person person = new Person();
        Teacher teacher = new Teacher();
//        System.out.println(person instanceof Teacher);
        String str = new String("sdfsdfs");
        System.out.println(str.lastIndexOf("s"));
        System.out.println(str.indexOf("s", 1));
        char c[] = new char[3];

        String s = new String("sdfsd",2,3)
    }
}
