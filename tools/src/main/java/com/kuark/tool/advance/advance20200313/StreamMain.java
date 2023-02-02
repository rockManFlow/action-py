package com.kuark.tool.advance.advance20200313;

import com.kuark.tool.advance.advance20200313.vo.StreamVo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author rock
 * @detail
 * @date 2020/11/18 16:17
 */
public class StreamMain {

    public void getOne(){
        List<String> items = new ArrayList<>(1);
        //��ȡ����һ�������Ϊ�շ���ָ��ֵnull
        String s = items.stream().filter(d -> {
            return Boolean.FALSE;
        }).findAny().orElseGet(null);
    }

    /**
     * ���󼯺ϰ���ָ������������
     */
    public void sorted(){
        List<StreamVo> list=new ArrayList<>(1);
        //��Ȼ˳������
        List<StreamVo> resultList = list.stream().sorted(
                Comparator.comparing(StreamVo::getDistance, Comparator.naturalOrder())).collect(Collectors.toList());
        //��������
        resultList= list.stream().sorted(
                Comparator.comparing(StreamVo::getDistance, Comparator.reverseOrder())).collect(Collectors.toList());
        //�Զ����������
        list.stream().sorted(order()).collect(Collectors.toList());
    }

    public static Comparator<StreamVo> order(){
        return (o1, o2) -> {
            String d1=o1.getDistance();
            String d2=o2.getDistance();
            if(!d1.equals(d2)){
                return (Long.valueOf(d1) - Long.valueOf(d2))>0?1:-1;
            }
            return 0;
        };
    }
}
