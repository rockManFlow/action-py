package com.kuark.tool.advance.advance20201111;

import lombok.Getter;

/**
 * @author rock
 * @detail
 * @date 2021/8/5 17:13
 */
@Getter
public enum TestEnum {
    NO_TYPE(0,"��Ȩ��"),
    OPEN_OWEALTH(1,"��ͨowealth�˻�"),
    OPEN_AUTO_INVEST(2,"�����Զ�Ͷ��"),
    ADD_HOLDER_CARD_USER(3,"��ͨ��������ϢȨ��"),
    SEND_COUPON(4,"������������Ϣ��"),
    USE_COUPON(5,"������������Ϣ��"),;
    private Integer code;
    private String desc;

    TestEnum(Integer code, String desc){
        this.code=code;
        this.desc=desc;
    }
}
