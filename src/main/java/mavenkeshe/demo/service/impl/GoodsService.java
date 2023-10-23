package mavenkeshe.demo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import mavenkeshe.demo.mapper.GoodsMapper;
import mavenkeshe.demo.pojo.Goods;
import mavenkeshe.demo.pojo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsService implements mavenkeshe.demo.service.GoodsService {
@Autowired
private GoodsMapper goodsMapper;
    @Override
    public PageBean page(Integer page, Integer pagesize, Integer number
            , String goodName, String kindName, Integer stock) {
        PageHelper.startPage(page,pagesize);
        List<Goods> goodsList=goodsMapper.page(number,goodName,kindName,stock);
        Page<Goods> page1=(Page<Goods>)goodsList;
        PageBean pageBean=new PageBean(page1.getTotal(),page1.getResult());
        return pageBean;
    }

    @Override
    public List<Goods> list(Integer id) {

        return goodsMapper.list(id);
    }

    @Override
    public void delete(List<Integer> ids) {
        goodsMapper.delete(ids);
    }

    @Override
    public void add(Goods goods) {
        goodsMapper.add(goods);
    }
}
