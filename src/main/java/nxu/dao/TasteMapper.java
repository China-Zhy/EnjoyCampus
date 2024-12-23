package nxu.dao;

import nxu.entity.Taste;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 张宏业
 * @apiNote 餐品口味持久层接口
 */
public interface TasteMapper {

    /**
     * 添加口味
     *
     * @param name 口味名称
     * @return 添加结果
     */
    int insertTaste(@Param("name") String name);

    /**
     * 删除口味
     *
     * @param id 口味名称
     * @return 删除结果
     */
    int deleteTaste(@Param("id") int id);

    /**
     * 修改口味
     *
     * @param id   口味编号
     * @param name 新口味名称
     * @return 修改结果
     */
    int updateTaste(@Param("id") int id, @Param("name") String name);

    /**
     * 查询全部口味
     *
     * @return 口味实体集合
     */
    List<Taste> selectAllTaste();
}