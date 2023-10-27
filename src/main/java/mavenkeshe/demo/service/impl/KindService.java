package mavenkeshe.demo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import mavenkeshe.demo.mapper.KindMapper;
import mavenkeshe.demo.pojo.Kind;
import mavenkeshe.demo.pojo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KindService implements KindService {
    @Autowired
    private KindMapper kindMapper;

    @Override
    public void add(Kind kind) {
        kindMapper.add(kind);
    }

    @Override
    public void update(Kind kind) {
        kindMapper.update(kind);
    }

    @Override
    public Kind list(Integer id) {
        return kindMapper.list(id);
    }

    @Override
    public PageBean page(Integer page, Integer pagesize, Integer id, String type) {
        PageHelper.startPage(page, pagesize);
        List<Kind> kinds = kindMapper.page(id, type);
        Page<Kind> page1 = (Page<Kind>) kinds;
        PageBean pageBean = new PageBean(page1.getTotal(), page1.getResult());
        return pageBean;
    }
}
