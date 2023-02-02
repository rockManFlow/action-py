package com.kuark.tool.advance.advance20201111;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author rock
 * @detail ��֤ArrayList�̲߳���ȫ��addAll�±�Խ������
 * @date 2020/11/23 10:22
 */
public class ArrayListMain {
    private static final ThreadLocal<String> local=new ThreadLocal<>();
    public static final List<Integer> numList=new ArrayList<>();
    public static void main(String[] args) throws InterruptedException {
        local.set("aaaa");
        String s = local.get();
        System.out.println("main s:"+s);

        ExecutorService pool = Executors.newCachedThreadPool();
        pool.submit(new Runnable() {
            @Override
            public void run() {
//                String s = local.get();
                System.out.println("run s:"+s);
            }
        });
        System.out.println("main end");
    }

    public class TestRun implements Runnable{
        private Integer num=0;
        public TestRun(Integer num){
            this.num=num;
        }
        @Override
        public void run() {
            int count=0;
            while (count<100){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                numList.add(num);
                System.out.println(Thread.currentThread().getName()+"---"+"��"+(count+1)+"����Ϊ��"+numList.get(numList.size()-1)+"--���ϴ�С��"+numList.size());
                num+=2;
                count++;
            }
        }
    }
}
