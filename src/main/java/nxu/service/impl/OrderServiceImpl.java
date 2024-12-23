package nxu.service.impl;

import nxu.dao.OrderMapper;
import nxu.entity.ErrandsOrder;
import nxu.entity.MealsOrder;
import nxu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 张月、张宏业
 * @apiNote 订单服务层实现类
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    /**
     * 查询跑腿订单
     *
     * @param map 查询参数 meals、errands、pageNum、pageSize等
     * @return 跑腿订单集合
     */
    @Override
    public List<ErrandsOrder> selectErrandsOrders(Map<String, Object> map) {
        return orderMapper.selectErrandsOrders(map);
    }

    /**
     * 插入跑腿订单
     *
     * @param order 跑腿订单
     * @return 插入结果
     */
    @Override
    public int insertErrandsOrder(ErrandsOrder order) {
        return orderMapper.insertErrandsOrder(order);
    }

    /**
     * 更新跑腿订单
     *
     * @param order 跑腿订单
     * @return 更新结果
     */
    @Override
    public int updateErrandsOrder(ErrandsOrder order) {
        return orderMapper.updateErrandsOrder(order);
    }

    /**
     * 删除跑腿订单
     *
     * @param id 跑腿订单编号
     * @return 删除结果
     */
    @Override
    public int deleteErrandsOrder(int id) {
        return orderMapper.deleteErrandsOrder(id);
    }

    /**
     * 查询餐品订单
     *
     * @param map 查询参数 meals、user、pageNum、pageSize等
     * @return 餐品订单集合
     */
    @Override
    public List<MealsOrder> selectMealsOrders(Map<String, Object> map) {
        return orderMapper.selectMealsOrders(map);
    }

    /**
     * 插入点餐订单
     *
     * @param order 点餐订单
     * @return 插入结果
     */
    @Override
    public int insertMealsOrder(MealsOrder order) {
        return orderMapper.insertMealsOrder(order);
    }

    /**
     * 更新点餐订单
     *
     * @param order 点餐订单
     * @return 更新结果
     */
    @Override
    public int updateMealsOrder(MealsOrder order) {
        return orderMapper.updateMealsOrder(order);
    }

    /**
     * 删除点餐订单
     *
     * @param id 点餐订单编号
     * @return 删除结果
     */
    @Override
    public int deleteMealsOrder(int id) {
        return orderMapper.deleteMealsOrder(id);
    }
}