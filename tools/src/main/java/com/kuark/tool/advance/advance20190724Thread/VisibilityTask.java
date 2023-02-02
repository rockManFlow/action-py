package com.kuark.tool.advance.advance20190724Thread;

import lombok.Data;

import java.util.concurrent.TimeUnit;

/**
 * @author rock
 * @detail �߳̿ɼ������
 * ��̬�������̰߳�ȫ����������пɼ���
 * @date 2019/10/3 9:35
 */
public class VisibilityTask {
    private static volatile Boolean isOver=false;

    private static Integer num=1;

    /**
     * ÿ�μ������ͷ���֮ǰ����ͬ�����������еĹ���������ᱻǿ�ƽ��������ڴ��е�����ͬ��ˢ��
     * �����JMM��Java�ڴ�ģ�ͣ��涨��
     * �������ؼ��ֲ����л������ã����пɼ�������
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        lockNoVisibility();
    }

    public static void lockNoVisibility() throws InterruptedException {
        //���Ǳ�֤��������Ŀɼ��ԣ�������
        String lock="lock";
//        Integer num=1;
        EntityA a=new VisibilityTask().new EntityA();
        a.setAge(20);
        a.setName("xiaohong");
        Thread thread =
                new Thread(
                        () -> {
                            a.setName("hhhh");
                            a.setAge(10);
                            synchronized (lock){
                                System.out.println("run before="+a);
                                a.setName("ssss:"+a.getName());
                                a.setAge(a.getAge());
                                try {
                                    TimeUnit.MILLISECONDS.sleep(300);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                a.setAge(a.getAge()+5);
                                System.out.println("run end="+a);
                            }
                        });
        thread.start();

        String lock2="bbbb11";
        Thread thread2 =
                new Thread(
                        () -> {
                            System.out.println("run2 before="+a);
                            synchronized (lock2){
                                System.out.println("run2 before2="+a);
                                try {
                                    TimeUnit.MILLISECONDS.sleep(150);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                a.setName("de222");
                                a.setAge(a.getAge()+10);
                                System.out.println("run2 end="+a);
                            }
                        });
        thread2.start();
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("visibility end="+a);
    }

    public static void visibility() throws InterruptedException {
        //���ڿɼ������⣬���ܻᵼ��run end��Զ���ᱻִ��
        Thread thread =
                new Thread(
                        () -> {
                            while (!isOver) {
//                                Thread.yield();
                                System.out.println("ccc");
                            }
                            System.out.println("run end");
                        });
        thread.start();
        Thread.sleep(112);
        isOver=true;
        System.out.println("visibility end");
    }

    public static void lockVisibility() throws InterruptedException {
        Thread thread =
                new Thread(
                        () -> {
                            synchronized (VisibilityTask.class) {
                                while (!isOver) {
//                                    System.out.println("ccc");
                                }
                                System.out.println("run end");
                            }
                        });
        thread.start();
        Thread.sleep(150);
        isOver=true;
        System.out.println("end");
    }

    public static void show(final int a){
        System.out.println("a="+a);
    }

    @Data
    public class EntityA{
        private String name;
        private Integer age;
    }

    /**
     * volatile�����ڴ�������ʵ�֣�����ǿ��ˢ�µ������У�
     * ���ص㣺��������ڻ�ȡ��ǰǿ������̹߳����ڴ�ֵ����������ȡ(���м���ǰ�߳��޸���ֵ����ûˢ�µ����棬������ʱǿ����ջ�������)+�ͷ���ʱ��ǿ��ˢ��ֵ��������
     * final��α�֤�ɼ���
     * һ�������е�����final���������ȳ�ʼ����֮�󣬲��ܱ�ʹ��--��α�֤��
     * �ڴ��������ã���ֹһЩָ�������򣨼�������ִ�м���ִ�У�+ǿ���߳��е����ݱ���ˢ�µ����ڴ���
     */
}
