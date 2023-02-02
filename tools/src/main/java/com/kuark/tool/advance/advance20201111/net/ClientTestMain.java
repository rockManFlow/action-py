package com.kuark.tool.advance.advance20201111.net;

import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author rock
 * win 控制台查看命令：netstat -ano | find "ESTABLISHED"
 * 验证TCP最大连接数
 * @date 2021/6/16 10:03
 */
public class ClientTestMain {
    public static final int MAX_CONNECTION_NUM = 100;

    public static void main(String[] args) throws Exception {
        if(3 != args.length){
            System.out.println("Usage: java Client <local ip> <server ip> <server port>\n");
            return;
        }

        //1. 从命令行获取并解析local ip、server ip以及端口
        String lIp = args[0];
        String sIp = args[1];
        int sPort = Integer.parseInt(args[2]);

        //2. 开始建立连接
        //用数组将 socket 保存起来，防止连接被过早释放
        Socket[] sockets = new Socket[MAX_CONNECTION_NUM];
        for(int i = 1; i <= MAX_CONNECTION_NUM; i++){
            try {
                Socket s = new Socket();
                s.bind(new InetSocketAddress(lIp, 0));
                s.connect(new InetSocketAddress(sIp, sPort));
//                s.getChannel().write()

                if(false == s.isConnected()){
                    System.out.println(lIp + " 连接 "+sIp+":"+sPort+" 失败！ ");
                    return;
                }
                sockets[i-1] = s;

            } catch (Exception e) {
                //连接失败则小憩一会儿接着连
                Thread.sleep(500);
                e.printStackTrace();
            }

            //稍稍停顿一下，避免把服务端的握手队列打满
            if(0 == i % 500){
                Thread.sleep(500);
                System.out.println(lIp + " 连接 "+sIp+":"+sPort+" 成功了 "+i+" 条");
            }
        }

        //把所有连接都 hold 一会儿，方便观察
        Thread.sleep(300 * 1000);

        //3. 释放所有的连接
        System.out.println("关闭所有的连接...\n");
        for(int i = 0; i < MAX_CONNECTION_NUM; i++){
            sockets[i].close();
        }
    }
}
