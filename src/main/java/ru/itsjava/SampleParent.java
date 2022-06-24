package ru.itsjava;

public class SampleParent {

    public void method1(){
        System.out.println("SampleParent.method1");
        method2();
    }

    public void method2(){
        System.out.println("SampleParent.method2");
    }
}
