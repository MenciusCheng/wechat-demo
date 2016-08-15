package com.marvel.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marvel.dispatcher.EventDispatcher;
import com.marvel.dispatcher.MsgDispatcher;
import com.marvel.util.MessageUtil;
import com.marvel.util.SignUtil;

@RestController
@RequestMapping("/")
public class Home {

    @RequestMapping(value = "/wechat", method = RequestMethod.GET)
    public String index(HttpServletRequest request) {
        try {
            String signature = request.getParameter("signature");
            String timestamp = request.getParameter("timestamp");
            String nonce = request.getParameter("nonce");
            String echostr = request.getParameter("echostr");
            System.out.println(signature);
            System.out.println(timestamp);
            System.out.println(nonce);
            System.out.println(echostr);
            
            if (SignUtil.checkSignature(signature, timestamp, nonce)) {
                System.out.println("验证成功了哦");
                return echostr;
            } else {
                System.out.println("验证失败了哦");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "主页";
    }

    @RequestMapping(value = "/wechat", method = RequestMethod.POST)
    public String wechat(HttpServletRequest request) {
        try {
            Map<String, String> map = MessageUtil.parseXml(request);
            String msgtype = map.get("MsgType");
            if (MessageUtil.REQ_MESSAGE_TYPE_EVENT.equals(msgtype)) {
                EventDispatcher.processEvent(map); // 进入事件处理
            } else {
                return MsgDispatcher.processMessage(map); // 进入消息处理
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "wechat";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "欢迎";
    }
}
