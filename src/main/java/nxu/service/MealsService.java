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
    int deleteMeals(int id);

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
    Meals selectOneMeal(int id);
}