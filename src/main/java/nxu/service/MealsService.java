package nxu.service;

import com.github.pagehelper.PageInfo;
import nxu.entity.Meals;

import java.util.Map;

/**
 * @author 张宏业
 * @apiNote 餐品服务层接口
 */
public interface MealsService {

    /**
     * 条件查询餐品信息
     *
     * @param map 条件map，以及 pageNum, pageSize
     * @return 餐品实体集合
     */
    PageInfo<Meals> getMeals(Map<String, Object> map);
}