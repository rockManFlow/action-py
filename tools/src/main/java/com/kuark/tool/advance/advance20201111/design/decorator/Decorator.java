package com.kuark.tool.advance.advance20201111.design.decorator;

/**
 * @author rock
 * @detail װ��������ԭ����ͨ��װ������չ�����¹���
 * ���ģ���ԭ�нӿڵĹ��ܽ�����չ��ԭ������ԭ���ӿڵĵط�ʵ������½ӿ�
 * �ӿ�����Ҫ��ԭ�ӿ�һ��
 * @date 2021/8/9 11:06
 */
public class Decorator implements Component {
    private Component component;
    public Decorator(Component component){
        this.component=component;
    }
    @Override
    public void sampleOpreation() {
        component.sampleOpreation();
        //
        System.out.println("��չ����");
    }
}
