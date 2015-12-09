package io.pivotal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class HelloController {

    @Value("${greeting}")
    String greeting;

    @RequestMapping("/hello")
    public String sayHello(@RequestParam(value="name", defaultValue="World") String toWho) {
        String result = String.format(greeting, toWho);
        System.out.println(result);
        return result;
    }
}