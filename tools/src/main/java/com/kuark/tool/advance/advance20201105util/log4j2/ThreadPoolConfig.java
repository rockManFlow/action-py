package com.kuark.tool.advance.advance20201105util.log4j2;

import org.slf4j.MDC;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/**
 * @author rock
 * @detail ��д�̳߳���ʹlog4j2�̳߳������߳̿���ʹ�õ�ǰ���̵߳�traceID����Ӱ����������ʹ��
 * @date 2020/11/20 14:29
 */
public class ThreadPoolConfig {
    @Bean
    public Executor getAsyncExecutor() {
        // ���̳߳ؽ��а�װ��ʹ֧֮��traceId͸��
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor() {
            @Override
            public <T> Future<T> submit(Callable<T> task) {
                // �����̳߳�֮ǰ�ȸ��Ƶ�ǰ�̵߳�MDC
                return super.submit(ThreadMdcUtil.wrap(task, MDC.getCopyOfContextMap()));
            }
            @Override
            public void execute(Runnable task) {
                super.execute(ThreadMdcUtil.wrap(task, MDC.getCopyOfContextMap()));
            }
        };
        // ��������
        executor.initialize();
        return executor;
    }
}
