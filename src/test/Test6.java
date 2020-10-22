package test;

import json.data.ClassBean.StudentsBean;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Test6 {

    public static void main(String[] args) throws UnsupportedEncodingException {

        String s1 = "Nexus 5";
        String s3 = "Asia/Shanghai";
        System.out.println("Hello World! = "+ URLEncoder.encode(s1, "utf-8"));
        System.out.println("Hello World! = "+ URLEncoder.encode(s3, "utf-8"));

        StudentsBean studentsBean = new StudentsBean("Tom","21");
        StudentsBean studentsBean1 = studentsBean;
        studentsBean1.setAge("22");


        System.out.println("equals = "+studentsBean1.equals(studentsBean));
        System.out.println("studentsBean1 = "+studentsBean1.toString());
        System.out.println("studentsBean = "+studentsBean.toString());

        test();
    }

    private static void test() {
        Test6 nullTest = null;
// hello
        nullTest.test1("hello");
    }

    private static void test1(String text) {
        System.out.println(text);
    }
}
