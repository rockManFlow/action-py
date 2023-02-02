package com.kuark.tool.advance.advance20190724Thread.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author rock
 * @detail ��������ʵ�֣������п�ʱ����ȡ������ֱ�������ݡ���ʱ��ӻ�������ֱ��Ϊ�տ���
 * @date 2021/2/5 14:12
 */
public class BlockQueue<T> {
    private int size;
    private Queue<T> queue;

    public BlockQueue(int num) {
        this.size=num;
        this.queue=new LinkedList<T>();
    }

    public synchronized void add(T t) throws InterruptedException{
        while (this.queue.size()>=this.size){
            this.wait();
        }
        queue.add(t);
        this.notifyAll();
    }

    public synchronized T get() throws InterruptedException {
        while (this.queue.isEmpty()){
            this.wait();
        }
        T t=queue.poll();
        this.notifyAll();
        return t;
    }
}
