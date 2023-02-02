package com.kuark.tool.advance.advance20190724Thread;

/**
 * @author rock
 * @detail �߳��Ⱥ�ִ��
 * @date 2019/10/1 16:07
 */
public class BeforeAfterTask {

  public static void main(String[] args) {
    Thread threadA =
        new Thread(
            () -> {
              try {
                  System.out.println("A ...");
                Thread.sleep(5000);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
              System.out.println("A");
            });

    Thread threadB =
        new Thread(
            () -> {
                try {
                // ������ֱ��aִ�����֮��
                threadA.join();
                System.out.println("B");
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            });

    threadA.start();
    //���߷ŵ�����ط����������֮�󣬲Ż����threadA.join();
    threadB.start();
  }
}
