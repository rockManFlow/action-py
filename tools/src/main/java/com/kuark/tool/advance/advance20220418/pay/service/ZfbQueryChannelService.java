package com.kuark.tool.advance.advance20220418.pay.service;

import com.kuark.tool.advance.advance20220418.pay.AbstractChannelService;
import com.kuark.tool.advance.advance20220418.pay.enums.ChannelServiceEnum;
import com.kuark.tool.advance.advance20220418.pay.model.sub.WxAuthReqModel;
import com.kuark.tool.advance.advance20220418.pay.model.sub.WxAuthRespModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author rock
 * @detail
 * @date 2022/4/18 15:21
 */
@Service
@Slf4j
public class ZfbQueryChannelService extends AbstractChannelService<WxAuthReqModel, WxAuthRespModel> {

    public ZfbQueryChannelService(){
        super(ChannelServiceEnum.ZFB_PAY_QUERY);
    }

    @Override
    public WxAuthRespModel invoke(WxAuthReqModel request) {
        log.info("run invoke:{}",ChannelServiceEnum.ZFB_PAY_QUERY);
        return null;
    }
}
