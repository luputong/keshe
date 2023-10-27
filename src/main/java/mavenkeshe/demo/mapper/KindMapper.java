package mavenkeshe.demo.mapper;

import mavenkeshe.demo.pojo.Kind;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface KindMapper {
    @Insert("insert  into  kind(type) values(#{type})")
    public void add(Kind kind) ;
    @Update("update kind  set type=#{type}")
    void update(Kind kind);
    @Select("select * from kind where  id=#{id}")
    Kind list(Integer id);
    @Select("select * from kind  ")
    List<Kind> page(Integer id, String type);
}
