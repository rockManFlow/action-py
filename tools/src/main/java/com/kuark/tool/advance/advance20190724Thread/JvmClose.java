package com.kuark.tool.advance.advance20190724Thread;

/**
 * @author rock
 * @detail
 * һ���ػ�����ֻ��һ����ʼ����δ�������̡߳�
 * ���������ʼ�ر�����ʱ��������һЩδָ����˳����������ע��Ĺرչҹ�����������ͬʱ���С�
 * �����еĹ��Ӷ���ɺ�����Ѿ�����������ȷ�����˳���������������δ����ֹ���ս�����
 * ����������ֹͣ��
 * ��ע�⣬�ػ������߳̽��ڹر������ڼ�������У����ػ��߳����ͨ������exit���������رգ�����ػ������߳�Ҳ��������
 * @date 2020/10/30 17:06
 */
public class JvmClose {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("������������ر�ʱ���ᴥ������̵߳�ִ��");
            }
        }));

        System.out.println("exit");
        //��ֹ��ǰ���е�Java������� �ò�����Ϊ״̬����; ���չ���������״̬���ʾ�쳣��ֹ��
        System.exit(0);
    }
}
