package com.kuark.tool.advance.advance20201111.apollo;

import com.google.common.collect.*;
import org.apache.commons.collections4.CollectionUtils;

import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.List;

/**
 * @author rock
 * @detail
 * @date 2021/3/31 10:25
 */
public class LearnTwoMain {
    public static void main(String[] args) {
//        multimap();
        weakReference();

    }

    public static void weakReference(){
        //������
        WeakReference wr=new WeakReference(new ReferBo());
        ReferBo b=(ReferBo)wr.get();
        b.show();
    }

    public static class ReferBo{
        private String name;

        public void show(){
            System.out.println("sssss");
        }
    }


    public static void partition(){
        //step.1 �����и������߼�
        List<Integer> numList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);

        //�Ѵ󼯺Ϸֳ�ָ����С��С����
        List<List<Integer>> partList = Lists.partition(numList, 3);
        if (!CollectionUtils.isEmpty(partList)) {
            for (List<Integer> list : partList) {
                System.out.println(list.toString());
            }
        }
    }

    public static void multimap2(){
        //���key�������������������map���ϣ�����synchronizedSetMultimap���̰߳�ȫ�ļ���
        Multimap deferredResults =Multimaps.synchronizedSetMultimap(TreeMultimap.create());
        //ɸѡ������set���ϵĲ�ͬ����
        // Sets.difference()
    }

    public static void multimap(){
        //ArrayListMultimap ����list��map������
        Multimap<String, String> myMultimap = ArrayListMultimap.create();
        myMultimap.put("Fruits", "Bannana");
        myMultimap.put("Fruits", "Apple");
        myMultimap.put("Fruits", "Pear");
        myMultimap.put("Fruits", "Pear");
        myMultimap.put("Fruits", "Bannana");
        myMultimap.put("Fruits", "Apple");
        myMultimap.put("Fruits", "Pear");
        myMultimap.put("Fruits", "Pear");
        myMultimap.put("Vegetables", "Carrot");

        //ȡkey
        Collection<String> mykeys =myMultimap.keys();
        //ȥ��
        mykeys= ImmutableSet.copyOf(mykeys);
        for (String mykey :mykeys ) {
            Collection<String> myvalue = myMultimap.get(mykey);
            //ȥ��
            myvalue=ImmutableSet.copyOf(myvalue);
            System.out.println(myvalue);
        }
    }
}
