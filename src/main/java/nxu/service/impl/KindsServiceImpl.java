package nxu.service.impl;

import nxu.dao.KindsMapper;
import nxu.entity.Kinds;
import nxu.service.KindsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张宏业
 * @apiNote 餐品种类服务层实现类
 */
@Service
public class KindsServiceImpl implements KindsService {

    @Autowired
    private KindsMapper kindsMapper;


    /**
     * 新增餐品种类
     *
     * @param name  餐品种类名称
     * @param image 餐品种类图片
     * @return 1-插入成功，0-插入失败
     */
    @Override
    public int insertKinds(String name, String image) {
        return kindsMapper.insertKinds(name, image);
    }

    /**
     * 删除餐品种类
     *
     * @param id 餐品种类编号
     * @return 1-删除成功，0-删除失败
     */
    @Override
    public int deleteKinds(int id) {
        return kindsMapper.deleteKinds(id);
    }

    /**
     * 修改餐品种类
     *
     * @param kinds 餐品种类实体
     * @return 1-修改成功，0-修改失败
     */
    @Override
    public int updateKinds(Kinds kinds) {
        return kindsMapper.updateKinds(kinds);
    }

    /**
     * 查询全部餐品种类
     *
     * @return 餐品实体集合
     */
    @Override
    public List<Kinds> selectAllKinds() {
        return kindsMapper.selectAllKinds();
    }
}