package nxu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import nxu.dao.MealsMapper;
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

    /**
     * 条件查询餐品信息
     *
     * @param map 条件map，以及 pageNum, pageSize
     * @return 餐品实体集合
     */
    @Override
    public PageInfo<Meals> getMeals(Map<String, Object> map) {
        if (map.containsKey("pageNum") && map.containsKey("pageSize")) {
            // 开启分页查询，设置页码和每页数据量
            PageHelper.startPage((int) map.get("pageNum"), (int) map.get("pageSize"));
            List<Meals> list = mealsMapper.selectMeals(map);
            return new PageInfo<>(list);    // 分页查询结果，里面包含总页数，当前第几页等
        } else {
            return new PageInfo<>(mealsMapper.selectMeals(map));    // 不分页查询
        }
    }
}