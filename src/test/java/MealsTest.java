import com.github.pagehelper.PageInfo;
import nxu.entity.Address;
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

    @Test
    public void test2() {
        Address address = new Address();
        address.setId(2);
        int i = mealsService.insertMeals(new Meals(0, "测试餐品", 8.8, "一堆原料", "1-2-3", "xxx.png", 2, "一份测试餐品", 2, address));
        System.out.println(i);
    }

    @Test
    public void test3() {
        Address address = new Address();
        address.setId(3);
        int i = mealsService.updateMeals(new Meals(1, "新测试餐品", 9.9, "新一堆原料", "1-2-3-4", "happy.png", 1, "新一份测试餐品", 1, address));
        System.out.println(i);
    }

    @Test
    public void test4() {
        int i = mealsService.deleteMeals(5);
        System.out.println(i);
    }

    @Test
    public void test5() {
        Meals meals = mealsService.selectOneMeal(1);
        System.out.println(meals);
    }

}