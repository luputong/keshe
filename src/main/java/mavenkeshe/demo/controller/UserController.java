package mavenkeshe.demo.controller;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import mavenkeshe.demo.pojo.PageBean;
import mavenkeshe.demo.pojo.Result;
import mavenkeshe.demo.pojo.User;
import mavenkeshe.demo.service.UserService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
public Result list(@RequestParam(defaultValue = "1") Integer page,
                   @RequestParam(defaultValue="10") Integer pagesize, String username, String name,
                   Integer gender, Integer savings,
                   @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate beginTime,
                   @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endTime){
        PageBean pageBean=userService.page(page,pagesize,username,name,gender,savings,beginTime,endTime);
        return Result.success(pageBean);
    }
    @DeleteMapping("/{ids}")
    public  Result delete(@PathVariable List<Integer> ids){
        userService.delete(ids);
       return   Result.success();
    }
    @GetMapping("/{id}")
    public Result select(@PathVariable Integer id ){
          List<User> user=  userService.select(id);
        return  Result.success(user);
    }
    @PutMapping
    public  Result update(@RequestBody User user){
       userService.update(user);
        return  Result.success();
    }
}
