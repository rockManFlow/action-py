package com.kuark.tool.base.vo;

public class Person {
    private int id;
    private String name;
    private int age;
    private TestVo testVo;

    public TestVo getTestVo() {
        return testVo;
    }

    public void setTestVo(TestVo testVo) {
        this.testVo = testVo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
