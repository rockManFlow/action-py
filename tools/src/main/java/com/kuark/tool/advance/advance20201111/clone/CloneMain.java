package com.kuark.tool.advance.advance20201111.clone;

/**
 * @author rock
 * @detail
 * Ϊʲô��Ҫclone����Ϊʲô��new
 * 1��new�����ǳ�ʼ�������ֵ����clone�Ƕ���ǰ�����޸�״̬-��ǰֵ
 * 2��new��������ͨ��set����ֵ���Ƚ��鷳������clone��ʽ�Ǹ�native������ִ�бȽϿ�
 *
 * ǳ��¡�����¡����
 * ��Ҫ�����Ƿ�֧���������ͳ�Ա�����ĸ���
 *
 * ǳ��¡�������Ը��ƻ�������
 * һ�㲽���ǣ�ǳ��¡����
 * 1. �����Ƶ�����Ҫʵ��Clonenable�ӿڣ���ʵ�ֵĻ��ڵ���clone�������׳�CloneNotSupportedException�쳣)�� �ýӿ�Ϊ��ǽӿ�(�����κη���)
 * 2. ����clone()�������������η���Ϊpublic�������е���super.clone()�����õ���Ҫ�ĸ��ƶ��󡣣�nativeΪ���ط���)
 * ���ö�����Ǹ��Ƶ����õ�ַ���������¿��ٵĿռ�
 *
 * ���¡
 * ���ò�����ʵ��clone�ӿڣ������ò������ʱ�򣬻��ǱȽ��鷳��
 * ������ʹ�����л�����ȡ�ķ�ʽ��ʵ�����¡
 * @date 2021/6/2 11:25
 */
public class CloneMain {
    public static void main(String[] args) {
        CloneVo v1=new CloneVo();
        v1.setAddr("beijing");
        v1.setAge(20);
        v1.setName("xiaohong");
        ParamCloneVo pc=new ParamCloneVo();
        pc.setDetail("shanghai");
        pc.setPrice(10);
        v1.setParamCloneVo(pc);

        CloneVo v2=v1.clone();
        v2.getParamCloneVo().setDetail("shenzhen");
        System.out.println("v1:"+v1);
        System.out.println("v1==v2:"+(v2==v1));
        System.out.println("v2:"+v2);
    }
}
