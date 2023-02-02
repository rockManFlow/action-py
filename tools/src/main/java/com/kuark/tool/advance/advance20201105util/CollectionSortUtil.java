package com.kuark.tool.advance.advance20201105util;

import java.util.*;

/**
 * @author rock
 * @detail �����ֵײ�ʹ�õ��ǹ鲢����������㷨
 * ���ԣ�����ʹ�õ�һЩ����Ҳ��ʹ�õĵײ������㷨�͵ײ��һЩ���ݴ洢�߼���ʵ���ϲ㿴�ǻ����Ĺ���
 * Ҫͨ�����󿴱���
 * @date 2021/2/19 15:09
 */
public class CollectionSortUtil {
    public static void main(String[] args) throws ClassNotFoundException {
        List<String> list= Arrays.asList("6", "1", "3", "1","2");
        Collections.sort(list);
        for(String st:list){
            System.out.println(st);
        }

        Arrays.sort(list.toArray());

        //�������ظ�������  set����ͨ��mapʵ��ȥ��
        /**
         * �������ظ�������  set����ͨ��mapʵ��ȥ��
         * ��α�֤˳�򣺵ײ�ʹ��LinkedHashMapʵ��,ʹ�õ��ǽڵ���ǰ��ָ������֤˳���
         * һ�����ݽڵ㱣����������һ���ڵ����һ���ڵ���Ϣ
         */
        LinkedHashSet linkedHashSet=new LinkedHashSet(2);
        linkedHashSet.add(11);

        Class.forName("");

        ClassLoader loader=ClassLoader.getSystemClassLoader();
        loader.loadClass("");
    }
}
