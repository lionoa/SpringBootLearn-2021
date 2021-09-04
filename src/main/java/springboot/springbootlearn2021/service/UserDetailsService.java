package springboot.springbootlearn2021.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import springboot.springbootlearn2021.entity.User;
import springboot.springbootlearn2021.mapper.UserMapper;
import springboot.springbootlearn2021.security.SecurityUser;

import java.util.Collection;

@Service
@Slf4j
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userMapper.getUserByName(s);
        if (user == null) {
            log.info("username " + s + " 不存在");
            throw new UsernameNotFoundException("用户名不存在");
        }
        log.info("当前用户：" + user.getUsername() + " " + user.getPassword() + " " + user.getAuthority());
        Collection<? extends GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(user.getAuthority());
        return new SecurityUser(user.getUsername(), user.getPassword(), authorities);
    }
}
