package nxu.dao;

import nxu.entity.Meals;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 张宏业
 * @apiNote 餐品持久层接口
 */
public interface MealsMapper {

    /**
     * 条件查询餐品信息
     *
     * @param map 条件map
     * @return 餐品实体集合
     */
    List<Meals> selectMeals(Map<String, Object> map);

    /**
     * 添加餐品
     *
     * @param meals 餐品实体类
     * @return 添加结果：1-添加成功，0-添加失败
     */
    int insertMeals(Meals meals);

    /**
     * 删除餐品
     *
     * @param id 餐品编号
     * @return 删除结果：1-删除成功，0-删除失败
     */
    int deleteMeals(@Param("id") int id);

    /**
     * 修改餐品
     *
     * @param meals 餐品实体类
     * @return 修改结果：1-修改成功，0-修改失败
     */
    int updateMeals(Meals meals);

    /**
     * 通过编号查询餐品
     *
     * @param id 餐品编号
     * @return 餐品实体类
     */
    Meals selectOneMeal(@Param("id") int id);
}