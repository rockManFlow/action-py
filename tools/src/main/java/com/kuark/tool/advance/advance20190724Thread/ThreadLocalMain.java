package com.kuark.tool.advance.advance20190724Thread;

import org.springframework.core.NamedThreadLocal;

/**
 * @author rock
 * @detail InheritableThreadLocal �ص�
 * @date 2020/11/20 15:02
 */
public class ThreadLocalMain {
    public static void main(String[] args) {
        ThreadLocal local=new ThreadLocal();
        local.set("11111");

        //���߳̿ɼ̳и��̵߳���������Ϣ
        final InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<String>();
        inheritableThreadLocal.set("fatherName");
        new Thread(new Runnable() {
            public void run() {
                //�����߳��п��Ի�ȡ���߳���������Ϣ
                String childThreadName = inheritableThreadLocal.get();
                System.out.println("childThreadName1 is:"+childThreadName);

                //���ַ�ʽ�ǻ�ȡ��������������Ϣ�ģ���Ϊ�����������ʵʱ��ȡ��ǰ�߳������ĵ�Thread t = Thread.currentThread();
                String f=(String)local.get();
                System.out.println("local f:"+f);//��ȡ��null

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String childThreadName = inheritableThreadLocal.get();
                        System.out.println("childThreadName11 is:"+childThreadName);
                    }
                }).start();
            } }).start();

        //����spring�Ķ���---�����˸�����
        NamedThreadLocal<Integer> namedThreadLocal=new NamedThreadLocal<Integer>("name-thread-local");
    }
}
