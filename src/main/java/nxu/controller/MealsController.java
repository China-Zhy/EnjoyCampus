package nxu.controller;

import nxu.entity.Meals;
import nxu.service.MealsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("/getAllMeals")
    @ResponseBody
    public List<Meals> getAllMeals(@RequestBody Map<String, Object> map) {
        return mealsService.getMeals(map).getList();
    }

}