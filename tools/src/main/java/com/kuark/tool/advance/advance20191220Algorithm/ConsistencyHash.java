package com.kuark.tool.advance.advance20191220Algorithm;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import org.apache.commons.codec.Charsets;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author rock
 * @detail һ����hashʵ��----�����ڻ���
 * @date 2021/3/10 20:42
 */
public class ConsistencyHash {
    //ÿ��key�ֳɶ��ٸ���Σ�ʹ���ݸ�����
    private static int count = 30;

    private static TreeMap<Long, String> nodeMap = new TreeMap<>();

    public static void main(String[] args) {
        String[] cacheServers = {"192.168.56.101:11211", "192.168.56.102:11211", "192.168.56.103:11211"};
        for (int i = 0; i < cacheServers.length; i++) {
            addNode(cacheServers[i]);
        }

        String n = getNode("judheuhudehsidis");
        String n2 = getNode("judheuhudehsidis");
        String n3 = getNode("12456kijuhgy");
        System.out.println(n);
        System.out.println(n2);
        System.out.println(n3);
    }

    public static long hash(String key) {
        String md5key = DigestUtils.md5Hex(key);
        //��2��64�η���ȡ��
        return Long.parseLong(md5key.substring(0, 15), 16) % ((long) Math.pow(2, 64));
    }

    public static void addNode(String node) {
        for (int i = 0; i < count; i++) {
            long hash = hash(node + i);
            nodeMap.put(hash, node);
        }
    }

    public static String getNode(String key) {
        long hash = hash(key);
        //��ȡ�ȸ�hash���һ��mapֵ
        SortedMap<Long, String> longStringSortedMap =
                nodeMap.tailMap(hash);
        long firstKey = longStringSortedMap.isEmpty() ? nodeMap.firstKey() : longStringSortedMap.firstKey();
        return nodeMap.get(firstKey);
    }

    /**
     * Guava Cache ���֧��һ���Թ�ϣ
     */
    public static void guavaConsitHash() {
        //ʵ�建�������
        String[] cacheServers = {"192.168.56.101:11211", "192.168.56.102:11211", "192.168.56.103:11211"};

        // �������ݵ�key
        String key = "my-test-cache-key";

        // ���㻺�� key ��Ӧ�� hash ֵ������ʹ�� MurmurHash �㷨��MurmurHash ��һ�ָ����ܵ���ײ���㷨�����⣬��֧��  md5��sha1/sha256/sha512��orc32��adler32 �ȹ�ϣ�㷨��
        HashCode hashCode = Hashing.murmur3_32().newHasher().putString(key, Charsets.UTF_8).hash();


        // ͨ��һ���Թ�ϣ��ʽ���㣬����key��Ӧ�ķ�������������һ̨��bucket �ķ�Χ�� 0 ~ cacheServers.length -1
        int bucket = Hashing.consistentHash(hashCode, cacheServers.length);
    }
}
