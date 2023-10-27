package mavenkeshe.demo.controller;

import com.aliyun.oss.common.comm.ServiceClient;
import com.github.pagehelper.Page;
import lombok.extern.slf4j.Slf4j;
import mavenkeshe.demo.pojo.Kind;
import mavenkeshe.demo.pojo.PageBean;
import mavenkeshe.demo.pojo.Result;
import mavenkeshe.demo.service.impl.KindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/kind")

public class KindController {
    @Autowired
    private KindService kindService;

    @PostMapping
    public Result add(@RequestBody Kind kind) {
        kindService.add(kind);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody Kind kind) {
        kindService.update(kind);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result list(@PathVariable Integer id) {
        Kind kind = kindService.list(id);
        return Result.success(kind);
    }

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer Page,
                       @RequestParam(defaultValue = "10") Integer pagesize,
                       Integer id,String type) {
        PageBean pageBean=kindService.page(Page,pagesize,id,type);
        return Result.success(pageBean);
    }
}
