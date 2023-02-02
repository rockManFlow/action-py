package com.kuark.tool.advance.advance20201111;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

/**
 * @author rock
 * @detail ��ȡ�ļ�ͨ�������𲽶�ȡͨ���е����ݵ�buffer��
 * RandomAccessFile ��ȡ�ļ�
 * @date 2021/3/19 18:15
 */
public class FileMain {
    public static void main1(String[] args) throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile("D:\\myProjects\\tools\\src\\main\\java\\com\\kuark\\tool\\advance\\advance20201111\\hs_err_pid1842.log", "rw");
        FileChannel fileChannel = accessFile.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(128);
        int size;

        while ((size=fileChannel.read(buffer))!=-1){
            buffer.flip();
            if(size<128){
                byte[] data=new byte[128];
                buffer.get(data,0,size);
                System.out.println(new String(data));
                continue;
            }
            System.out.println(new String(buffer.array()));
            //������������е����ݣ��������
            buffer.clear();
        }
        fileChannel.close();
    }

    public static void readFile() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("D:\\myProjects\\tools\\src\\main\\resources\\PROVINCES2.txt", "rw");
        String msg;
        while ((msg=randomAccessFile.readLine())!=null){
            System.out.println(msg);
        }
        randomAccessFile.close();
    }

    /**
     * ͨ��ӳ�䷽ʽ������io��������ߴ����ļ���дЧ��
     * @throws IOException
     */
    public static void appendData() throws IOException {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<10;i++){
            sb.append("map"+i+"|");
        }
        byte[] bytes = sb.toString().getBytes();


        RandomAccessFile randomAccessFile = new RandomAccessFile("D:\\myProjects\\tools\\src\\main\\resources\\PROVINCES2.txt", "rw");
        long fileSize = randomAccessFile.length();
        FileChannel fileChannel = randomAccessFile.getChannel();
        //���ļ�ӳ�䵽�����ڴ�(�߼��ڴ棺�����ڴ�+�����ڴ�)��ͨ���������ӳ�������ļ�������ļ��Ƚϴ󣬿��Խ��зֶ�ӳ��
        //      --ӳ�䵽�������ڴ��У����ں��ڴ���м�����Ϣ���ں��ڴ棬��ͨ���ں��ڴ����û��ڴ����ӳ��
        //map0()��������һ����ַaddress���������������read��write�������ļ����ж�д��ͨ��address���ܹ������ļ�
        //��������һ�ε��ڴ��д

        //׷��������Ҫӳ�䵱ǰ�ļ���С��Ҫ�ŵĴ�С
        MappedByteBuffer map = fileChannel.map(FileChannel.MapMode.READ_WRITE, fileSize, bytes.length);

        //Ϊʲô���ַ�ʽ������ʵʱˢ�µ����̵�??
//        MappedByteBuffer map = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, fileSize);
//        ByteBuffer byteBuffer = map.slice();
//        byteBuffer.put(bytes,0,bytes.length);
//        byteBuffer.flip();
//
//        map.put(byteBuffer);
//        map.force();


        map.put(bytes);
        map.force();
        fileChannel.close();
        randomAccessFile.close();
    }

    public static void main(String[] args) throws IOException {
//        readFile();
//        appendData();
//        new ArrayList<>(25);
        sale(3);
    }

    public static void sale(int num){
        int jiangli=num/3;
        int sellNum=num-jiangli;
        BigDecimal multiply = new BigDecimal("4.5").multiply(new BigDecimal(sellNum));
        System.out.println(multiply);
    }
}
