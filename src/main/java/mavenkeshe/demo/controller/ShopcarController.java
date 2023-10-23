package mavenkeshe.demo.controller;

import lombok.extern.slf4j.Slf4j;
import mavenkeshe.demo.pojo.Goods_shopcar;
import mavenkeshe.demo.pojo.Order;
import mavenkeshe.demo.pojo.PageBean;
import mavenkeshe.demo.pojo.Result;
import mavenkeshe.demo.service.ShopcarService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/cart")
public class ShopcarController {
    @Autowired
    private ShopcarService shopcarService;

    @PostMapping
    public Result add(@RequestBody Goods_shopcar goods_shopcar) {
        Integer id = shopcarService.add(goods_shopcar);
        return Result.success(id);
    }
    @DeleteMapping("/{ids}")
    public  Result delete(@PathVariable List<Integer> ids){
        shopcarService.delete(ids);
     return  Result.success();
    }
    @PutMapping
    public Result update(@RequestBody Goods_shopcar goods_shopcar){
        shopcarService.update(goods_shopcar);
         return  Result.success();
    }
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1")Integer page,
                       @RequestParam(defaultValue = "10")Integer pagesize,
                       Integer userId,Integer goodId,Integer amount){
        PageBean pageBean=shopcarService.page(page,pagesize,userId,goodId,amount);
       return  Result.success(pageBean);
    }
    @GetMapping("/{id}")
    public  Result getById(@PathVariable Integer id){
        Goods_shopcar goods_shopcar=shopcarService.getById(id);
        return Result.success(goods_shopcar);
    }
}
