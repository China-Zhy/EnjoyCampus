package nxu.controller;

import nxu.entity.ErrandsOrder;
import nxu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 张宏业
 * @apiNote APP跑腿业务的接口
 */
@RestController
public class AppErrandsController {

    @Autowired
    private OrderService orderService;

    // APP 跑腿服务页面 的 下订单功能(存储订单信息)
    @PostMapping("/insertAppErrandsOrder")
    public HashMap<String, Object> insertAppErrandsOrder(@RequestBody Map<String, Object> params) {
        ErrandsOrder errandsOrder = new ErrandsOrder();

        if (params.containsKey("checkList")) {
            errandsOrder.setCheckList(params.get("checkList").toString());
        }
        if (params.containsKey("remarks")) {
            errandsOrder.setRemarks(params.get("remarks").toString());
        }
        if (params.containsKey("voucher")) {
            errandsOrder.setVoucher(params.get("voucher").toString());
        }
        if (params.containsKey("user")) {
            errandsOrder.setUser(Integer.parseInt(params.get("user").toString()));
        }
        if (params.containsKey("price")) {
            errandsOrder.setPrice(Double.parseDouble(params.get("price").toString()));
        }

        errandsOrder.setErrands(1);   // 未接单默认的跑腿人员
        errandsOrder.setState(1); // 跑腿状态(1-跑腿服务寻找中，2-跑腿服务进行中，3-跑腿服务已完成，4-其他状况)

        int i = orderService.insertErrandsOrder(errandsOrder);

        HashMap<String, Object> map = new HashMap<>();
        map.put("result", i > 0);
        map.put("id", errandsOrder.getId());
        return map;
    }

    // APP 跑腿服务 的 查看某个跑腿订单详情
    @GetMapping("/getAppErrandsOrder")
    public ErrandsOrder getAppErrandsOrder(int id) {
        return orderService.getOneErrandsOrder(id);
    }

    // APP 跑腿服务 的 更新跑腿订单状态
    @GetMapping("/updateAppErrandsOrderState")
    public boolean updateAppErrandsOrder(int id, int state, int errands) {
        ErrandsOrder errandsOrder = new ErrandsOrder();
        errandsOrder.setId(id);
        errandsOrder.setState(state);
        if (errands != 0) {
            errandsOrder.setErrands(errands);
        }
        return orderService.updateErrandsOrder(errandsOrder) > 0;
    }

}