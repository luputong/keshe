package mavenkeshe.demo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import mavenkeshe.demo.mapper.ShopcarMapper;
import mavenkeshe.demo.pojo.Goods_shopcar;
import mavenkeshe.demo.pojo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopcarService implements mavenkeshe.demo.service.ShopcarService {
    @Autowired
    private ShopcarMapper shopcarMapper;

    @Override
    public Integer add(Goods_shopcar goods_shopcar) {
           //找数据库中userid和goodid是否相同
        Goods_shopcar a = shopcarMapper.getByUserIdAndGoodId(goods_shopcar);
        //相同，amount+=amount
        if(a!=null){
            a.setAmount(goods_shopcar.getAmount()+a.getAmount());
            shopcarMapper.update(a);
            return a.getId();
        }else {
            shopcarMapper.add(goods_shopcar);
             return shopcarMapper.getByUserIdAndGoodId(goods_shopcar).getId();
        }
    }

    @Override
    public void delete(List<Integer> ids) {
        shopcarMapper.delete(ids);
    }

    @Override
    public void update(Goods_shopcar goods_shopcar) {
        shopcarMapper.update(goods_shopcar);
    }

    @Override
    public PageBean page(Integer page, Integer pagesize,
                         Integer userId, Integer goodId, Integer amount) {
        PageHelper.startPage(page,pagesize);
        List<Goods_shopcar> goods_shopcars=shopcarMapper.page(userId,goodId,amount);
        Page<Goods_shopcar> page1=(Page<Goods_shopcar>)goods_shopcars;
        PageBean pageBean=new PageBean(page1.getTotal(),page1.getResult());
        return  pageBean;
    }

    @Override
    public Goods_shopcar getById(Integer id) {
        return  shopcarMapper.getById(id);
    }
}
