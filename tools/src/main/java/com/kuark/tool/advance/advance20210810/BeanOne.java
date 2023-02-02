package com.kuark.tool.advance.advance20210810;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author rock
 * @detail ȷ����IOC����������bean��ʼ�����֮�󣬲�ִ��afterPropertiesSet�����𣿻��Ǹö����ʼ�����֮�󣬾�ִ�У�
 * @date 2021/8/12 20:32
 */
public class BeanOne implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {

    }

//    @Bean(initMethod = "")
//    public void bean(){
//
//    }

    @PostConstruct
    public void init(){
        System.out.println("");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("����ʹ��");
    }
}
