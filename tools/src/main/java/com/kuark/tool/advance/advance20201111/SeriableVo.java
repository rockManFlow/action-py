package com.kuark.tool.advance.advance20201111;

import lombok.ToString;

import java.io.Serializable;

/**
 * @author rock
 * @detail
 * @date 2021/2/20 11:08
 */
public class SeriableVo implements Serializable {
    private String name;
    private Integer age;

    public String getName() {
        System.out.println("����һ������getName");
        return name;
    }

    public void setName(String name) {
        System.out.println("����һ������setName");
        this.name = name;
    }

    public Integer getAge() {
        System.out.println("����һ������getAge");
        return age;
    }

    public void setAge(Integer age) {
        System.out.println("����һ������setAge");
        this.age = age;
    }

    public SeriableVo(){
        System.out.println("����һ������SeriableVo");
    }


}
