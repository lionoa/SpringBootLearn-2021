package springboot.springbootlearn2021.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.springbootlearn2021.service.UserService;

@RestController
@Slf4j
public class IndexController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String hello() {
        return "hello::index";
    }

    @GetMapping("/user/hello")
    public String user() {
        return "hello::user";
    }

    @GetMapping("/admin/hello")
    public String admin() {
        return "hello::admin";
    }

}
