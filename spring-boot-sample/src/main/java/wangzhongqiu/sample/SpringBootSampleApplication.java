package wangzhongqiu.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author wangzhongqiu
 * @date 2017/10/19
 */
@RestController
@SpringBootApplication
public class SpringBootSampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootSampleApplication.class, args);
    }
}
