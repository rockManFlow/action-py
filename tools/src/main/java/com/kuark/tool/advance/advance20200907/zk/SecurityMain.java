package com.kuark.tool.advance.advance20200907.zk;

import sun.misc.BASE64Encoder;

import javax.crypto.*;
import java.security.*;

/**
 * @author rock
 * @detail
 * @date 2020/10/27 14:13
 */
public class SecurityMain {
    public static void main(String[] args) throws NoSuchProviderException, NoSuchAlgorithmException
            , NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        for(Provider p : Security.getProviders()){
            System.out.println(p.getName()+"=="+p.getInfo());
        }

        //��Կ������
        KeyGenerator kg = KeyGenerator.getInstance("DES","SunJCE");
        //�����Կ����
        SecretKey secretKey = kg.generateKey();

        /**
         * ����ʵ�ֶ����ݼӽ��ܹ��ܵ�����Cipher������Ϊ���ܺͽ����ṩ���빦�ܣ��������� Java Cryptographic Extension (JCE) ��ܵĺ���
         * s:������Ϊ����ĳ��������ڸ�����������ִ�еĲ�������һ�������,���㷨/ģʽ/��䡱���㷨�������������ʹ��ģʽ����䷽���ض���Provider��Ĭ��ֵ��
         */
        //DES�����㷨��CBC�ķ���ģʽ��PKCS5Padding����䷽��
        Cipher c = Cipher.getInstance("DES/CBC/PKCS5Padding","SunJCE");

        /**
         * Cipher��init���������ʼ������ʼ����Ҫָ��ģʽ����Կ����Կ���Ĳ��������Ѿ����ɵ�key��
         * ģʽ������ENCRYPT_MODE��DECRYPT_MODE��WRAP_MODE��UNWRAP_MODE�ֱ��ʾ���ܡ����ܡ���Կ��װ����Կ�����
         * �����������÷���init(Cipher.ENCRYPT_MODE, key)��
         * �����������÷���init(Cipher.DECRYPT_MODE, key)��
         * WRAP_MODE��UNWRAP_MODEģʽ������ʵ�������ŷ��õģ����Ĳ������ܡ�
         * ͨ�������ݽ��мӽ��ܣ�ʹ�÷���doFinal(byte[] input)�����������byte���顣
         * Ϊ����httpЭ���¿��ٴ������ݣ���ĳЩϵͳ��ֻ��ʹ��ASCII�ַ���ͨ������Base64���롣Base64������������ASCII�ַ�������ת����ASCII�ַ���һ�ַ�������������߿����ԡ�
         */
        //ָ��ģʽ����Կ
        c.init(Cipher.ENCRYPT_MODE,secretKey);

        //�ӽ��ܲ�������
        byte[] bytes = c.doFinal("xxxxx".getBytes());

        //���ڴ���base64
        String targetString = new BASE64Encoder().encode(bytes);

        System.out.println("�������֮���base64���Ĵ���"+targetString);

    }
}
