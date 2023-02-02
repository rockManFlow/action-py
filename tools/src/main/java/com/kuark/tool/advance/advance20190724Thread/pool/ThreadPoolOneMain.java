package com.kuark.tool.advance.advance20190724Thread.pool;

import com.kuark.tool.model.concurrents.test.MyThread;

import java.util.concurrent.*;

/**
 * @author rock
 * @detail
 * @date 2021/5/27 11:49
 */
public class ThreadPoolOneMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * �����̳߳���ʹ�õĶ���
         * SynchronousQueue��ֱ���ύ���񡣶����в�����
         * ���� LinkedBlockingQueue()���޽���У�����߳���ʼ��Ϊ�����߳���
         * ���� ArrayBlockingQueue()���н����
         */

        issuePool();
    }

    private static void cachePool(){
        //newCachedThreadPool(�ɻ�����̳߳� �����߳�)
        ExecutorService pool=Executors.newCachedThreadPool();
        /**
         * ʵ��Դ��
         * new ThreadPoolExecutor(0, Integer.MAX_VALUE,60L, TimeUnit.SECONDS,new SynchronousQueue<Runnable>());
         * �����߳�0������߳���������Ե�������������ʱ�����û�п����߳�ʱ����һֱ�����߳���ִ������
         * ���̳߳���60s������ִ�У���ɱ���ÿ����߳�(keepAliveTime:���߳�������corePoolSizeʱ����Ϊ��ֹ�����̵߳ȴ���������ʱ��) 0
         * ʹ��ͬ�����У�ÿ�Ž�һ�����񣬱���ͬʱ��һ���߳���ʵʱȡ��ִ�С�����ͻ�����
         */
    }

    private static void signalPool(){
        //�޽����  ���̳߳�
        ExecutorService pool= Executors.newSingleThreadExecutor();//����һ�����̳߳�
        for(int i=0;i<100;i++){
            pool.submit(new MyThread());
        }
        pool.shutdown();

        ExecutorService pool2 = Executors.newFixedThreadPool(5);// ����һ���̶���СΪ5���̳߳�

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);//��ʱ�̳߳�
//        scheduledExecutorService.scheduleAtFixedRate()
        /**
         * ��ʱ�̳߳�ʵ���������ӳٶ��� �Զ���ʵ�ֵ�һ��������ӳٶ��� DelayedWorkQueue
         * �ӳ��̳߳ؾ���ԭ��û��
         */
    }

    private static void issuePool() throws ExecutionException, InterruptedException {
        /**
         * �����߳��쳣��ʽ��ʵ��UncaughtExceptionHandler
         */
        Thread t=new Thread(()->{
            System.out.println("Thread run");
            throw new RuntimeException("yichangbuhuo");
        });
        t.setUncaughtExceptionHandler(new MtUncaughtExceptionHandler());
        t.start();

        /**
         * �̳߳��쳣����
         * ThreadPoolExecutorMonitor
         */
        ExecutorService pool = Executors.newFixedThreadPool(1);
        Future<Object> future = pool.submit(() -> {
            System.out.println("run issue");
            throw new RuntimeException("test error");
        });
        //���û�������ȡ����Ĳ������쳣�ǻ�ȡ������
        future.get();
    }
}
