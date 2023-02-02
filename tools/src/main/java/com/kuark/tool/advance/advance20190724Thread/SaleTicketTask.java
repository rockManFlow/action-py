package com.kuark.tool.advance.advance20190724Thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author rock
 * @detail
 * @date 2019/9/16 17:24
 */
@Slf4j
public class SaleTicketTask implements Runnable{
    //��Ʊ����ʹ�ڴ�ɼ�
    private volatile int sum;

    private final static String lock="LOCK";
    public SaleTicketTask(int sum){
//        this.sum=sum;
    }


    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        while (true) {
          synchronized (lock) {
            if (SaleTicketMain.sum > 0) {
              --SaleTicketMain.sum;
              log.info(
                  "Sale ThreadName=[{}],TicketNum=[{}]",
                  currentThread.getName(),
                      SaleTicketMain.sum);
            }else{
                break;
            }
          }
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                log.error("�ж��쳣",e);
            }
        }
        log.info(
                "Sale ThreadName=[{}],end",
                currentThread.getName());
    }
}
