package springboot.springbootlearn2021.service.Impl;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import springboot.springbootlearn2021.mapper.UserMapper;
import springboot.springbootlearn2021.security.SecurityUser;
import springboot.springbootlearn2021.service.UserService;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Object login(String username, String password) {
        // 用户验证
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        // 存储认证信息
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        // 生成SecurityUser
        SecurityUser securityUser = (SecurityUser) authenticate.getPrincipal();
        return JSON.toJSON(securityUser);
    }

    @Override
    public int register(String username, String password, String authority) {
        log.info("当前正在注册用户 username::" + username + " password::" + password + " authority::" + authority);
        password = bCryptPasswordEncoder.encode(password);
        return userMapper.register(username, password, authority);
    }
}
