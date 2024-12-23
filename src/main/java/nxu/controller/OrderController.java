package nxu.controller;

import nxu.entity.ErrandsOrder;
import nxu.entity.MealsOrder;
import nxu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;


/**
 * @author 张月、张宏业
 * @apiNote 订单控制器
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/goToOrderManager")
    public String addOrder(Model model, int type) {
        if (type == 1) {
            List<ErrandsOrder> errandsOrders = orderService.selectErrandsOrders(new HashMap<>());
            model.addAttribute("orderList", errandsOrders);
        } else {
            List<MealsOrder> mealsOrders = orderService.selectMealsOrders(new HashMap<>());
            model.addAttribute("orderList", mealsOrders);
        }
        model.addAttribute("type", type);
        return "orderManager";
    }

}