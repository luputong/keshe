package mavenkeshe.demo.service;

import mavenkeshe.demo.pojo.Admin;
import mavenkeshe.demo.pojo.PageBean;
import mavenkeshe.demo.pojo.User;

import java.time.LocalDate;
import java.util.List;

public interface UserService {

    PageBean page(Integer page, Integer pagesize, String username, String name, Integer gender, Integer savings, LocalDate beginTime, LocalDate endTime);


    void delete(List<Integer> ids);

    List<User> select(Integer id);

    void update(User user);

    User login(User user);

    void zhuce(User user);

    Admin mangerLogin(Admin admin);
}
