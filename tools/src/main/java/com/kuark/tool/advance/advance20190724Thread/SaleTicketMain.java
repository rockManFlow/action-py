package com.kuark.tool.advance.advance20190724Thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author rock
 * @detail ��Ʊ
 * @date 2019/9/16 17:38
 */
@Slf4j
public class SaleTicketMain {
    //�����������Ͳ��ý����ڴ�ɼ�����Ϊֱ���޸ĵ���ͬһ���ڴ��ַ
    public static int sum=10;
    public static void main(String[] args){
        log.info("start main");
        //
//        for(int i=0;i<5;i++){
//            new Thread(new SaleTicketTask(sum)).start();
//        }

        //����ͬһ�������ַ�������Integer�����ͣ������Ƕ����ַ�Ĵ���
//        AtomicInteger sumAto=new AtomicInteger(10);
//        for(int i=0;i<5;i++){
//            new Thread(new SaleTicketTaskA(sumAto)).start();
//        }


        //todo �����������ͼ��������ͣ������Ե���������������д��ݣ�Ҳ��ֱ�Ӵ���ֵ
        //�����Ķ������ͣ�����ʵ��
        Integer sum2=new Integer(5);
        log.info("main url="+System.identityHashCode(sum2));
        for(int i=0;i<2;i++){
            new Thread(new SaleTicketTaskB(sum2)).start();
        }
        log.info("start end");
    }
}
