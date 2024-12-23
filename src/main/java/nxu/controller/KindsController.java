package nxu.controller;

import nxu.entity.Kinds;
import nxu.service.KindsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 张宏业
 * @apiNote 餐品种类控制器
 */
@Controller
public class KindsController {

    @Autowired
    private KindsService kindsService;

    @GetMapping("/goToMealsKinds")
    public String kinds(Model model) {
        model.addAttribute("kindsList", kindsService.selectAllKinds());
        return "kindsManager";
    }

    @PostMapping("/doUpdateKinds")
    @ResponseBody
    public Map<String, Object> updateKinds(@ModelAttribute Kinds kinds) {
        kinds.setImage("/static/kinds/" + kinds.getImage().substring(kinds.getImage().lastIndexOf("\\") + 1));
        HashMap<String, Object> map = new HashMap<>();
        int i = kindsService.updateKinds(kinds);
        if (i > 0) {
            map.put("status", true);
            map.put("message", "系统提示：修改成功，该种类数据已更新！");
        } else {
            map.put("status", false);
            map.put("message", "系统提示：修改失败，该种类数据尚未修改！");
        }
        return map;
    }

    @PostMapping("/doDeleteKinds")
    @ResponseBody
    public Map<String, Object> deleteKinds(int id) {
        HashMap<String, Object> map = new HashMap<>();
        int i = kindsService.deleteKinds(id);
        if (i > 0) {
            map.put("status", true);
            map.put("message", "系统提示：删除成功，该种类数据已被删除！");
        } else {
            map.put("status", false);
            map.put("message", "系统提示：修改失败，该种类数据仍然存在！");
        }
        return map;
    }

    @PostMapping("/doInsertKinds")
    @ResponseBody
    public Map<String, Object> insertKinds(String name, String image) {
        HashMap<String, Object> map = new HashMap<>();
        int i = kindsService.insertKinds(name, "/static/kinds/" + image.substring(image.lastIndexOf("\\") + 1));    // 截取文件名，拼接路径
        if (i > 0) {
            map.put("status", true);
            map.put("message", "系统提示：添加成功，新种类数据已存入！");
        } else {
            map.put("status", false);
            map.put("message", "系统提示：添加失败，该种类数据尚未存入！");
        }
        return map;
    }
}