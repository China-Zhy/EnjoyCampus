package nxu.dao;

import nxu.entity.ErrandsOrder;
import nxu.entity.MealsOrder;

import java.util.List;
import java.util.Map;

/**
 * @author 张月
 * @apiNote订单持久层接口
 */public interface OrderMapper {
     /**
      * 查询跑腿订单
      *
      * @param map 查询参数 meals、errands、pageNum、pageSize等
      * @return 跑腿订单集合
      */
     List<ErrandsOrder> selectErrandsOrders(Map<String, Object> map);
     /**
      * 查询餐品订单
      *
      * @param map 查询参数 meals、user、pageNum、pageSize等
      * @return 餐品订单集合
      */
     List<MealsOrder> selectMealsOrders(Map<String, Object> map);
}
