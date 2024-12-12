package nxu.dao;

import nxu.entity.Meals;

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
}