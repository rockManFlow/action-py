package com.kuark.tool.advance.advance20201111;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rock
 * @detail
 * @date 2021/2/25 16:12
 */
public class BIgDecMain {
    public static void main(String[] args) {
        BigDecimal a=new BigDecimal("2.550");
        //��������.5��ʱ�������»������ϣ���.51����ѡǰһλ����Ľ�һ
        System.out.println(a.setScale(1,BigDecimal.ROUND_HALF_UP));
        System.out.println(a.setScale(1,BigDecimal.ROUND_HALF_DOWN));

        List<String> strList=new ArrayList<>();
        strList.add("111");
        strList.add("222");
        //listת������
        String[] strings = strList.toArray(new String[0]);
        System.out.println(strings[1]);

        //BigDecimal������ʹ��string��������������ֹ��������׼
        System.out.println(new BigDecimal("0.1").add(new BigDecimal("0.2")));
        System.out.println(new BigDecimal(1.0).subtract(new BigDecimal(0.8)));
        System.out.println(new BigDecimal(4.015).multiply(new BigDecimal(100)));
        System.out.println(new BigDecimal(123.3).divide(new BigDecimal(100)));

        System.out.println(new BigDecimal(123).divide(new BigDecimal(100)));
    }
}
