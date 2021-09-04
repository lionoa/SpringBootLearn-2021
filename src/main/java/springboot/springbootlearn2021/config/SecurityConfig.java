package springboot.springbootlearn2021.config;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import springboot.springbootlearn2021.comment.Result;
import springboot.springbootlearn2021.service.UserDetailsService;

import java.io.PrintWriter;

@Configuration
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    // 配置安全机制
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                .antMatchers("/user/**").hasAuthority("USER")
                .antMatchers("/**").permitAll()
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated();

        // 未认证异常
        http.exceptionHandling().authenticationEntryPoint((request, response, e) -> {
            response.setHeader("Content-Type", "application/text;charset=utf-8");
            log.info("未认证异常: " + e.getMessage());
            PrintWriter writer = response.getWriter();
            writer.println(JSON.toJSON(Result.error("用户名或密码错误", e.getMessage())));
            writer.flush();
            writer.close();
        });

        // 关闭 跨域请求伪造
        http.csrf().disable();
    }

    // 权限继承
    @Bean
    public RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        roleHierarchy.setHierarchy("ADMIN > USER");
        return roleHierarchy;
    }

    // 密码编码器
    @Bean
    protected BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 用户信息管理
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}