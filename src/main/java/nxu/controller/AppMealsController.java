package nxu.controller;

import com.github.pagehelper.PageInfo;
import nxu.entity.Kinds;
import nxu.entity.Meals;
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
    public boolean insertAppMealsOrder(@RequestBody Map<String, Object> params) {
        // 未完待续。。。
        System.out.println(params);
        return true;
    }
}