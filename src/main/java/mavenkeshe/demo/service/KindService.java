package mavenkeshe.demo.service;

import mavenkeshe.demo.pojo.Kind;
import mavenkeshe.demo.pojo.PageBean;
import org.springframework.stereotype.Service;

public interface KindService {
    void add(Kind kind);

    void update(Kind kind);

    Kind list(Integer id);

    PageBean page(Integer page, Integer pagesize, Integer id, String type);
}
