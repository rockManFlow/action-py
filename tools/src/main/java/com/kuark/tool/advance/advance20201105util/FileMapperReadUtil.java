package com.kuark.tool.advance.advance20201105util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author rock
 * @detail
 * �ڴ�ӳ���ļ�����ȡ����ļ�����Ҫע�⣺�ڴ�ӳ������ӳ����ļ����Ȳ��ܳ���java��int���͵����ֵ������ֻ�ܴ���2GB���µ��ļ�
 * MappedByteBuffer��ȷ�죬��Ҳ����һЩ���⣬��Ҫ�����ڴ�ռ�ú��ļ��رյȲ�ȷ�����⡣
 * ��MappedByteBuffer�򿪵��ļ�ֻ���������ռ�ʱ�Żᱻ�رգ���������ǲ�ȷ����
 *
 * ���ȡ����ʱ15s
 * ��ȡ֮��ʹ��ͨ����д����124s������ͨ���ڴ�ӳ�仹�Ǻܿ�
 * @date 2020/10/13 17:49
 */
public class FileMapperReadUtil {
    //һ��20M��С
    private static final Integer SIZE=20*1024*1024;
    private MappedByteBuffer[] mappedBufArrayIn;
    private int number;
    private FileInputStream fileIn;
    private FileOutputStream outputStream=null;
    private long fileLength;
    private byte[] array;

    public FileMapperReadUtil(String inFileUrl,String outFileUrl) throws IOException {
        this.outputStream = new FileOutputStream(outFileUrl);
        this.fileIn = new FileInputStream(inFileUrl);
        FileChannel fileChannel = fileIn.getChannel();

        this.fileLength = fileChannel.size();
        this.number = (int) Math.ceil((double) fileLength / (double) Integer.MAX_VALUE);
        this.mappedBufArrayIn = new MappedByteBuffer[number];// �ڴ��ļ�ӳ������
        long preLength = 0;//��ʼλ��
        long regionSize = (long) Integer.MAX_VALUE;// ӳ������Ĵ�С
        for (int i = 0; i < number; i++) {// ���ļ�����������ӳ�䵽�ڴ��ļ�ӳ��������
            if (fileLength - preLength < (long) Integer.MAX_VALUE) {
                regionSize = fileLength - preLength;// ���һƬ����Ĵ�С
            }
            mappedBufArrayIn[i] = fileChannel.map(FileChannel.MapMode.READ_ONLY, preLength, regionSize);
            preLength += regionSize;// ��һƬ����Ŀ�ʼ
        }
    }

    public void readFile() throws IOException {
        int count = 0;

        int size=0;
        while (size!=-1){
            if (count >= number) {
                size=-1;
                continue;
            }
            int limit = mappedBufArrayIn[count].limit();
            int position = mappedBufArrayIn[count].position();
            if (limit - position > SIZE) {
                array = new byte[SIZE];
                mappedBufArrayIn[count].get(array);
//                writeFile(mappedBufArrayIn[count].get(array));
                size=SIZE;
            } else {// ���ڴ��ļ�ӳ�����һ�ζ�ȡ����
                array = new byte[limit - position];
                mappedBufArrayIn[count].get(array);
//                writeFile(mappedBufArrayIn[count].get(array));
                if (count < number) {
                    count++;// ת������һ���ڴ��ļ�ӳ��
                }
                size=limit - position;
            }
        }

    }

    public void writeFile(ByteBuffer byteBuf) throws IOException {
        FileChannel outputStreamChannel = outputStream.getChannel();
        outputStreamChannel.write(byteBuf);
    }

    public void close() throws IOException {
        if(fileIn!=null){
            fileIn.close();
        }
        if(outputStream!=null){
            outputStream.getChannel().close();
            outputStream.flush();
            outputStream.close();
        }
        array = null;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("start main");
        long start=System.currentTimeMillis();
        FileMapperReadUtil fileMoreReadUtil =new FileMapperReadUtil("E:\\test\\CentOS-6.5-x86_64-bin-DVD1.iso","E:\\test\\channel555.iso");
        fileMoreReadUtil.readFile();
        fileMoreReadUtil.close();
        System.out.println("end main cost:"+(System.currentTimeMillis()-start)/1000+"s");
    }
}
