package com.kuark.tool.advance.advance20210810;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import javax.servlet.Filter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Proxy;
import java.nio.ByteBuffer;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

/**
 * @author rock
 * @detail
 * @date 2021/11/2 15:33
 */
@Slf4j
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyBean {

    public void designPattern() throws FileNotFoundException {
        /**
         * jdk��ʹ�õ������ģʽ
         */
        //������ģʽ����Builder Pattern��ʹ�ö���򵥵Ķ���һ��һ��������һ�����ӵĶ���
        StringBuilder builder=new StringBuilder();
        builder.append("");
        StringBuffer buffer=new StringBuffer();
        buffer.append(1);
//        ByteBuffer byteBuffer = ByteBuffer.allocate(1);
//        byteBuffer.put();

        //����ģʽ---���Ӷ���Ĵ�����װ�ڹ����У��ɹ���ͳһʵ��
        Calendar calendar=Calendar.getInstance();
        NumberFormat format=NumberFormat.getInstance();

        //ԭ��ģʽ clone:��ԭ��ʵ��ָ��������������࣬����ͨ��������Щԭ�ʹ����µĶ���
        Object o=new Object();

        //����ģʽ:���ᴴ��һ������
        Runtime runtime=Runtime.getRuntime();

        //������ģʽ:(Adapter Pattern) ����һ���ӿ�ת���ɿͻ�ϣ������һ���ӿڣ�������ģʽʹ�ӿڲ����ݵ���Щ�����һ����
        Arrays.asList();
//        Collections.list();

        //װ����ģʽ��������һ�����еĶ�������µĹ��ܣ�ͬʱ�ֲ��ı���ṹ
        InputStream inputStream=new FileInputStream("");

        //����ģʽ
//        Proxy

        //������ģʽ
//        Filter
//        javax.servlet.Filter#doFilter()  ͨ����������ʽ�����ø���filter

        //����ģʽ
//        Runnable

        //������ģʽ������˳����ʼ��϶����Ԫ�أ�����Ҫ֪�����϶���ĵײ��ʾ��
        //��hasnext���ж��Ƿ�����һ�����ݣ�next��ȡ���ݡ�����ʵ�ּ������Լ��ķ�ʽ��˳��ȡ����
//        Iterator��Scanner
        List<String> list=new ArrayList<>(4);
        list.add("22");
        list.add("11");
        list.add("33");
        list.add("44");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }

        //�۲���+����+ģ�巽��
        //�۲��ߣ��������ģ�
        //ApplicationEvent(spring)

        //����:ͨ������/�ӿ� ��ͬ���߼�ʵ�ֲ�ͬ�Ĺ���

        //ģ�巽��ģʽ
        //OutputStream#write����--����ͳһ��ģ�壬�ɸ���ʵ��ʵ�ֲ�ͬ�Ĺ���


    }
    public static void main(String[] args) {
//        boolean equals = Boolean.TRUE.equals(null);
//        System.out.println(equals);
//        System.out.println(System.currentTimeMillis());
//        long l=System.currentTimeMillis()%1000;
//        System.out.println(l);
        log.info("",new NullPointerException("ddd"));
    }

    /**
     * luhn�㷨���㿨��
     * @param userId
     * @return
     */
    private static String getCardNo(String userId) {
//        String cardNo = "50612402020" + userId.substring(userId.length()-7);
        String cardNo ="506124020205041997";
        int count = 0;
        char[] chars = cardNo.toCharArray();
        for(int i = chars.length-1, j=0; i >=0;i-=2,j++){
            int num = Integer.parseInt(chars[i]+"");
            if (j % 2 == 0){
                num *=2;
                if (num >= 10){
                    count +=(num-9);
                }else {
                    count += num;
                }
            }else {
                count += num;
            }
        }
        int lastCardNo = count % 10;
        if (lastCardNo == 0){
            return cardNo + "0";
        }
        lastCardNo = 10 - lastCardNo;
        return cardNo+lastCardNo;
    }
    public void beanImpl(){
        /**
         * ����ʵ�������̣��������� һ������ļ���  һ���Ƕ����ʼ��
         * ����أ����������в����ڸ�class��Ϣʱ���ᴥ�������
         *  ���أ�classpath�м��ض�Ӧ����Ϣ��
         *  ��֤����֤����Ϣ�Ƿ�Ϸ���
         *  ��ʼ����ִ���๹����<clinit>��ʼ������Ϣ���ྲ̬�������ྲ̬����飬JVM��֤�ȳ�ʼ�������ʼ������ִ�������ʼ����
         *
         *
         *  ������������������������չ���������ϵͳ�������   �漰��˫��ί��ԭ��
         *  �������������JVM������Ҫ���࣬����java_home/lib���µ�JVMָ����������
         *  ��չ���������<JAVA_HOME>/lib/extĿ¼�»�����ϵͳ����-Djava.ext.dirָ��λ·���е����
         *  ϵͳ����������������ϵͳ��·��java -classpath��-D java.class.path ָ��·���µ����
         *
         *  ˫��ί��ԭ��
         *  ��ļ��ض����Ƚ����������������أ������������ز�������ʹ���Ӽ���������
         *  �ô�����֤jdk����İ�ȫ�������ظ�����
         *
         *  ����ʵ��������
         *  ִ���๹�캯��init
         *  ���ྲ̬���������ྲ̬����顢���ྲ̬���������ྲ̬����顢�����Ա���������෽���顢���๹�����������Ա���������෽���顢���๹����
         *
         *
         */
    }
}
