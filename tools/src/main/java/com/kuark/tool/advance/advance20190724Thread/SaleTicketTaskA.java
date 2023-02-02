package com.kuark.tool.advance.advance20190724Thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author rock
 * @detail
 * @date 2019/9/16 17:24
 */
@Slf4j
public class SaleTicketTaskA implements Runnable{
    //��Ʊ����ʹ�ڴ�ɼ�
    private volatile AtomicInteger sum;

    private final static String lock="LOCK";
    public SaleTicketTaskA(AtomicInteger sum){
        this.sum=sum;
    }


    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        while (true) {
          synchronized (lock) {
            if (sum.get()>0) {
              sum.decrementAndGet();
              log.info(
                  "Sale ThreadName=[{}],TicketNum=[{}]",
                  currentThread.getName(),
                      sum);
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
