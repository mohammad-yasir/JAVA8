package com.company.methodReference;

interface InsMethodRef{
    void say();
}
public class InstanceMethodReference {
    public void saySomething(){
        System.out.println("non-static method is called.");
    }
    public static void main(String[] args) {
        InstanceMethodReference methodReference = new InstanceMethodReference();
        InsMethodRef insMethodRef = methodReference::saySomething;
        insMethodRef.say();
        InsMethodRef insMethodRef1 = new InstanceMethodReference()::saySomething;
        insMethodRef1.say();
    }
}  