package mavenkeshe.demo.service;

import mavenkeshe.demo.pojo.Goods;
import mavenkeshe.demo.pojo.PageBean;

import java.util.List;

public interface GoodsService {
    PageBean page(Integer page, Integer pagesize, Integer number, String goodName, String kindName, Integer stock);

    List<Goods> list(Integer id);

    void delete(List<Integer> ids);

    void add(Goods goods);
}
