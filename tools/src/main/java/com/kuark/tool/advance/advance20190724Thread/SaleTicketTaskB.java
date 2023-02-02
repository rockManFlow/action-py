package com.kuark.tool.advance.advance20190724Thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author rock
 * @detail
 * @date 2019/9/16 17:24
 */
@Slf4j
public class SaleTicketTaskB implements Runnable{
    //��Ʊ����ʹ�ڴ�ɼ�
    private volatile Integer sum;

    private final static String lock="LOCK";
    public SaleTicketTaskB(Integer sum){
        log.info("input url="+System.identityHashCode(sum));
        this.sum=sum;
        log.info("ouput url="+System.identityHashCode(this.sum));
    }


    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        while (true) {
          synchronized (lock) {
            if (sum > 0) {
              --sum;
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
