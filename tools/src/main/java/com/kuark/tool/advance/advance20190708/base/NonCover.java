package com.kuark.tool.advance.advance20190708.base;

/**
 * @author rock
 * @detail ���ǡ�����
 * @date 2023/1/28 18:22
 *
 *
 *
 * ����Ϊ final �ķ������ܱ���д��
 *
 * ����Ϊ static �ķ������ܱ���д�������ܹ����ٴ�������
 */
public class NonCover {
    private int age;
    private String name;

    public void show(){
        System.out.println("base show");
    }

    public void show(int age){
        System.out.println("base show"+age);
    }

    public final void show2(){
        System.out.println("base show2");
    }

    public static void show3(){
        System.out.println("base show3");
    }
}
