package ru.itsjava;

public class SampleChild extends SampleParent{

    @Override
    public void method2() {
//        super.method2();
        System.out.println("SampleChild.method2");
    }
}
