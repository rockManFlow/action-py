package com.kuark.tool.advance.advance20201111.netty;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author rock
 * @detail
 * @date 2021/3/12 15:13
 */
public class ServerMain extends Thread{
    ServerSocket server = null;
    Socket socket = null;

    public ServerMain(int port) {
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

//        super.run();
        try {
            System.out.println(getdate() + "  �ȴ��ͻ�������...");
            //������ס��ֱ��������Ϊֹ
            socket = server.accept();
            new sendMessThread().start();// ���Ӳ�����socket�������÷�����Ϣ�߳�
            System.out.println(getdate() + "  �ͻ��� ��" + socket.getInetAddress().getHostAddress() + "�� ���ӳɹ�...");
            InputStream in = socket.getInputStream();
            int len = 0;
            System.out.println("server run mm1");
            byte[] buf = new byte[1024];
            //����read����-1�ǵ���������ĩβ�����������ݿ��ã��Ż᷵��-1.��������һֱ��������״̬��ʼ�յ��ﲻ������β��������һֱ���᷵��-1
            //��ȡ���ݶ�����������ȡ�ġ�ע�⵱ʹ��FileInputStreamʱ���᷵��-1 ����Ϊ��ȡ�ļ����д�С�ģ���������ȡ���֮�����-1.������������
            //ֱ���ر��������ŵ���󣬲Ż᷵��-1��ִ��while֮����߼�
            while ((len = in.read(buf)) != -1) {
                System.out.println(getdate() + "  �ͻ���: ��"
                        + socket.getInetAddress().getHostAddress() + "��˵��"
                        + new String(buf, 0, len, "UTF-8"));
            }
            System.out.println("server run end");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getdate() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String result = format.format(date);
        return result;
    }

    class sendMessThread extends Thread {
        @Override
        public void run() {
//            super.run();
            Scanner scanner = null;
            OutputStream out = null;
            try {
                if (socket != null) {
                    scanner = new Scanner(System.in);
                    out = socket.getOutputStream();
                    String in = "";
                    //��һֱѭ����ֱ������ָ���˳�����Ϊֹ���ر������
                    do {
                        in = scanner.next();
                        out.write(("" + in).getBytes("UTF-8"));
                        out.flush();// ��ջ�����������
                    } while (!in.equals("q"));
                    scanner.close();
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    // �������
    public static void main(String[] args) {
        ServerMain server = new ServerMain(1234);
        server.start();
    }
}
