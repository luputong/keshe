package mavenkeshe.demo.mapper;

import mavenkeshe.demo.pojo.Admin;
import mavenkeshe.demo.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<User> page(String username, String name, Integer gender, Integer savings,
                    LocalDate beginTime, LocalDate endTime);

    void delete(List<Integer> ids);

    @Select("select * from  user where id=#{id}")
    List<User> list(Integer id);

    void update(User user);

    @Select("select * from  user where username=#{username} and password=#{password}")
    User getByUsernameAndPassword(User user);
    @Insert("insert  into user(USERNAME, PASSWORD, NAME, GENDER, phonenumber, LOGIN_TIME, UPDATE_TIME) " +
            "values (#{username},#{password},#{name},#{gender},#{phoneNumber},#{loginTime},#{updateTime})")
    void zhuce(User user);
    @Select("select * from  admin where name=#{name} and password=#{password}")
    Admin getByNameAndPassword(Admin admin);
}


