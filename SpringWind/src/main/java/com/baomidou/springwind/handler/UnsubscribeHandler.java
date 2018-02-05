package com.baomidou.springwind.handler;

import java.util.Map;

import com.baomidou.springwind.entity.WechatUser;
import com.baomidou.springwind.service.impl.LocalUserServiceImpl;
import com.baomidou.springwind.service.impl.WeixinService;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

/**
 * 
 * @author Binary Wang
 *
 */
@Component
public class UnsubscribeHandler extends AbstractHandler {

    @Autowired
    private LocalUserServiceImpl localUserService;

    @Autowired
    private WeixinService wxUserService;

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
            Map<String, Object> context, WxMpService wxMpService,
            WxSessionManager sessionManager) throws WxErrorException {
        String openId = wxMessage.getFromUser();
        this.logger.info("取消关注用户 OPENID: " + openId);
        // TODO 可以更新本地数据库为取消关注状态
        WxMpUser wxMpUser = wxUserService.getUserService().userInfo(openId);
        WechatUser user = new WechatUser().cast(wxMpUser);
        user.setIsDel(1);
        localUserService.updateById(user);
        return null;
    }
}
