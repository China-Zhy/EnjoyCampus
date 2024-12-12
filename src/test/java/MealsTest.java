import com.github.pagehelper.PageInfo;
import nxu.entity.Meals;
import nxu.service.MealsService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

/**
 * @author 张宏业
 * @apiNote 餐品业务的单元测试
 */
public class MealsTest extends BaseTest {

    @Autowired
    private MealsService mealsService;

    @Test
    public void test1() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "西");
        map.put("pageNum", 1);
        map.put("pageSize", 2);
        map.put("type", 1);
        PageInfo<Meals> meals = mealsService.getMeals(map);
        for (Meals meal : meals.getList()) {
            System.out.println(meal);
        }
    }

}