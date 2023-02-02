package com.kuark.tool.advance.advance20210810;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author rock
 * Spring ��ʼ�� BeanFactory ʱ���Ⱪ¶����չ��
 * @detail Spring IoC �������� BeanFactoryPostProcessor ������ʵ�����κ� bean ֮ǰ��ȡ bean �Ķ��壬�������޸�����
 * @date 2021/8/12 11:14
 */
@Component
public class BeanFactoryVo implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        //������ʵ�����κ� bean ֮ǰ��ȡ bean �Ķ��壬�������޸���
        //���磺ɨ��ĳ����·�������ð�·����ʹ����ĳ��ע�����ȫ��ע�ᵽ Spring ��---���ǿ����Զ�������ʵ����ע��@Component
//        beanFactory.getBeansWithAnnotation(Class)
    }
}
