package nxu.service.impl;

import nxu.dao.TasteMapper;
import nxu.entity.Taste;
import nxu.service.TasteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张宏业
 * @apiNote 餐品口味服务层实现类
 */
@Service
public class TasteServiceImpl implements TasteService {

    @Autowired
    private TasteMapper tasteMapper;

    /**
     * 添加口味
     *
     * @param name 口味名称
     * @return 添加结果
     */
    @Override
    public int insertTaste(String name) {
        return tasteMapper.insertTaste(name);
    }

    /**
     * 删除口味
     *
     * @param id 口味名称
     * @return 删除结果
     */
    @Override
    public int deleteTaste(int id) {
        return tasteMapper.deleteTaste(id);
    }

    /**
     * 修改口味
     *
     * @param id   口味编号
     * @param name 新口味名称
     * @return 修改结果
     */
    @Override
    public int updateTaste(int id, String name) {
        return tasteMapper.updateTaste(id, name);
    }

    /**
     * 查询全部口味
     *
     * @return 口味实体集合
     */
    @Override
    public List<Taste> selectAllTaste() {
        return tasteMapper.selectAllTaste();
    }
}