package com.kuark.tool.advance.advance20201111;

import com.alibaba.fastjson.JSON;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * String����
 * ҪŪ��� String ����󳤶ȣ�����Ӧ���˽� String ����ڲ�ʵ�֡��� String ���У���ʹ��һ���ַ�������ά���ַ����еģ����������£�
 *
 * private final char value[];
 * ��Ҳ����˵��String ����󳤶�ȡ�����ַ��������󳤶ȣ�����֪������ָ�����鳤�ȵ�ʱ�򣬿���ʹ�� byte��short��char��int ���ͣ�
 * �����ܹ�ʹ�� long ���͡���Ҳ����˵���������󳤶Ⱦ��� int ���͵����ֵ��
 * �� 0x7fffffff��ʮ���ƾ��� 2147483647��ͬ����Ҳ���� String �������ɵ�����ַ�������
 */
public class StringMain {
    public static void main1(String[] args) {
//        show();
//        StringBuffer
//        StringBuilder
//        String st="dsdefrnurfreb21337y4bbcsdhbccdcjasn";
//        System.out.println(st.hashCode());
        char va[]=new char['2'];

        Map<String, Object> sourceJson = JSON.parseObject("{}", Map.class);
        System.out.println(sourceJson);

        System.out.println(SeriableVo.class.getCanonicalName());

        //ʮ������ת��ָ��������

        SimpleDateFormat  simpleDateFormat=new SimpleDateFormat();
        simpleDateFormat.format(new Date());

    }

    public static void main(String[] args) {
        /**
         * string��������ͨ�Ķ���һ���ġ����ڸı䶼���½��ڴ��ַ������һ��
         */
        String a="aaaa";
        String b=new String("bbbb");
        System.out.println("1result out:"+cover(a));
        System.out.println("2result out:"+cover(b));

        System.out.println("1in out:"+a);
        System.out.println("2in out:"+b);
    }

    private static String cover(String input){
        input=input+1;
        return input;
    }

    public static void show(){
        List<String> lista=new ArrayList<>();
        List<String> listb=Collections.EMPTY_LIST;
        List<String> listc=new ArrayList<>();
        listc.add("111");
        lista.addAll(listb);
        lista.addAll(listc);
        System.out.println("OK");
    }
}
