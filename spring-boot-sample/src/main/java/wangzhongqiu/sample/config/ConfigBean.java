package wangzhongqiu.sample.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Repository;
/**
 * @author wangzhongqiu
 * @date 2017/10/19
 */
@Repository
@ConfigurationProperties(prefix = "config")
public class ConfigBean {
    private String welcome;
    private String version;
    private Integer randomValue;

    public String getWelcome() {
        return welcome;
    }

    public void setWelcome(String welcome) {
        this.welcome = welcome;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getRandomValue() {
        return randomValue;
    }

    public void setRandomValue(Integer randomValue) {
        this.randomValue = randomValue;
    }
}