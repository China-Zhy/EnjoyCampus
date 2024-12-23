package nxu.controller;

import nxu.service.TasteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 张宏业
 * @apiNote 餐品口味控制器
 */
@Controller
public class TasteController {

    @Autowired
    private TasteService tasteService;

    @GetMapping("/goToMealsTaste")
    public String taste(Model model) {
        model.addAttribute("tasteList", tasteService.selectAllTaste());
        return "tasteManager";
    }

    @PostMapping("/doUpdateTaste")
    @ResponseBody
    public Map<String, Object> updateTaste(int id, String name) {
        HashMap<String, Object> map = new HashMap<>();
        int i = tasteService.updateTaste(id, name);
        if (i > 0) {
            map.put("status", true);
            map.put("message", "系统提示：修改成功，该口味数据已更新！");
        } else {
            map.put("status", false);
            map.put("message", "系统提示：修改失败，该口味数据尚未修改！");
        }
        return map;
    }

    @PostMapping("/doDeleteTaste")
    @ResponseBody
    public Map<String, Object> deleteTaste(int id) {
        HashMap<String, Object> map = new HashMap<>();
        int i = tasteService.deleteTaste(id);
        if (i > 0) {
            map.put("status", true);
            map.put("message", "系统提示：删除成功，该口味数据已被删除！");
        } else {
            map.put("status", false);
            map.put("message", "系统提示：修改失败，该口味数据仍然存在！");
        }
        return map;
    }

    @PostMapping("/doInsertTaste")
    @ResponseBody
    public Map<String, Object> insertTaste(String name) {
        HashMap<String, Object> map = new HashMap<>();
        int i = tasteService.insertTaste(name);
        if (i > 0) {
            map.put("status", true);
            map.put("message", "系统提示：添加成功，新口味数据已存入！");
        } else {
            map.put("status", false);
            map.put("message", "系统提示：添加失败，该口味数据尚未存入！");
        }
        return map;
    }
}