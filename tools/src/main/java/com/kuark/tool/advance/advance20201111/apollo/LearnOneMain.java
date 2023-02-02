package com.kuark.tool.advance.advance20201111.apollo;

import com.kuark.tool.advance.advance20201111.Apple;
import com.kuark.tool.advance.advance20201111.Fruit;

import java.security.SecureRandom;
import java.util.ServiceLoader;

/**
 * @author rock
 * @detail
 * @date 2021/3/26 14:37
 */
public class LearnOneMain {
    public static void main(String[] args) {

        //��ȫ�����������
        int nextInt = new SecureRandom().nextInt();
        System.out.println(nextInt);

        Fruit apple = serverLoader(Fruit.class);
        System.out.println(apple);
    }

    /**
     * λ������
     */
    public static void gression(){
        int s1=4 >> 2;//4 ���� 2��2�η� ȡ��
        int s2=8 >> 3;
        int s3=2 >> 4;
        int s4=1 << 4;//1 ���� 2��4�η�
        System.out.println(s1+":"+s2+":"+s3+":"+s4);
    }

    public static <S> S serverLoader(Class<S> clazz){
        ServiceLoader<S> loader = ServiceLoader.load(clazz);
        if(loader.iterator().hasNext()){
            return loader.iterator().next();
        }
        return null;
    }
}
