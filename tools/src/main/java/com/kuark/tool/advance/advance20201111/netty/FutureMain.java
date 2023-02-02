package com.kuark.tool.advance.advance20201111.netty;

import java.util.concurrent.*;

/**
 * @author rock
 * @detail
 * @date 2021/3/16 10:34
 */
public class FutureMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //��ʾ���첽������ص�����
        /**
         * Future ��ʾ�첽����Ľ��,�������첽�̵߳Ĳ���������ȡ�����߳��ж�ʵ�֣����߳�ִ��״̬����ȡ�߳̽��
         *
         * FutureTask�Ƕ�Future��һ��ʵ��
         * FutureTask����̵߳�ִ�н��(�����ǽ����Ҳ�������쳣)�ŵ�outcome�У�
         * ���Ǹ���ͨ�Ķ����������֤�̰߳�ȫ���أ�
         * ͨ���߳�״̬����֤�ģ��߳�״̬�ĸ���ʱCAS�̰߳�ȫ�ģ����ֵ�Ķ�ȡֻ������̬֮��Żᱻ��ȡ��
         * ������̬֮���ǲ�������ĸ�ֵ�ġ�������д��ͨ��״̬�ֿ��ģ�
         *
         * FutureTask����ΰ��߳�ִ�н�����µ�
         * ��Running��run������һ�������˷�װ�����߳�runִ�����֮��FutureTask��run�ḳֵ���ؽ��
         * ��װ�Ľ��
         */
        FutureTask future=new FutureTask(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("run");
            }
        },"ok");
        new Thread(future).start();
        boolean done = future.isDone();
        System.out.println("done:"+done);
        TimeUnit.SECONDS.sleep(2);
        Object o = future.get();
        System.out.println("result:"+o);

//        Future future1=new FutureTask(new Callable() {
//            @Override
//            public Object call() throws Exception {
//                return null;
//            }
//        });



    }

    private static void executorFuture() throws ExecutionException, InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        Future<String> futureStr = scheduledExecutorService.submit(new Runnable() {
            @Override
            public void run() {

            }
        }, "ok");
        String s = futureStr.get();
        System.out.println("future result:"+s);
    }
}
