package mavenkeshe.demo.mapper;

import mavenkeshe.demo.pojo.Goods;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodsMapper {
    @Select("select * from goods")
    List<Goods> page(Integer number, String goodName, String kindName, Integer stock);
    @Select("select * from goods where id=#{id}")
    List<Goods> list(Integer id);

    void delete(List<Integer> ids);
    @Insert("insert  into goods(goodname, kind_type, price, stock) "+
    "values (#{goodName},#{kindType},#{price},#{stock})")
    void add(Goods goods);
}
