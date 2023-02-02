package com.kuark.tool.advance.advance20190724Thread;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @author rock
 * @detail ֹͣ�̷߳�ʽ
 * @date 2022/2/11 15:44
 */
public class InterruptMain {
//    public static void main(String[] args) throws InterruptedException {
//        interruptDoubleStop();
//        System.out.println("main end");
//    }
    public static void main(String[] args) {
        ArrayList<String> list = com.google.common.collect.Lists.newArrayList("bill,transfer,transaction,cashier".split(","));
        System.out.println(list.contains("transfer"));
    }

    /**
     * �ж�ֹͣ
     * ����sleep��waitͨ�������ж��߳�
     * @throws InterruptedException
     */
    public static void interruptStop() throws InterruptedException {
        Thread t1=new Thread(()->{
            System.out.println("start t1");
            while (!Thread.currentThread().isInterrupted()){
                System.out.println("run t1");
            }
            System.out.println("end t1 isInterrupted before:"+Thread.currentThread().isInterrupted());//get
            System.out.println("end t1 interrupted:"+Thread.currentThread().interrupted());//��λ״̬ set+get
            System.out.println("end t1 isInterrupted end:"+Thread.currentThread().isInterrupted());//�ж��߳��Ƿ��жϣ�����ture�����̱߳��ж��ˣ�ֻ��ȥ��ȡһ�£�����ñ��жϱ�־λ
        });
        t1.start();
        TimeUnit.MILLISECONDS.sleep(100);
        t1.interrupt();//set

    }

    /**
     * �жϱ���֮���ٴ��жϸ��߳�
     * @throws InterruptedException
     */
    public static void interruptDoubleStop() throws InterruptedException {
        Thread thread = new Thread(()->{
            System.out.println("start run");
            try {
                TimeUnit.SECONDS.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
                //�ⲿ�ж��쳣֮��,�ٴ��жϣ���ֹ�ж��źű��̵�
                Thread.currentThread().interrupt();
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(10);
        thread.interrupt();
        System.out.println("interruptDoubleStop");
    }

    /**
     * volatile ���α��λ������ֹͣ�߳�
     */
}
