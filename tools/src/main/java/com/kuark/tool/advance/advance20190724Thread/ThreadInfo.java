package com.kuark.tool.advance.advance20190724Thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author rock
 * @detail �̻߳�����Ϣʵ��
 * @date 2019/9/27 14:51
 */
@Slf4j
public class ThreadInfo {
    public static void main(String[] a) throws InterruptedException {
//        interruptStatus();
        joinInfo();
    }

    static public void joinInfo() throws InterruptedException {
    Thread threadA =new Thread(
            new Runnable() {
              private String result;

              @Override
              public void run() {
                log.info("joinInfo threadA start");
                try {
                  Thread.sleep(3 * 1000);
                } catch (InterruptedException e) {
                  log.error("", e);
                }
                result = "threadA OK";
                System.out.println(result);
              }
            });
        threadA.start();

        //ͬ�����ã����Ҳ����������ǰ�̣߳�ֻ�е�threadAִ�����֮��Ż����ִ��
        threadA.join();
        System.out.println("end");
    }

    static public void interruptStatus() throws InterruptedException {
    Thread threadB =
        new Thread(){
              int num = 0;
              @Override
              public void run() {
                while (true) {
                  if (isInterrupted()) {
                    System.out.println("��ǰ�߳��ж�");
                    break;
                  }
                  num++;
                  if (num % 100000 == 0) {
                    System.out.println("running");
                  }
                }
              }
            };
        threadB.start();

        Thread.sleep(1*1000);
        System.out.println("main");

        //�ж�ֻ������һ���ж�״̬��ֻ���ж������е��̣߳�����֮�󣬻��״̬����Ϊfalse
        threadB.interrupt();
        System.out.println("isInterrupted Status="+threadB.isInterrupted());
    }

    public static void currentThreadInterrupt() throws InterruptedException {
        Thread threadA=new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("run start");
                try{
                    Thread.sleep(10*1000);
                } catch (InterruptedException e) {
                    log.error("",e);
                }
            }
        });
        threadA.start();

        Thread.sleep(1*1000);
        //��ǰ�߳��ж�
        threadA.interrupt();
    }

}
