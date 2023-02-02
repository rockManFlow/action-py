package com.kuark.tool.advance.advance20190724Thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author rock
 * @detail ���̵ƣ���������߳�ֹͣ���̵������߳�ִ��
 * @date 2019/9/16 19:49
 */
public class TrafficLightLatch {
    private final class Sync extends AbstractQueuedSynchronizer {
        @Override
        protected int tryAcquireShared(int ignored) {
            return redLight == 0 ? 1 : -1;
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            return true;
        }
    }

    /**
     * �źŵ�״̬����0�����ƣ�0�����̵�
     */
    volatile private int redLight;

    private Sync sync;

    /**
     * ��ʼ��
     * @param redLight ��ʼ���̵�״̬����0�����ƣ�0�����̵�
     */
    public TrafficLightLatch(int redLight) {
        this.redLight = redLight;
        sync = new Sync();
    }

    /**
     * �����ȴ����̵���ֱ��ͨ��
     * @throws InterruptedException
     */
    public void await() throws InterruptedException {
        sync.acquireSharedInterruptibly(1);
    }

    /**
     * �л�Ϊ���
     */
    public void switchRed(){
        this.redLight = 1;
    }

    /**
     * �л�Ϊ�̵�
     */
    public void switchGreen() {
        this.redLight = 0;
        sync.releaseShared(0);
    }

    /**
     * �Ƿ����̵߳ȴ�
     */
    public boolean hasQueuedThreads() {
        return sync.hasQueuedThreads();
    }

    /**
     * �ȴ��е��߳�
     * @return Collection
     */
    public Collection<Thread> getQueuedThreads() {
        return sync.getQueuedThreads();
    }

    public String getLightColor() {
        return redLight == 0 ? "�̵�" : "���";
    }

    //��������
    public static void main(String[] args) throws IOException, InterruptedException {
        //��ʼ����ͨ�źŵ�Ϊ���
        TrafficLightLatch light = new TrafficLightLatch(1);
        List<Thread> threads = new ArrayList<>();
        //10���߳�ģ�⳵��
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    //System.out.println(String.format("%s: �źŵ�-%s",Thread.currentThread().getName(),light.getLightColor()));
                    try {
                        //�̵�ֱ��ͨ�У���������ȴ�
                        light.await();
                    } catch (InterruptedException e) {
                        //�ָ��ж�
                        Thread.currentThread().interrupt();
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        //�ָ��ж�
                        Thread.currentThread().interrupt();
                    }
                    System.out.println(String.format("%s: �źŵ�-%s ͨ��",Thread.currentThread().getName(),light.getLightColor()));
                }
            });
            threads.add(thread);
            thread.start();
        }

        //�ȴ����������л���ͨ�źŵ�
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command;
        while ((command = reader.readLine()) != null) {
            if(command.equals("switchRed")) {
                light.switchRed();
                Thread.sleep(1000);
                System.out.println(String.format("�ȴ��߳�����%d",light.getQueuedThreads().size()));
            } else if(command.equals("switchGreen")) {
                light.switchGreen();
                Thread.sleep(500);
                System.out.println(String.format("�ȴ��߳�����%d",light.getQueuedThreads().size()));
            } else if (command.equals("stop")){
                System.out.println("terminating...");
                threads.forEach(Thread::interrupt);
                break;
            }
        }
    }
}
