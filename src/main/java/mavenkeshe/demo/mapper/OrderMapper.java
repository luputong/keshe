package mavenkeshe.demo.mapper;

import mavenkeshe.demo.pojo.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {
    @Insert("insert  into  `order`(user_id, good_id,amount, totalprice, good_price) values " +
            "(#{userId},#{goodId},#{amount},#{totalPrice},#{goodPrice})")
    void add(Order order);
    @Select("select * from `order` where id=#{id}")
    Order getById(Integer id);
    @Select("select  *  from `order`")
    List<Order> page(Integer userId, Integer goodId, Integer amount, double totalPrice, double goodPrice);

}
