package com.company.methodReference;

interface MthRefInterface{
    void say();  
}  
public class MethodReference {  
    public static void saySomething(){  
        System.out.println("Hello, this is static method.");  
    }  
    public static void main(String[] args) {  
        MthRefInterface mthRefInterface = MethodReference::saySomething;
        mthRefInterface.say();
    }  
}  