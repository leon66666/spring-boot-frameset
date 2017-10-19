package wangzhongqiu.springboot.sample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangzhongqiu
 * @date 2017/10/19.
 */
@RestController
@RequestMapping("/log")
public class LogController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/logtest")
    public String logtest() {
        //日志级别从低到高分为TRACE < DEBUG < INFO < WARN < ERROR < FATAL，如果设置为WARN，则低于WARN的信息都不会输出。
        logger.trace("日志输出 trace");
        logger.debug("日志输出 debug");
        logger.info("日志输出 info");
        logger.warn("日志输出 warn");
        logger.error("日志输出 error");
        return "访问成功，日志已经成功打印";
    }
}
