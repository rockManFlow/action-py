package com.kuark.tool.advance.advance20190708.base;

/**
 * @author rock
 * @detail
 * @date 2023/1/28 18:27
 */
public class NonCover2 extends NonCover {
    public void show(){
        System.out.println("child show");
    }

    //��д
    public void show(int age){
        System.out.println("child show"+age);
    }

//    public final void show2(){
//        System.out.println("child show2");
//    }

    //�������ྲ̬����
    public static void show3(){
        System.out.println("child show3");
    }
}
