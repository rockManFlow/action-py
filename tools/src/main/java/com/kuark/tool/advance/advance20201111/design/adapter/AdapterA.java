package com.kuark.tool.advance.advance20201111.design.adapter;

/**
 * @author rock
 * @detail ����������⣺���ͨ���̳�ʵ�������������������ж�����������ͨ������ע�룬��չ���ܣ�
 * @date 2021/8/9 10:47
 */
public class AdapterA extends ApiService implements Target {
    @Override
    public void write(Integer age) {
        System.out.println("write age"+age);
    }
}
