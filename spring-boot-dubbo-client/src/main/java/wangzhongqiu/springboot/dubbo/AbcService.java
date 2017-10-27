package wangzhongqiu.springboot.dubbo;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;
import wangzhongqiu.springboot.service.api.EchoService;

/**
 * @author xiaofei.wxf(teaey)
 * @since 0.0.0
 */
@Component
public class AbcService {
    @Reference(version = "1.0.0")
    public EchoService echoService;
}
