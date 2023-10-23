package mavenkeshe.demo.service;

import mavenkeshe.demo.pojo.Goods_shopcar;
import mavenkeshe.demo.pojo.PageBean;

import java.util.List;

public interface ShopcarService {
    Integer add(Goods_shopcar goods_shopcar);

    void delete(List<Integer> ids);

    void update(Goods_shopcar goods_shopcar);

    PageBean page(Integer page, Integer pagesize, Integer userId, Integer goodId, Integer amount);

    Goods_shopcar getById(Integer id);
}
