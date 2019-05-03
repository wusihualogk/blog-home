package org.saber.bloghome;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by saber on 2019/5/2.
 */
@Service
public class HiService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${blog.api.url}")
    private String blogApiUrl;

    @HystrixCommand(fallbackMethod = "ffff")
    public String hystrix() {
        return restTemplate.getForObject(blogApiUrl + "/apiTest", String.class);
    }

    public String ffff() {
        return "接口调用失败，调用断路器指定方法";
    }
}
