package com.kuark.tool.advance.advance20201111.apollo;

import java.util.ServiceLoader;

/**
 * @author rock
 * @detail
 * @date 2021/7/14 20:31
 */
public class ApolloMain {
    public static void main(String[] args) {
        //��ȡϵͳ���� -Dapollo.configService=1111  ��������
        String configServices = System.getProperty("apollo.configService");

        //��ȡ����ϵͳ�л���������ָ������ֵ
        configServices = System.getenv("APOLLO_CONFIGSERVICE");

        work(ServiceInterface.class);

        System.out.println(System.currentTimeMillis()/1000);
    }

    // SPI
    public static void work(Class clazz){
        ServiceLoader<ServiceInterface> loader = ServiceLoader.load(clazz);

        ServiceInterface next = loader.iterator().next();
        String show = next.show();
        System.out.println(show);

        /**
         * SPI��ȫ��ΪService Provider Interface,��������ṩ�ߣ��ṩ�˷���ӿڵ�һ��ʵ��֮��
         * ��jar����META-INF/services/Ŀ¼��ͬʱ����һ���Է���ӿ��������ļ���
         * ���ļ������ʵ�ָ÷���ӿڵľ���ʵ���ࡣ�����ⲿ����װ�����ģ���ʱ��
         * ����ͨ����jar��META-INF/services/��������ļ��ҵ������ʵ��������
         * ��װ��ʵ���������ģ���ע�롣
         *
         * ʵ�ֵļ��ؾ���ͨ��ServiceLoader.load(clazz)ʵ��
         */
    }
}
