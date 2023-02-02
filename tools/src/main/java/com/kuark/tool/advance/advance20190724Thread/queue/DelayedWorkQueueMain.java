package com.kuark.tool.advance.advance20190724Thread.queue;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author rock
 * @detail �ӳٶ���DelayQueueʹ�ü�ʵ��ԭ�����
 * @date 2021/7/7 17:31
 */
public class DelayedWorkQueueMain {
    public static void main(String[] args) throws InterruptedException {
        // ������ʱ����
        DelayQueue<DelayedMessage> queue = new DelayQueue<DelayedMessage>();
        // �����ʱ��Ϣ,m1 ��ʱ3s
        DelayedMessage m1 = new DelayedMessage("world", 3000);
        // �����ʱ��Ϣ,m2 ��ʱ10s
        DelayedMessage m2 = new DelayedMessage("hello", 10000);
        //����ʱ��Ϣ�ŵ���ʱ������
        queue.offer(m2);
        queue.offer(m1);

        queue.take();//����������������ȴ�
        // ���������߳� ������ӵ���ʱ�����е���Ϣ��ǰ��������������ʱ��
        ExecutorService exec = Executors.newFixedThreadPool(1);

        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        long delayTime=3000;
        //�ȴ�ָ����������֮����
        condition.awaitNanos(TimeUnit.NANOSECONDS.convert(delayTime, TimeUnit.MILLISECONDS) + System.nanoTime());
        condition.await(1,TimeUnit.SECONDS);//����ָ��ʱ��֮����
    }

    private void priorityQueue(){
        PriorityQueue priorityQueue=new PriorityQueue();
        PriorityBo b=new PriorityBo();
        priorityQueue.add(b);
    }

    class PriorityBo{

    }


    //��ʹ��
    /**
     * ��ʼ��
     */
    public void init() {
        Thread daemonThread = new Thread(() -> {
            execute();
        });
        daemonThread.setName("DelayQueueMonitor");
        daemonThread.start();
    }
    private void execute() {
        DelayQueue<DelayedMessage> delayQueue = new DelayQueue<DelayedMessage>();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        while (true) {
            Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
            System.out.println("��ǰ����߳�����:" + map.size());
            int taskNum = delayQueue.size();
            System.out.println("��ǰ��ʱ��������:" + taskNum);
            try {
                // ����ʱ�����л�ȡ����--����Ԫ�أ�û��ʱ���������ֱ���ӳ�ָ��ʱ��
                DelayedMessage delayOrderTask = delayQueue.take();
                if (delayOrderTask != null) {
                    Runnable task = delayOrderTask.getTask();
                    if (null == task) {
                        continue;
                    }
                    // �ύ���̳߳�ִ��task
                    executor.execute(task);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
