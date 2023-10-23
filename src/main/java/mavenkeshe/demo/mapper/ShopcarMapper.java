package mavenkeshe.demo.mapper;

import mavenkeshe.demo.pojo.Goods_shopcar;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShopcarMapper {
    Integer add(Goods_shopcar goods_shopcar);
    void delete(List<Integer> ids);
    @Update("update goods_shopcar set amount=#{amount} where id=#{id} ")
    void update(Goods_shopcar goods_shopcar);
    @Select("select * from goods_shopcar")
    List<Goods_shopcar> page(Integer userId, Integer goodId, Integer amount);
    @Select("select * from goods_shopcar where id=#{id}")
    Goods_shopcar getById(Integer id);
    @Select("select * from goods_shopcar where user_id=#{userId} and goods_id=#{goodId}")
    Goods_shopcar getByUserIdAndGoodId(Goods_shopcar goods_shopcar);

}
