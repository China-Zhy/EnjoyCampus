package nxu.service;

import com.github.pagehelper.PageInfo;
import nxu.entity.ErrandsOrder;
import nxu.entity.MealsOrder;

import java.util.Map;

/**
 * @author 张月
 * @apiNote 订单服务层接口
 */
public interface OrderService {
    /**
     * 查询跑腿订单
     *
     * @param map 查询参数 meals、errands、pageNum、pageSize等
     * @return 跑腿订单集合
     */
    PageInfo<ErrandsOrder> selectErrandsOrders(Map<String, Object> map);
    /**
     * 查询餐品订单
     *
     * @param map 查询参数 meals、errands、pageNum、pageSize等
     * @return 餐品订单集合
     */
    PageInfo<MealsOrder> selectMealsOrders(Map<String, Object> map);
}
