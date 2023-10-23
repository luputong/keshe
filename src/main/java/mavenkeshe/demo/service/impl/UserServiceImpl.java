package mavenkeshe.demo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import mavenkeshe.demo.mapper.UserMapper;
import mavenkeshe.demo.pojo.Admin;
import mavenkeshe.demo.pojo.PageBean;
import mavenkeshe.demo.pojo.User;
import mavenkeshe.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public PageBean page(Integer page, Integer pagesize, String username,
                         String name, Integer gender, Integer savings,
                         LocalDate beginTime, LocalDate endTime) {
//        Page<User> page1 = PageHelper.startPage(page, pagesize).doSelectPage(()
//                -> userMapper.page(username, name, gender, savings, beginTime, endTime));
//        PageBean pageBean = new PageBean(page1.getTotal(), page1.getResult());
//        return pageBean;
        //1. 设置分页参数
        PageHelper.startPage(page,pagesize);

        //2. 执行查询
        List<User> userList = userMapper.page(username, name, gender, savings, beginTime, endTime);
        Page<User> p = (Page<User>) userList;

        //3. 封装PageBean对象
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    @Override
    public void delete(List<Integer> ids) {
        userMapper.delete(ids);
    }

    @Override
    public List<User> select(Integer id) {

        return userMapper.list(id);
    }

    @Override
    public void update(User user) {
        user.setUpdateTime(LocalDateTime.now());
        userMapper.update(user);
    }

    @Override
    public User login(User user) {
        return userMapper.getByUsernameAndPassword(user);
    }

    @Override
    public void zhuce(User user) {
        user.setLoginTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userMapper.zhuce(user);
    }

    @Override
    public Admin mangerLogin(Admin admin) {
        return userMapper.getByNameAndPassword(admin);
    }
}
