package org.saber.bloghome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by saber on 2019/5/2.
 */

@Controller
@RefreshScope
public class HiController {

    @Value("${user.config}")
    String abc;

    @Autowired
    HiService hiService;

    @GetMapping("/configTest")
    @ResponseBody
    public String configRefresh() {
        return "配置测试：" + abc;
    }

    @GetMapping("/test2")
    @ResponseBody
    public String test2() {
        return hiService.hystrix();
    }


}
