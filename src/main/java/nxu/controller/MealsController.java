package nxu.controller;

import com.github.pagehelper.PageInfo;
import nxu.entity.Meals;
import nxu.service.MealsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 张宏业
 * @apiNote 餐品业务控制器
 */
@Controller
public class MealsController {

    @Autowired
    private MealsService mealsService;

    @GetMapping("/goToMealsSelect")
    public String goToMealsSelect(Model model) {

        PageInfo<Meals> meals = mealsService.getMeals(new HashMap<>());
        model.addAttribute("mealsList", meals.getList());

        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "");
        map.put("type", 0);
        model.addAttribute("params", map);

        return "mealsManager";
    }

    @PostMapping("/doSelectMeals")
    public String doSelectMeals(@RequestParam Map<String, Object> params, Model model) {

        System.out.println("参数：" + params);
        int type = Integer.parseInt(params.get("type").toString());
        if (type == 0) {
            params.remove("type");
        }

        List<Meals> list = mealsService.getMeals(params).getList();
        model.addAttribute("mealsList", list);

        // 将页面传过来的数据转换为int类型传回去
        params.put("type", type);

        model.addAttribute("params", params);

        return "mealsManager";
    }

    @PostMapping("/getOneMeals")
    @ResponseBody
    public Map<String, Object> getOneMeals(int id) {
        Map<String, Object> map = new HashMap<>();
        Meals meals = mealsService.selectOneMeal(id);
        map.put("meals", meals);
        String[] split = meals.getFlavors().split("-");     // 将口味拆分为数组
        map.put("flavors", split);
        return map;
    }

    @PostMapping("/doUpdateMeals")
    @ResponseBody
    public Map<String, Object> updateMeals(@ModelAttribute Meals meals) {

        meals.setImage(meals.getImage().substring(meals.getImage().lastIndexOf("\\") + 1));

        int i = mealsService.updateMeals(meals);

        Map<String, Object> map = new HashMap<>();

        if (i > 0) {
            map.put("status", true);
            map.put("message", "系统提示：修改成功，该餐品数据已更新！");
        } else {
            map.put("status", false);
            map.put("message", "系统提示：修改失败，该餐品数据尚未修改！");
        }
        return map;
    }

    @PostMapping("/doDeleteMeals")
    @ResponseBody
    public Map<String, Object> deleteMeals(int id) {

        int i = mealsService.deleteMeals(id);

        Map<String, Object> map = new HashMap<>();
        if (i > 0) {
            map.put("status", true);
            map.put("message", "系统提示：删除成功，该餐品数据已被删除！");
        } else {
            map.put("status", false);
            map.put("message", "系统提示：修改失败，该餐品数据仍然存在！");
        }
        return map;
    }

    @GetMapping("/goToMealsInsert")
    public String goToMealsInsert() {
        return "mealsInsert";
    }

    @PostMapping("/doInsertMeals")
    @ResponseBody
    public Map<String, Object> doInsertMeals(@ModelAttribute Meals meals) {

        meals.setImage(meals.getImage().substring(meals.getImage().lastIndexOf("\\") + 1));

        int i = mealsService.insertMeals(meals);

        Map<String, Object> map = new HashMap<>();
        if (i > 0) {
            map.put("status", true);
            map.put("message", "系统提示：添加成功，该餐品数据已被存入！");
        } else {
            map.put("status", false);
            map.put("message", "系统提示：添加失败，该餐品数据尚未存入！");
        }
        return map;
    }

}