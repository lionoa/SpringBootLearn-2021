package springboot.springbootlearn2021.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.springbootlearn2021.comment.Result;
import springboot.springbootlearn2021.service.UserService;

import javax.websocket.server.PathParam;

@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/doLogin")
    public Object login(@PathParam("username") String username, @PathParam("password") String password) {
        log.info(username + "::" + password);
        Object login = userService.login(username, password);
        return Result.ok(login);
    }

    @PostMapping("/register")
    public Result<String> register(@PathParam("username") String username, @PathParam("password") String password) throws Exception {
        log.info("当前正在注册用户：" + username + " " + password);
        password = bCryptPasswordEncoder.encode(password);
        int result = userService.register(username, password, "USER");
        return Result.ok("注册成功", result);
    }
}
