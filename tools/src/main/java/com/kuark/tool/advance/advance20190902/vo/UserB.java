package com.kuark.tool.advance.advance20190902.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author rock
 * @detail
 * @date 2019/9/2 14:53
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserB {
    private String name;
    private int age;
    private String desc;
    private TypeEnum typeEnum;

    private String nameB;
    private int ageB;

    public String toString(){
        return "name="+this.name+",age="+this.age+",desc="+this.desc+",type="+typeEnum
                +",nameB="+nameB+",ageB="+ageB;
    }
}