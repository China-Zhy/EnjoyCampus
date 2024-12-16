package nxu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import nxu.dao.AddressMapper;
import nxu.dao.MealsMapper;
import nxu.entity.Address;
import nxu.entity.Meals;
import nxu.service.MealsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 张宏业
 * @apiNote 餐品服务层实现类
 */
@Service
public class MealsServiceImpl implements MealsService {

    @Autowired
    private MealsMapper mealsMapper;

    @Autowired
    private AddressMapper addressMapper;

    /**
     * 条件查询餐品信息
     *
     * @param map 条件map，以及 pageNum, pageSize
     * @return 餐品实体集合
     */
    @Override
    public PageInfo<Meals> getMeals(Map<String, Object> map) {
        // 这块查询时为了提高速度，暂时不查询餐品的位置信息
        if (map.containsKey("pageNum") && map.containsKey("pageSize")) {
            // 开启分页查询，设置页码和每页数据量
            PageHelper.startPage((int) map.get("pageNum"), (int) map.get("pageSize"));
            List<Meals> list = mealsMapper.selectMeals(map);
            return new PageInfo<>(list);    // 分页查询结果，里面包含总页数，当前第几页等
        } else {
            return new PageInfo<>(mealsMapper.selectMeals(map));    // 不分页查询
        }
    }

    /**
     * 添加餐品
     *
     * @param meals 餐品实体类
     * @return 添加结果：1-添加成功，0-添加失败
     */
    @Override
    public int insertMeals(Meals meals) {
        return mealsMapper.insertMeals(meals);
    }

    /**
     * 删除餐品
     *
     * @param id 餐品编号
     * @return 删除结果：1-删除成功，0-删除失败
     */
    @Override
    public int deleteMeals(int id) {
        return mealsMapper.deleteMeals(id);
    }

    /**
     * 修改餐品
     *
     * @param meals 餐品实体类
     * @return 修改结果：1-修改成功，0-修改失败
     */
    @Override
    public int updateMeals(Meals meals) {
        return mealsMapper.updateMeals(meals);
    }

    /**
     * 通过编号查询餐品
     *
     * @param id 餐品编号
     * @return 餐品实体类
     */
    @Override
    public Meals selectOneMeal(int id) {
        Meals meals = mealsMapper.selectOneMeal(id);
        if (meals != null) {
            List<Address> addresses = addressMapper.selectByEntity(meals.getId());
            for (Address address : addresses) {
                if (address.getType() == 2) {
                    meals.setAddress(address);
                }
            }
        }
        return meals;
    }
}