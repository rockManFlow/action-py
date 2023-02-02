package com.kuark.tool.advance.advance20190724Thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author rock
 * @detail FutureTaskʵ����Runnable�����Ի�ȡ�߳�ִ�н�����������߳��Ƿ�ȡ����
 * @date 2019/9/17 11:21
 *
 * �߳��������������������ͷ�CPUʱ��Ƭ
 *  sleep(����)��wait��notify���ѣ���������join���ȴ������߳���ֹ��������
 *  �жϡ���ʱ��ִ����
 *
 *  ��yield���߳����ã��ó�CPUִ��Ƭ������������,�̱߳�ɾ���״̬��
 */
@Slf4j
public class FutureTaskMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        runTask();
    }

    private static void futureTask1() throws InterruptedException, ExecutionException {
        /**
         * ʵ��Runnable�ӿڣ�����FutureTask���ڲ���Callable�������Runnable+Callable��ʵ�ָ�ֵ���ò�����Runnable�������callable����
         * ��run������ִ��callable.call����
         */
        FutureTask futureTask=new FutureTask(new CallableTask(3));
        new Thread(futureTask).start();

        while (true){
            if(futureTask.isDone()){
                log.info("result="+futureTask.get());
                break;
            }
            log.info("wait...");
        }
    }

    private static void runTask() throws InterruptedException, ExecutionException, TimeoutException {
        FutureTask futureTask=new FutureTask(new Callable() {
            @Override
            public String call() throws Exception {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("run call");
                return "OK";
            }
        });

        Thread thread=null;
        try {
            thread=new Thread(futureTask);
            thread.start();
//            Object result = futureTask.get(3, TimeUnit.SECONDS);
//            System.out.println("run result="+result);
        }finally {
            //�жϽ������̷߳���һ���жϱ�ʶ�����ڸñ�ʶ�߳��Ƿ���Ӧ����Ҫ�̴߳���
            thread.interrupt();
        }
    }

    /**
     * thread.stop()������ֹͣ�̣߳����Ѿ������Ϊ@Deprecated�����ã���
     * ��ΪͻȻֹͣһ���������л������߳��Ƿǳ�Σ�յģ�����ͻȻ�ϵ�һ��������ûִ����Ͼ�ͻȻ�ر���.
     *
     * ֹͣһ���߳�
     * ʹ�̻߳�ȡ�жϱ�ʶ�����˳�����
     * ʹ��ֹͣλ��ʹ��volatile�ؼ������Σ������ڴ�����ֱ�ӻ�ȡֵ��
     *
     * volatile��ÿ�ζ�ȡvolatile��������Ӧ�ô������ȡ�������Ǵ�CPU�����ȡ��ÿ��д��һ��volatile������Ӧ��д�������У������ǽ���д��CPU���档
     *
     * volatile�ص㣺
     * ���Խ���volatile�����Ķ�д���Ϊһ������ˢ�µĲ�����д��volatile����ʱ���߳��е����б���Ҳ���ᴥ��д�����档����ȡvolatile����ʱ��
     * Ҳͬ���ᴥ���߳������б��������������¶�ȡ����ˣ�Ӧ��������volatile��д������������
     * ����������������������Ҳ����ˢ�¡�����������У�update()������days�ĸ�ֵ���Ƿ���years��months֮��
     * ���Ǳ�֤years��monthsҲ�ܽ����µ�ֵд�뵽���棬����Ƿ�����������֮ǰ����days��д�����棬��years��months�򲻻ᡣ
     *
     * ����ʱ�ᷢ��ָ����������Ȼvolatile��д�����������󣬵�����ָ��������ʱ���Ͳ�һ����
     */
}
