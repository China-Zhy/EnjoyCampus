package nxu.service;

import nxu.entity.Kinds;

import java.util.List;

/**
 * @author 张宏业
 * @apiNote 餐品种类服务层接口
 */
public interface KindsService {

    /**
     * 新增餐品种类
     *
     * @param name  餐品种类名称
     * @param image 餐品种类图片
     * @return 1-插入成功，0-插入失败
     */
    int insertKinds(String name, String image);

    /**
     * 删除餐品种类
     *
     * @param id 餐品种类编号
     * @return 1-删除成功，0-删除失败
     */
    int deleteKinds(int id);

    /**
     * 修改餐品种类
     *
     * @param kinds 餐品种类实体
     * @return 1-修改成功，0-修改失败
     */
    int updateKinds(Kinds kinds);

    /**
     * 查询全部餐品种类
     *
     * @return 餐品实体集合
     */
    List<Kinds> selectAllKinds();
}