package springboot.springbootlearn2021.service;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
    String login(String username, String password);
    int register(String username, String password, String authority);
}
