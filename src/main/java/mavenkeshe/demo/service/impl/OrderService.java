package mavenkeshe.demo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import mavenkeshe.demo.mapper.OrderMapper;
import mavenkeshe.demo.pojo.Order;
import mavenkeshe.demo.pojo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements mavenkeshe.demo.service.OrderService {
@Autowired
private OrderMapper orderMapper;
    @Override
    public void add(Order order) {
        orderMapper.add(order);
    }

    @Override
    public Order getById(Integer id) {
        return  orderMapper.getById(id);
    }

    @Override
    public PageBean page(Integer page, Integer pagesize, Integer userId,
                         Integer goodId, Integer amount, double totalPrice, double goodPrice) {
        PageHelper.startPage(page,pagesize);
        List<Order> orders=orderMapper.page(userId,goodId,amount,totalPrice,goodPrice);
        Page<Order> page1=(Page<Order>) orders;
        PageBean pageBean=new PageBean(page1.getTotal(),page1.getResult());
        return pageBean;
    }
}
