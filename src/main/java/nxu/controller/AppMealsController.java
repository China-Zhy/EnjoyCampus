package nxu.controller;

import com.github.pagehelper.PageInfo;
import nxu.entity.Kinds;
import nxu.entity.Meals;
import nxu.entity.MealsOrder;
import nxu.service.KindsService;
import nxu.service.MealsService;
import nxu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 张宏业
 * @apiNote APP的点餐业务接口
 */
@RestController
public class AppMealsController {

    @Autowired
    private MealsService mealsService;

    @Autowired
    private KindsService kindsService;

    @Autowired
    private OrderService orderService;

    // APP 点餐页面 的 餐品分类导航数据
    @GetMapping("/getAppKinds")
    public List<Kinds> getAppKinds() {
        return kindsService.selectAllKinds();
    }

    // APP 点餐页面 的 推荐餐品的数据、某类餐品的数据、根据名称搜索餐品的数据
    @PostMapping("/getAppMealsData")
    public PageInfo<Meals> getAppMealsData(@RequestBody Map<String, Object> params) {

        Map<String, Object> map = new HashMap<>();

        if (params.containsKey("pageNum")) {
            map.put("pageNum", Integer.parseInt(params.get("pageNum").toString()));
        }
        if (params.containsKey("pageSize")) {
            map.put("pageSize", Integer.parseInt(params.get("pageSize").toString()));
        }
        if (params.containsKey("name")) {
            map.put("name", params.get("name").toString());
        }
        if (params.containsKey("type")) {
            map.put("type", Integer.parseInt(params.get("type").toString()));
        }
        return mealsService.getMeals(map);
    }

    // APP 点餐页面 的 点击某个餐品后显示的餐品详情信息
    @GetMapping("/getAppMealsData")
    public Meals getAppMealsData(int id) {
        return mealsService.selectOneMeal(id);
    }

    // APP 点餐页面 的 确认订单功能(存储订单信息)
    @PostMapping("/insertAppMealsOrder")
    public HashMap<String, Object> insertAppMealsOrder(@RequestBody Map<String, Object> params) {
        MealsOrder mealsOrder = new MealsOrder();
        if (params.containsKey("user")) {
            mealsOrder.setUser(Integer.parseInt(params.get("user").toString()));
        }
        if (params.containsKey("checkList")) {
            mealsOrder.setCheckList(params.get("checkList").toString());
        }
        if (params.containsKey("remarks")) {
            mealsOrder.setRemarks(params.get("remarks").toString());
        }
        if (params.containsKey("address")) {
            mealsOrder.setAddress(Integer.parseInt(params.get("address").toString()));
        }
        if (params.containsKey("price")) {
            mealsOrder.setPrice(Double.parseDouble(params.get("price").toString()));
        }

        mealsOrder.setErrands(1);   // 未接单默认的配送员
        mealsOrder.setState(1); // 配送状态(1-订单未支付)

        int i = orderService.insertMealsOrder(mealsOrder);

        HashMap<String, Object> map = new HashMap<>();
        map.put("result", i > 0);
        map.put("id", mealsOrder.getId());
        return map;
    }

    // APP 点餐服务的支付处理(虚假的支付，只更新订单状态)
    @GetMapping("/doMealsOrderPay")
    public boolean doMealsOrderPay(int id) {
        // 这里需要进行真实的支付逻辑处理！！！
        MealsOrder mealsOrder = new MealsOrder();
        mealsOrder.setId(id);
        mealsOrder.setState(2); // 配送状态(2-订单已支付)
        return orderService.updateMealsOrder(mealsOrder) > 0;
    }

    // APP 点餐服务的修改订单状态(0
    @GetMapping("/updateMealsOrderState")
    public boolean updateMealsOrderState(int id, int state, int errands) {
        MealsOrder mealsOrder = new MealsOrder();
        mealsOrder.setId(id);
        mealsOrder.setState(state); // 配送状态(3-商家已接单，4-骑手配送中，5-餐品已送达，6-其他状况)
        if (errands != 0) {
            mealsOrder.setErrands(errands);
        }
        return orderService.updateMealsOrder(mealsOrder) > 0;
    }

    // APP 跑腿服务 的 查看某个点餐订单详情
    @GetMapping("/getAppMealsOrder")
    public MealsOrder getAppMealsOrder(int id) {
        return orderService.getOneMealsOrder(id);
    }

    // APP 点餐服务的查询订单功能

}