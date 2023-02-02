package com.kuark.tool.advance.advance20201111.netty;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author rock
 * @detail ����socket���
 * @date 2021/3/12 15:46
 */
public class ClientMain extends Thread{
    //����һ��Socket����
    Socket socket = null;

    public ClientMain(String host, int port) {
        try {
            //��Ҫ��������IP��ַ�Ͷ˿ںţ����ܻ����ȷ��Socket����
            socket = new Socket(host, port);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        //�ͻ���һ���ӾͿ���д���ݸ���������
        new sendMessThread().start();
//        super.run();
        try {
            // ��Sock���������
            System.out.println("client run m1");
            InputStream s = socket.getInputStream();
            byte[] buf = new byte[1024];
            int len = 0;
            System.out.println("client run m2");
            while ((len = s.read(buf)) != -1) {
                System.out.println(getdate() + "  ������˵��  "+new String(buf, 0, len,"UTF-8"));
            }
            System.out.println("client run end");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //��Socket����д���ݣ���Ҫ�¿�һ���߳�
    class sendMessThread extends Thread{
        @Override
        public void run() {
//            super.run();
            //д����
            Scanner scanner=null;
            OutputStream os= null;
            try {
                scanner=new Scanner(System.in);
                os= socket.getOutputStream();
                String in="";
                //��һֱѭ���ȴ����룬ֱ������ָ�����˳���ʶ����
                do {
                    in=scanner.next();
                    os.write((""+in).getBytes());
                    os.flush();
                } while (!in.equals("bye"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            scanner.close();
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getdate() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String result = format.format(date);
        return result;
    }

    //�������
    public static void main(String[] args) {
        //��Ҫ����������ȷ��IP��ַ�Ͷ˿ں�
        ClientMain clientTest=new ClientMain("127.0.0.1", 1234);
        clientTest.start();
    }
}
