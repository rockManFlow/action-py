package com.kuark.tool.base.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author rock
 * @detail
 * @date 2021/7/14 15:19
 */
public class ProxyHandler implements InvocationHandler {
    private Object object;
    public ProxyHandler(Object ob){
        this.object=ob;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before invoke "  + method.getName());
        method.invoke(object, args);
        System.out.println("After invoke " + method.getName());
        return null;
    }

    public static void main(String[] args) {
        HelloInterface hello = new HelloInterfaceImpl();

        //���崦����--����������߼�
        InvocationHandler handler = new ProxyHandler(hello);

        // ���������ͨ��������ӿ����������࣬�Ѹýӿڵ����з���ʹ�ô����߼�����װһ�飬���ɽӿڵ����࣬��ִ��ԭ�����ʵ��
        HelloInterface proxyHello = (HelloInterface) Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), handler);

        proxyHello.show();
    }
}
