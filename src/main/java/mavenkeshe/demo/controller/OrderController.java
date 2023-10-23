package mavenkeshe.demo.controller;

import lombok.extern.slf4j.Slf4j;
import mavenkeshe.demo.pojo.Order;
import mavenkeshe.demo.pojo.PageBean;
import mavenkeshe.demo.pojo.Result;
import mavenkeshe.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public Result add(@RequestBody Order order) {
        orderService.add(order);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Order order = orderService.getById(id);
        return Result.success(order);
    }

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pagesize,
                       Integer userId, Integer goodId, Integer amount,
                       double totalPrice, double goodPrice) {
        PageBean pageBean=orderService.page(page,pagesize,userId,goodId,amount,totalPrice,goodPrice);
        return Result.success(pageBean);
    }
}
