package com.kuark.tool.advance.advance20201105util;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author rock
 * @detail ����ļ�ѹ����һ��ѹ���ļ�
 * @date 2021/10/18 18:21
 */
public class FileZipUtil {
    public static void main(String[] args) throws IOException {
        File[] sourceFile=new File[]{new File("E:\\source\\auth.txt"),new File("E:\\source\\aaaa.md"),new File("E:\\source\\bbbb.txt")};
        File zipFile=new File("E:\\source\\zipTest.zip");
        zipFiles(sourceFile,zipFile);
    }

    /**
     * ���ظ���ȡ����
     * @throws IOException
     */
    public static void mulStream() throws IOException {
        File[] sourceFile=new File[]{new File("E:\\source\\auth.txt"),new File("E:\\source\\aaaa.md"),new File("E:\\source\\bbbb.txt")};
        //        FileInputStream inputStream=new FileInputStream(sourceFile[0]);
//        int len=0;
//        byte[] buffer=new byte[1024];
//        while ((len=inputStream.read(buffer))>0){
//            System.out.println(new String(buffer));
//        }

        //���������ظ���ȡ
//        int len2=0;
//        byte[] buffer2=new byte[1024];
//        while ((len2=inputStream.read(buffer2))>0){
//            System.out.println("-----------------");
//            System.out.println(new String(buffer2));
//        }

        //��ο����ظ���ȡ
        FileInputStream inputStream2=new FileInputStream(sourceFile[0]);
        //ע�⣺��������С�������Ƶģ����ļ������ظ�ʹ�þ��п���ʹ�ò��ˣ���Ϊ�ļ��Ĵ�С���Ѿ�����mark�ķ�Χ����ִ��reset�ͻ᲻����
        BufferedInputStream bufferedInputStream=new BufferedInputStream(inputStream2);
        bufferedInputStream.mark(bufferedInputStream.available()+1);
        int len2=0;
        byte[] buffer2=new byte[1024];
        while ((len2=bufferedInputStream.read(buffer2))>0){
            System.out.println(new String(buffer2));
        }

        System.out.println("=============================");
        bufferedInputStream.reset();
        while ((len2=bufferedInputStream.read(buffer2))>0){
            System.out.println(new String(buffer2));
        }
    }

    /**
     * ����ļ���ѹ����һ��ѹ���ļ�
     * @param sourceFiles
     * @param zipFile
     * @throws IOException
     */
    public static void zipFiles(File[] sourceFiles,File zipFile) throws IOException {
        FileOutputStream outputStream=new FileOutputStream(zipFile);
        ZipOutputStream zipOutputStream=new ZipOutputStream(outputStream);
        ZipEntry zipEntry=null;
        for(int i=0;i<sourceFiles.length;i++){
            FileInputStream inputStream=new FileInputStream(sourceFiles[i]);
            zipEntry=new ZipEntry(sourceFiles[i].getName());
            zipOutputStream.putNextEntry(zipEntry);
            int len=0;
            byte[] buffer=new byte[1024];
            while ((len=inputStream.read(buffer))>0){
                zipOutputStream.write(buffer,0,len);
            }
            inputStream.close();
        }
        zipOutputStream.closeEntry();
        zipOutputStream.close();
        outputStream.close();
    }
}
