package nxu.service;

import nxu.entity.Taste;

import java.util.List;

/**
 * @author 张宏业
 * @apiNote 餐品口味服务层接口
 */
public interface TasteService {

    /**
     * 添加口味
     *
     * @param name 口味名称
     * @return 添加结果
     */
    int insertTaste(String name);

    /**
     * 删除口味
     *
     * @param id 口味名称
     * @return 删除结果
     */
    int deleteTaste(int id);

    /**
     * 修改口味
     *
     * @param id   口味编号
     * @param name 新口味名称
     * @return 修改结果
     */
    int updateTaste(int id, String name);

    /**
     * 查询全部口味
     *
     * @return 口味实体集合
     */
    List<Taste> selectAllTaste();
}