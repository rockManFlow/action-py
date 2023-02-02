package com.kuark.tool.advance.advance20201111;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rock
 * @detail ����ת��
 * @date 2021/3/19 11:07
 */
public class SysConvertMain {
    public static void main(String[] args) {
//        int num=14;
//        int temp=num&15;
//        System.out.println(temp);

        //ת����ʮ�����ơ� �����ƣ��˽��ƣ�Ҳ�����Ƶķ�����
//        Integer.toHexString(1024);
//        System.out.println(Integer.parseInt("400",16)); //��16���Ƶ�400ת����ʮ����
//        System.out.println(Integer.valueOf("400",8));//��8���Ƶ�400ת����ʮ����
//
//
        String s = parseTo16(100);
        System.out.println(s);
    }

    /**
     * ʮ����ת16����ʵ�֣������Ŀ�������ʵ��
     * @param num
     * @return
     */
    public static String parseTo16(Integer num){
        //1. �жϣ������0�Ļ�����ֱ�ӷ���0
        if(num==0){
            return "0";
        }
        //ָ���ַ���
        char [] hexs={'0','1','2','3','4','5','6','7','8','9',
                'A','B','C','D','E','F'};

        List<Character> sbList=new ArrayList<>();
        while (num>0) {  //��֪��Ҫ���м��Ρ�
            //3. ����Щ���ֳ���16,�õ�����
            int temp=num&15;
            sbList.add(hexs[temp]);
            num=num>>>4;//����16,�õ��̡�
        }

        StringBuilder sb=new StringBuilder();
        for(int i=sbList.size()-1;i>=0;i--){
            sb.append(sbList.get(i));
        }

        return sb.toString();
    }
}
