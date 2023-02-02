package com.kuark.tool.advance.advance20190724Thread.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author rock
 * @detail ���� beforeExecute��afterExecute��terminated�������ﵽ���߳���Ϊ�Ŀ��ƺͼ��
 * ���������߳�������Ŀ�ʼ�ͽ����ļ�أ����߳���ֹ��ʱ���ִ�и÷���terminated
 * @date 2021/2/5 11:05
 */
public class ThreadPoolExecutorMonitor extends ThreadPoolExecutor {
    public ThreadPoolExecutorMonitor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    /**
     * �߳�������ִ��֮ǰ��ִ��
     * @param t
     * @param r
     */
    @Override
    public void beforeExecute(Thread t, Runnable r){
        System.out.println("before execute");
    }

    /**
     * ����ִ�����֮���ִ�У�ͨ����������������Բ����̳߳��쳣
     * @param r
     * @param t
     */
    @Override
    public void afterExecute(Runnable r, Throwable t){
        System.out.println("after execute");
    }

    /**
     * ���߳���ֹ��ʱ��Ż�ִ�и÷���
     */
    @Override
    public void terminated(){
        System.out.println("thread terminated");
    }

    public static void main(String[] args) {
        ThreadPoolExecutorMonitor pool=new ThreadPoolExecutorMonitor(2, 2, 10, TimeUnit.SECONDS, new ArrayBlockingQueue(5));
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("run start");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("run end");
            }
        });

        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("run start2");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("run end2");
            }
        });
    }
}
