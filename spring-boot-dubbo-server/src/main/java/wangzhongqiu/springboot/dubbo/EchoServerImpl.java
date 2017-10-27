package wangzhongqiu.springboot.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import wangzhongqiu.springboot.service.api.EchoService;

/**
 * @author xiaofei.wxf(teaey)
 * @since 0.0.0
 */
@Service(version = "1.0.0")
public class EchoServerImpl implements EchoService {

    @Override
    public String echo(String str) {
        System.out.println(str);
        return str;
    }
}
