package wangzhongqiu.sample.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wangzhongqiu.sample.constant.ConfigBean;

import javax.annotation.Resource;

@RestController
public class UserController {
    @Resource
    private ConfigBean configBean;

    @Value("${config.welcome}")
    private String welcome;

    @RequestMapping("/")
    public String hello() {
        return configBean.getWelcome() + " <br />" + welcome + " <br />" + "随机获得" + configBean.getRandomValue() + "元奖励";
    }
}