package mavenkeshe.demo.service;

import mavenkeshe.demo.pojo.Order;
import mavenkeshe.demo.pojo.PageBean;

public interface OrderService {
    void add(Order order);

    Order getById(Integer id);

    PageBean page(Integer page, Integer pagesize, Integer userId, Integer goodId, Integer amount, double totalPrice, double goodPrice);
}
