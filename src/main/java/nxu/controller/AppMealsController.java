package nxu.controller;

import nxu.entity.Kinds;
import nxu.entity.Meals;
import nxu.service.KindsService;
import nxu.service.MealsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 张宏业
 * @apiNote APP的点餐接口
 */
@RestController
public class AppMealsController {

    @Autowired
    private MealsService mealsService;

    @Autowired
    private KindsService kindsService;

    // APP 点餐页面 的 顶部轮播图
    @GetMapping("/getSwipes")
    public Map<String, Object> getSwipes() {
        System.out.println("App 发起轮播请求");
        Map<String, Object> map = new HashMap<>();
        List<String> swipes = new ArrayList<>();
        swipes.add("苹果");
        swipes.add("香蕉");
        swipes.add("毛桃");
        map.put("fruitList", swipes);
        return map;
    }

    // APP 点餐页面 的 餐品分类导航数据
    @GetMapping("/getKinds")
    public List<Kinds> getKinds() {
        return kindsService.selectAllKinds();
    }

    // APP 点餐页面 的 某类餐品信息
    @GetMapping("/getKindMeals")
    public List<Meals> getKindMeals(Integer type) {
        System.out.println("接收到了餐品分类请求！type:" + type);
        HashMap<String, Object> map = new HashMap<>();
        map.put("type", type);
        return mealsService.getMeals(map).getList();
    }

    // APP 点餐页面 的 推荐餐品的数据以及根据名称搜索餐品和根据分类搜索餐品
    @PostMapping("/getHotMeals")
    public List<Meals> getMeals(@RequestBody Map<String, Object> params) {

        System.out.println("接收到了" + params);

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

        System.out.println("餐品请求的参数：" + map);

        return mealsService.getMeals(map).getList();
    }
}