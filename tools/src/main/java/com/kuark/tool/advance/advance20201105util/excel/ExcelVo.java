package com.kuark.tool.advance.advance20201105util.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author rock
 * @detail
 * @date 2021/10/13 14:57
 */
@Data
public class ExcelVo {
    @ExcelProperty("��ˮ��")
    private String orderNo;

    @ExcelProperty("�һ�ID")
    private String referId;

    @ExcelProperty("�һ�����")
    private String referName;

    @ExcelProperty("�һ���Ʒ����")
    private String referType;

    @ExcelProperty("userId")
    private String userId;

    @ExcelProperty("OPay account")
    private String userPhone;
}
