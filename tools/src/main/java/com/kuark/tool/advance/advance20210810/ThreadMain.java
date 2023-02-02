package com.kuark.tool.advance.advance20210810;

import com.alibaba.fastjson.JSON;
import org.springframework.aop.framework.AopContext;

import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author rock
 * @detail
 * @date 2021/8/10 15:16
 */
public class ThreadMain {
    public static void main1(String[] args) {
        ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
        readLock.lock();
        System.out.println("get read lock");
        writeLock.lock();
        System.out.println("get write lock");
        readLock.unlock();
        writeLock.unlock();

        AopContext.currentProxy();

        HashMap map=new HashMap(4);
        List list=new ArrayList(2);
    }

    public static void main(String[] args) {
//        int sizeFor = tableSizeFor(5);
//        System.out.println(sizeFor);
//        String s = UUID.randomUUID().toString().replaceAll("-","");
//        System.out.println(s);
//
//        Set<Long> sa=new HashSet<>(3);
//        sa.add(10L);
//        sa.add(12L);
//        sa.add(3L);
//        System.out.println(JSON.toJSONString(sa));

        String credentialsString = "mdpbanktest" + ":" + "P@ssw0rd1234";
        byte[] encodedBytes = Base64.getEncoder().encode(credentialsString.getBytes(Charset.defaultCharset()));
        String encodedCredentials = new String(encodedBytes, Charset.defaultCharset());
        System.out.println(encodedCredentials);
    }

    private static int tableSizeFor(int cap){
        int MAXIMUM_CAPACITY = 1 << 30;
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    private static void threadLocal(){
        ThreadLocal local=new ThreadLocal();
        local.set("");
    }

    private static void aqs(){
        /**
         *
         *
         * ===============================
         * ReentrantLock �����������ڶ�ռ��
         * ��������ڹ�����
         * ===============================
         * Condition
         *����lock.newCondition()��ʵ��newһ��AQS��ConditionObject�ڲ���Ķ���������������������һ�����У�
         * ������await()������ʱ������һ��Node�ڵ㵽��������У����ҵ���park()����������ǰ�̣߳��ͷŵ�ǰ�̵߳�����
         * ������singal()��������Ƴ��ڲ����еĶ���ͷ����Node��Ȼ�����AQS�еĶ����еȴ�ִ�л���
         */

        ReentrantLock lock=new ReentrantLock();
        lock.lock();
    }
}
