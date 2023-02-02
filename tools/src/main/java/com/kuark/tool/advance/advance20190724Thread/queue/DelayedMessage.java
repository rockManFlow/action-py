package com.kuark.tool.advance.advance20190724Thread.queue;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author rock
 * @detail
 * @date 2022/2/10 16:11
 */
@Data
public class DelayedMessage implements Delayed {
    private String body;
    private long excuteTime;// �ӳ�ʱ��������Ǳ����������ΪҪ��������ж���ʱʱ����
    private Runnable task;

    public Runnable getTask(){
        return this.task;
    }


    public DelayedMessage(String body, long delayTime) {
        this.body = body;
        this.excuteTime = TimeUnit.NANOSECONDS.convert(delayTime, TimeUnit.MILLISECONDS) + System.nanoTime();
    }

    // �ӳ������Ƿ�ʱ���ǰ�����������ж�������ص��Ǹ�����˵�����ڷ���û����
    @Override
    public long getDelay(@NotNull TimeUnit unit) {
        return unit.convert(this.excuteTime - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    // �Զ���ʵ�ֱȽϷ������� 1 0 -1���������ֱ��ʾ �ö������ ���� С��  ������Ȼ˳������ ����

    /**
     * �����Ҫע�⣺�����ӳٶ����߼������ȼ�Խ�ߣ�Խ���ȱ�ִ�У���ʹ���ȼ��͵������Ѿ����ڣ���
     * ֻ�еȶ���Ԫ��ִ�����֮��֮���Ԫ�زŻ�ִ�С����ԣ�������ȼ��ıȽ�����Ǹ��ݹ���ʱ��ĳ������ж�
     * �ӳ�ʱ��Խ���ģ����ȼ�Խ�ͣ���֤�ȵ��ڵ�������ִ�С����������ţ�������ǰ�ţ���Ȼ˳�����У�
     * @param o
     * @return
     */
    @Override
    public int compareTo(@NotNull Delayed o) {
        DelayedMessage message=(DelayedMessage)o;
        if(this.excuteTime>message.getExcuteTime()){
            return 1;
        }else if(this.excuteTime<message.getExcuteTime()){
            return -1;
        }else {
            return 0;
        }
    }
}
