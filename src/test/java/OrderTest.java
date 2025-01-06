import nxu.entity.ErrandsOrder;
import nxu.entity.MealsOrder;
import nxu.service.OrderService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

/**
 * @author 张月、张宏业
 * @apiNote 订单的单元测试
 */
public class OrderTest extends BaseTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void test1() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user", 5);
        map.put("errands", 4);
        List<ErrandsOrder> errandsOrders = orderService.selectErrandsOrders(map);
        for (ErrandsOrder errandsOrder : errandsOrders) {
            System.out.println(errandsOrder);
        }
    }

    @Test
    public void test2() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user", 5);
        map.put("errands", 4);
        List<MealsOrder> mealsOrders = orderService.selectMealsOrders(map);
        for (MealsOrder mealsOrder : mealsOrders) {
            System.out.println(mealsOrder);
        }
    }

    @Test
    public void test3() {
        int i = orderService.insertErrandsOrder(new ErrandsOrder(0, 5, 4, "a.png", "1-2/2-1", null, null, 1, "快快配送"));
        System.out.println(i);
    }

    @Test
    public void test4() {
        int i = orderService.insertMealsOrder(new MealsOrder(0, 5, 4, "1-2/2-1", null, null, 1, "快快配送", 0));
        System.out.println(i);
    }

    @Test
    public void test5() {
        ErrandsOrder errandsOrder = new ErrandsOrder();
        errandsOrder.setId(2);
        errandsOrder.setVoucher("b.png");
        errandsOrder.setCheckList("a.png;b.png;c.png;d.png");
        errandsOrder.setEndTime(LocalDateTime.now());
        errandsOrder.setState(2);
        errandsOrder.setRemarks("最新的备注信息");
        int i = orderService.updateErrandsOrder(errandsOrder);
        System.out.println(i);
    }

    @Test
    public void test6() {
        MealsOrder mealsOrder = new MealsOrder();
        mealsOrder.setId(3);
        mealsOrder.setCheckList("3-3/4-4");
        mealsOrder.setEndTime(LocalDateTime.now());
        mealsOrder.setState(2);
        mealsOrder.setRemarks("最最新备注");
        mealsOrder.setAddress(0);
        int i = orderService.updateMealsOrder(mealsOrder);
        System.out.println(i);
    }

    @Test
    public void test7() {
        int i = orderService.deleteErrandsOrder(2);
        System.out.println(i);
    }

    @Test
    public void test8() {
        int i = orderService.deleteMealsOrder(2);
        System.out.println(i);
    }

}