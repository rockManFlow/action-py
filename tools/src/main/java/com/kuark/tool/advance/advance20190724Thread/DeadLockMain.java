package com.kuark.tool.advance.advance20190724Thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author rock
 * @detail ����synchronized�ط�����������Ϊ��ȡ�������ȡ������һֱ�ȴ�
 * @date 2019/9/16 21:04
 */
@Slf4j
public class DeadLockMain {
    public static void main(String[] args){
        log.info("start main");
        Object lock1=new Object();
        Object lock2=new Object();
        new Thread(new DeadLockTask(lock1,lock2)).start();
        new Thread(new DeadLockTask(lock2,lock1)).start();
        log.info("end main");
    }
}
