package mavenkeshe.demo.controller;

import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import mavenkeshe.demo.pojo.Admin;
import mavenkeshe.demo.pojo.Result;
import mavenkeshe.demo.pojo.User;
import mavenkeshe.demo.service.UserService;
import mavenkeshe.demo.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        User user1 = userService.login(user);
         if(user1!=null){
             Map<String, Object> claims=new HashMap<>();
             claims.put("id",user1.getId());
             claims.put("name",user1.getName());
             claims.put("username",user1.getUsername());
             String jwt = JwtUtils.generateJwt(claims);
             return  Result.success(jwt);
         }
        return Result.error("用户名或密码错误");
    }
    @PostMapping("/register")
    public Result zhuce(@RequestBody User user){
       userService.zhuce(user);
        return  Result.success();
    }
    @PostMapping("/manger-login")
    public Result mangerLogin(@RequestBody Admin admin){
        Admin admin1 = userService.mangerLogin(admin);
        if(admin1!=null){
            Map<String, Object> claims=new HashMap<>();
            claims.put("id",admin1.getId());
            claims.put("name",admin1.getName());
            String jwt = JwtUtils.generateJwt(claims);
            return  Result.success(jwt);
        }
        return Result.error("用户名或密码错误");
    }
}
