package mavenkeshe.demo.controller;

import lombok.extern.slf4j.Slf4j;
import mavenkeshe.demo.pojo.Goods;
import mavenkeshe.demo.pojo.PageBean;
import mavenkeshe.demo.pojo.Result;
import mavenkeshe.demo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping
    public Result list(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pagesize,
                       Integer number, String goodName, String kindName, Integer stock) {
        PageBean pageBean = goodsService.page(page, pagesize, number, goodName, kindName, stock);
        return Result.success(pageBean);
    }
    @GetMapping("/{id}")
    public Result list(@PathVariable Integer id){
        List<Goods> goodsList=goodsService.list(id);
        return  Result.success(goodsList);
    }
    @PostMapping("/{ids}")
    public  Result delete(@PathVariable List<Integer> ids){
      goodsService.delete(ids);
        return Result.success();
    }
    @PostMapping
    public  Result add(@RequestBody Goods goods){
       goodsService.add(goods);
        return  Result.success();
    }
}
