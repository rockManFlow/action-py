package com.kuark.tool.advance.advance20200907.zk;

import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.Arrays;

/**
 * @author rock
 * @detail ͼƬ��MD5���۸�
 * @date 2020/10/28 14:22
 */
public class PictureVerify {
    //��ͼƬʹ��md5����
    private static byte[] img2Md5Bytes(File file, String salt) throws Exception{
        FileInputStream inputStream=new FileInputStream(file);
        StringBuilder builder=new StringBuilder();
        byte[] bytes=new byte[1024];
        int bytesRead;
        while ((bytesRead=inputStream.read(bytes))!=-1){
            builder.append(new String(bytes,0,bytesRead));
        }
        inputStream.close();
        builder.append(salt);
        String md5=md5(builder.toString());
        return hexStringToBytes(md5);
    }

    //16����ת�ֽ�����
    private static   byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 6 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }
    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }
    //md5�����ַ���
    private static String md5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            return "";
        }
    }

    //ͼƬĩβ��md5�ֽ�����
    private static void imgAppendMd5Bytes(File file,byte[] md5Bytes) throws Exception{
        RandomAccessFile accessFile=new RandomAccessFile(file,"rw");
        long length=accessFile.length();
        //��ָ��λ�ÿ�ʼ������ݣ����λ��֮������ݻᱻ����
        accessFile.seek(length);
        accessFile.write(md5Bytes);
        accessFile.close();
    }

    //��ȡ�洢��ͼƬĩβ��16��md5�ֽ�
    private static byte[] popMd5Bytes(File file) throws Exception{
        RandomAccessFile accessFile=new RandomAccessFile(file,"rw");
        byte[] bytes=new byte[16];
        long length=accessFile.length();
        accessFile.seek(length-16);
        for (int i=0;i<16;i++){
            bytes[i]=accessFile.readByte();
        }
        accessFile.close();
        return bytes;
    }

    //ȥ��ͼƬĩβ��16��md5�ֽ�
    private static void imgDelEndMd5Bytes(File file) throws Exception{
        RandomAccessFile accessFile=new RandomAccessFile(file,"rw");
        FileChannel fc = accessFile.getChannel();
        //��ȡ�ļ�ָ����С  ��ʽ
        fc.truncate(accessFile.length()-16);
        fc.close();
        accessFile.close();
    }

    //��ֹͼƬ���۸�
    public static void imageAddMd5(File file,String salt) throws Exception{
        byte[] md5bytes=img2Md5Bytes(file,salt);
        imgAppendMd5Bytes(file,md5bytes);
    }

    //��֤ͼƬ�Ƿ񱻴۸�
    public static boolean verifyImage(File file,String salt) throws Exception{
        byte[] storageMd5=popMd5Bytes(file);//��ȡ�洢��ͼƬĩβ��16��md5�ֽ�
        imgDelEndMd5Bytes(file);//ɾ��ĩβmd5�ֽ�����
        byte[] imgMd5=img2Md5Bytes(file,salt);
        return Arrays.equals(storageMd5,imgMd5);
    }

    public static void main(String[] args) throws Exception {
        File file=new File("E:\\222222.jpg");
        String salt="123456";
        //ͼƬ��MD5��
        imageAddMd5(file,salt);
        //ͼƬ��֤����ԭ
        boolean verifyImage = verifyImage(file, salt);
        System.out.println(verifyImage);
    }
}
