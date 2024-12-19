package nxu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 张月
 * @apiNote
 */
@Controller
public class OrderController {

    @GetMapping("/getOrderErrands")
    public String orderErrands(Model model) {
        model.addAttribute("msg", "查询的跑腿订单数据");
        return "orderErrands";
    }

    @GetMapping("/getOrderMeals")
    public String orderMeals(Model model) {
        model.addAttribute("msg", "查询的餐品订单数据");
        return "orderMeals";
    }

}