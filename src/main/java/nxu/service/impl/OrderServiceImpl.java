package nxu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import nxu.dao.OrderMapper;
import nxu.dao.UserMapper;
import nxu.entity.ErrandsOrder;
import nxu.entity.MealsOrder;
import nxu.entity.User;
import nxu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 张月
 * @apiNote 订单服务层实现类
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserMapper userMapper;

    /**
     * 查询跑腿订单
     *
     * @param map 查询参数 meals、errands、pageNum、pageSize等
     * @return 跑腿订单集合
     */
    @Override
    public PageInfo<ErrandsOrder> selectErrandsOrders(Map<String, Object> map) {
        if (map.containsKey("pageNum") && map.containsKey("pageSize")) {
            // 开启分页查询，设置页码和每页数据量
            PageHelper.startPage((int) map.get("pageNum"), (int) map.get("pageSize"));
            List<ErrandsOrder> errandsOrders = orderMapper.selectErrandsOrders(map);
            return new PageInfo<>(errandsOrders);    // 分页查询结果，里面包含总页数，当前第几页等
        } else {
            return new PageInfo<>(orderMapper.selectErrandsOrders(map));    // 不分页查询
        }
    }
    /**
     * 查询餐品订单
     *
     * @param map 查询参数 meals、errands、pageNum、pageSize等
     * @return 餐品订单集合
     */
    @Override
    public PageInfo<MealsOrder> selectMealsOrders(Map<String, Object> map) {
        if (map.containsKey("pageNum") && map.containsKey("pageSize")) {
            // 开启分页查询，设置页码和每页数据量
            PageHelper.startPage((int) map.get("pageNum"), (int) map.get("pageSize"));
            List<MealsOrder> mealsOrders = orderMapper.selectMealsOrders(map);
            return new PageInfo<>(mealsOrders);    // 分页查询结果，里面包含总页数，当前第几页等
        } else {
            return new PageInfo<>(orderMapper.selectMealsOrders(map));    // 不分页查询
        }
    }

}
