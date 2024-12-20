import com.github.pagehelper.PageInfo;
import nxu.entity.Comments;
import nxu.entity.ErrandsOrder;
import nxu.entity.MealsOrder;
import nxu.service.OrderService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 张月
 * @apiNote 订单的单元测试
 */public class OrderTest extends BaseTest{
     @Autowired
     private OrderService orderService;

     @Test
     public void test() {
         Map<String, Object> map = new HashMap<>();
         map.put("pageNum", 1);
         map.put("pageSize", 5);
         map.put("user", 8);
         map.put("errands", 8);
         PageInfo<ErrandsOrder> errandsOrderPageInfo = orderService.selectErrandsOrders(map);
         System.out.println(errandsOrderPageInfo);
         for (ErrandsOrder errandsOrder : errandsOrderPageInfo.getList()) {
             System.out.println(errandsOrder);
         }
     }
    @Test
    public void test2() {
        Map<String, Object> map = new HashMap<>();
        map.put("pageNum", 1);
        map.put("pageSize", 5);
        map.put("user", 5);
        map.put("errands", 4);
        PageInfo<MealsOrder> mealsOrderPageInfo = orderService.selectMealsOrders(map);
        System.out.println(mealsOrderPageInfo);
        for (MealsOrder mealsOrder : mealsOrderPageInfo.getList()) {
            System.out.println(mealsOrder);
        }
    }

}
