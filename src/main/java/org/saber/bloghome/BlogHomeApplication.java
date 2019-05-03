package org.saber.bloghome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
//@RefreshScope
public class BlogHomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogHomeApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @Value("${user.config}")
    String abc;

    @Value("${blog.api.url}")
    private String blogApiUrl;

    @GetMapping("/test")
    @ResponseBody

    public String test(String a) {
        String s = restTemplate.getForObject(blogApiUrl + "/apiTest", String.class);
        return "接口调用结果： " + s;
    }




}
