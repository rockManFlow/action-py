package com.kuark.tool.advance.advance20201105util.formal;

import java.util.Random;

/**
 * @author rock
 * @detail ���������
 * @date 2020/11/5 10:07
 */
public class RandomUtil {
    /**
     * ����ָ��λ���������
     * @param len
     * @return
     */
    public static String getRandom3(int len) {
        //Math.pow(����,���η�)
        int digit = (int) Math.pow(10, len - 1);
        //����һ�������intֵ����ֵ����[0,n)������
        int rs = new Random().nextInt(digit * 10);
        if (rs < digit) {
            rs += digit;
        }
        return String.valueOf(rs);
    }
}
