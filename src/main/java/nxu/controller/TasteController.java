package nxu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author 张长志
 * @apiNote
 */
@Controller
public class TasteController {

    @GetMapping("/getTasteMeals")
    public String getTasteMeals(Model model) {
        HashMap<String, Object> map = new HashMap<>();

        map.put("a", "我爱宁大");

        map.put("b", 666);

        ArrayList<String> objects = new ArrayList<>();
        objects.add("张宏业");
        objects.add("张月");
        objects.add("张长志");
        objects.add("常嘉祺");
        map.put("c", objects);

        model.addAttribute("dsb", map);
        return "mealsTaste";
    }
}
