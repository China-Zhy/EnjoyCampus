package nxu.controller;


import nxu.entity.ErrandsOrder;
import nxu.entity.MealsOrder;
import nxu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 张月
 * @apiNote 订单控制器
 */
@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/getOrderErrands")
    public String orderErrands(Model model) {
        List<ErrandsOrder> errandsorder = orderService.selectErrandsOrders(new HashMap<>()).getList();
        model.addAttribute("errandsorder", errandsorder);
//        model.addAttribute("msg", "查询的跑腿订单数据");
        return "orderErrands";
    }

    @GetMapping("/getOrderMeals")
    public String orderMeals(@RequestBody Map<String, Object> params,Model model) {
        List<MealsOrder> mealsorder = orderService.selectMealsOrders(params).getList();
        model.addAttribute("mealsorder", mealsorder);
//        model.addAttribute("msg", "查询的餐品订单数据");
        return "orderMeals";
    }

}