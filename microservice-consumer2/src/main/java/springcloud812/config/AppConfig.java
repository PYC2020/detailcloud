package springcloud812.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//一个配置类:由spring托管
@SpringBootConfiguration
public class AppConfig {
    @Bean //创建一个 restTemplate 的模板操作对象

    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}