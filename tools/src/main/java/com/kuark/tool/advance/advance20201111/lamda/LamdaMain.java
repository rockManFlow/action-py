package com.kuark.tool.advance.advance20201111.lamda;

/**
 * @author rock
 * @detail �Զ���lamda���ʽѧϰ
 * @date 2021/1/25 15:11
 */
public class LamdaMain {
    public static void main(String[] args) {
        MyRequest req=new MyRequest();
        req.sum(MyEntity::getAge);
        System.out.println(req);
//        Supplier
    }
}
