package com.kuark.tool.advance.advance20190925;

import com.google.common.collect.Lists;
import com.google.common.io.Files;
import redis.clients.jedis.Jedis;

import java.io.File;
import java.nio.charset.Charset;

/**
 * @author rock
 * @detail
 * @date 2019/9/25 11:23
 */
public class LimitPort {
    public static void main(String[] a){

    }

    /**
     * �ֲ�ʽ����
     * Java���ж��Ƿ���Ҫ�����Ĵ���
     */
    public static boolean acquire()throws Exception {
        //ʹ��lua���ԣ�������Redis��ִ�нű�����
        String luaScript = Files.toString(new File("com/kuark/tool/advance/advance20190925/limit.lua"), Charset.defaultCharset());
        Jedis jedis = new Jedis("192.168.147.52",6379);
        String key = "ip:"+ System.currentTimeMillis()/1000;//�˴�����ǰʱ���ȡ����
        String limit ="3";//������С
        return(Long)jedis.eval(luaScript, Lists.newArrayList(key), Lists.newArrayList(limit)) ==1;
    }
}
