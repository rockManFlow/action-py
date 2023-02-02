package com.kuark.tool.advance.advance20190724Thread.nio;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;

/**
 * @author rock
 * @detail
 * @date 2022/3/28 14:51
 */
public class NioInvocationHandler implements InvocationHandler {
    public static final Map<String, Future> resultMap=new ConcurrentHashMap<>();
    private Object target;
    public NioInvocationHandler(Object object){
        this.target=object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        CompletableFuture future=CompletableFuture.supplyAsync(()-> {
            try {
                //������netty����--�����ں˲���ж�·����io�Ĵ���
                //����̲߳�������netty client����netty�ڲ���nio����֤��·���÷�ʽ
                return method.invoke(target,args);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        });
        return future.get();
    }
}
