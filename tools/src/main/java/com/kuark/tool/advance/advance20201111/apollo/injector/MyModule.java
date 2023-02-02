package com.kuark.tool.advance.advance20201111.apollo.injector;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.kuark.tool.model.util.ConfigUtil;

/**
 * @author rock
 * @detail һ��󶨽ӿ���ʵ����
 * @date 2021/4/1 14:15
 */
public class MyModule  extends AbstractModule {
    @Override
    protected void configure() {
        bind(WriteInterface.class).to(WriteInterfaceImpl.class).in(Singleton.class);
        //Ҳ���Ե�����ʵ����
        bind(ConfigUtil.class).in(Singleton.class);
        //....���Զ��
    }
}
