package wangzhongqiu.springboot.sample.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wangzhongqiu.springboot.sample.config.ConfigBean;

import javax.annotation.Resource;
/**
 * @author wangzhongqiu
 * @date 2017/10/19
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private ConfigBean configBean;

    @Value("${config.welcome}")
    private String welcome;

    @RequestMapping("/hello")
    public String hello() {
        return configBean.getWelcome() + " <br />" + welcome + " <br />" + "随机获得" + configBean.getRandomValue() + "元奖励";
    }
}