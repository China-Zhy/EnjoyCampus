package nxu.service;

import nxu.entity.ErrandsOrder;
import nxu.entity.MealsOrder;

import java.util.List;
import java.util.Map;

/**
 * @author 张月、张宏业
 * @apiNote 订单服务层接口
 */
public interface OrderService {

    /**
     * 获取跑腿订单信息
     *
     * @param id 跑腿订单编号
     * @return 跑腿订单实体类
     */
    ErrandsOrder getOneErrandsOrder(int id);

    /**
     * 查询跑腿订单
     *
     * @param map 查询参数 user、errands、pageNum、pageSize等
     * @return 跑腿订单集合
     */
    List<ErrandsOrder> selectErrandsOrders(Map<String, Object> map);

    /**
     * 插入跑腿订单
     *
     * @param order 跑腿订单
     * @return 插入结果
     */
    int insertErrandsOrder(ErrandsOrder order);

    /**
     * 更新跑腿订单
     *
     * @param order 跑腿订单
     * @return 更新结果
     */
    int updateErrandsOrder(ErrandsOrder order);

    /**
     * 删除跑腿订单
     *
     * @param id 跑腿订单编号
     * @return 删除结果
     */
    int deleteErrandsOrder(int id);

    // -------------------------------------------------------------------

    /**
     * 获取点餐订单信息
     *
     * @param id 点餐订单编号
     * @return 点餐订单实体类
     */
    MealsOrder getOneMealsOrder(int id);

    /**
     * 查询餐品订单
     *
     * @param map 查询参数 user、errands、pageNum、pageSize等
     * @return 餐品订单集合
     */
    List<MealsOrder> selectMealsOrders(Map<String, Object> map);

    /**
     * 插入点餐订单
     *
     * @param order 点餐订单
     * @return 插入结果
     */
    int insertMealsOrder(MealsOrder order);

    /**
     * 更新点餐订单
     *
     * @param order 点餐订单
     * @return 更新结果
     */
    int updateMealsOrder(MealsOrder order);

    /**
     * 删除点餐订单
     *
     * @param id 点餐订单编号
     * @return 删除结果
     */
    int deleteMealsOrder(int id);
}