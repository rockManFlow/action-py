package com.kuark.tool.advance.advance20190907.vo;

import java.io.*;

/**
 * @author rock
 * @detail ʵ��Serializable�ӿ�+���writeObject()��readObject()������(��+�����л�)
 * @date 2019/9/26 11:37
 */
public class SerDemo implements Serializable {
    public transient int age = 23;
    public String name ;
    public SerDemo(){
        System.out.println("Ĭ�Ϲ�����������");
    }
    public SerDemo(String name) {
        this.name = name;
    }
    private  void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeInt(age);
    }
    private void readObject(ObjectInputStream stream) throws ClassNotFoundException, IOException {
        stream.defaultReadObject();
        age = stream.readInt();
    }

    public String toString() {
        return "����" + age + "  " + name;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerDemo stu = new SerDemo("Ming");
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bout);
        out.writeObject(stu);
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
        SerDemo stu1 = (SerDemo) in.readObject();
        System.out.println(stu1);
    }
}
