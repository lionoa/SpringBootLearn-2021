package springboot.springbootlearn2021.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import springboot.springbootlearn2021.entity.User;

@Mapper
public interface UserMapper {
    @Select("select username, password, authority from user where username = #{username}")
    User getUserByName(String username);

    @Select("select * from user where username = #{username} and password = #{password}")
    User login(String username, String password);

    @Insert("insert into user (username, password, authority) values (#{username},#{password},#{authority})")
    int register(String username, String password, String authority);
}
