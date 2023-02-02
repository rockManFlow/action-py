package com.kuark.tool.advance.advance20190724Thread.nio;

import com.kuark.tool.advance.advance20190724Thread.nio.service.Service2Interface;
import com.kuark.tool.advance.advance20190724Thread.nio.service.Service2InterfaceImpl;

import java.lang.reflect.Proxy;

/**
 * @author rock
 * @detail �������ã���������ȡ��ͬ�ӿڵķ��ؽ��
 * @date 2022/3/28 11:45
 */
public class NioMain {
    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            Service2InterfaceImpl s = new Service2InterfaceImpl();
            Service2Interface s2=(Service2Interface)Proxy.newProxyInstance(s.getClass().getClassLoader(),s.getClass().getInterfaces(),new NioInvocationHandler(s));
            String dd = s2.writeEvent("dd", 20L);
            System.out.println("t1:"+dd);
        });

        Thread t2=new Thread(()->{
            Service2InterfaceImpl s = new Service2InterfaceImpl();
            Service2Interface s2=(Service2Interface)Proxy.newProxyInstance(s.getClass().getClassLoader(),s.getClass().getInterfaces(),new NioInvocationHandler(s));
            String dd = s2.writeEvent("sss", 8L);
            System.out.println("t2:"+dd);
        });

        t1.start();
        t2.start();
        System.out.println("main end");
    }
}
