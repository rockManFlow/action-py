package com.kuark.tool.advance.advance20201111.lamda;

import java.io.Serializable;

/**
 * @author rock
 * @detail ����ʽ�ӿ���Ҫ�̳�Serializable ��java����������л���SerializedLambda ���󣬰����˺���ʽ�ӿں�ʵ�ַ�������Ϣ
 * @date 2021/1/25 15:12
 */
@FunctionalInterface
public interface MyFunction<T> extends Serializable {
    Object get(T t);
}
