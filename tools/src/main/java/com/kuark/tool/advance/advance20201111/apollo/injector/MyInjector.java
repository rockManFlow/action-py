package com.kuark.tool.advance.advance20201111.apollo.injector;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author rock
 * @detail  Guice��ΪIOC����
         * Guice��������ܵ�����
         * Injector��һ�������Ĺ���������
         * Binder��һ���ӿں�ʵ�ֵİ�
         * Module��һ��Binder
         * Provider��bean���ṩ��
         * Key��Binder�ж�Ӧһ��Provider
         * Scope��Provider��������
         * Stage�����з�ʽ��Ϊ�˲�ͬ��Ҫ��
 * @date 2021/4/1 14:11
 */
public class MyInjector {
    private static Injector s_injector;
    private static final Object lock=new Object();

    public static Injector getInjector(){
        if(s_injector==null){
            synchronized (lock){
                if(s_injector==null){
                    s_injector= Guice.createInjector(new MyModule());
                }
            }
        }
        return s_injector;
    }

    public static void main(String[] args) {
        WriteInterface instance = getInjector().getInstance(WriteInterface.class);
        instance.write("xxxxx");
    }
}
