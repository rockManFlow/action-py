package com.kuark.tool.advance.advance20201111.netty;

import java.net.InetSocketAddress;

/**
 * @author rock
 * @detail ��ȫ������
 * @date 2021/3/12 10:26
 */
public class LearnOneMain {
    public static void main(String[] args) {
        int num=3;
        System.out.println(num<<1);

        String channelCode="dehudehuGarbage";
        if(channelCode.contains("Garbage")){
            channelCode="Garbage";
        }
        System.out.println(channelCode);
    }

    private static void systemProperty(){
        //�û���ȡJVM�Ͳ���ϵͳ��һЩ������Ϣ
        System.getProperty("java.vm.version");//java������汾
        System.getProperty("java.vendor.url"); //java�ٷ���վ
        System.getProperty("java.vm.nam"); //java���������
        System.getProperty("user.country"); //���һ����
        System.getProperty("user.dir"); //���̵�·��
        System.getProperty("java.runtime.version");//java���л����汾
        System.getProperty("os.arch"); //����ϵͳλ����32��64��
        System.getProperty("os.name"); //����ϵͳ����
        System.getProperty("sun.jnu.encoding"); //�����ʽ
        System.getProperty("os.version"); //����ϵͳ�汾
        System.getProperty("java.version"); //java�汾�汾
    }

    private static void securityManager(){
        /**
         * SecurityManager Ӧ�ó���
         *
         * ����������δ֪��Java�����ʱ�򣬸ó�������ж�����루ɾ��ϵͳ�ļ�������ϵͳ�ȣ���
         * Ϊ�˷�ֹ���ж�������ϵͳ����Ӱ�죬��Ҫ�����еĴ����Ȩ�޽��п��ƣ���ʱ���Ҫ����Java��ȫ��������
         * https://blog.csdn.net/weixin_30703911/article/details/95166967
         * ?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.control
         * &dist_request_id=&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.control
         */
    }

    private static void net(){
        InetSocketAddress inetSocketAddress = new InetSocketAddress(8000);

    }


}
