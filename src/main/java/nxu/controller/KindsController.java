package nxu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

/**
 * @author 张长志
 * @apiNote
 */
@Controller
public class KindsController {

    @GetMapping("/getMealsKinds")
    public String mealsKinds(Model model) {
        ArrayList<String> objects = new ArrayList<>();
        objects.add("张宏业");
        objects.add("张月");
        objects.add("张长志");
        objects.add("常嘉祺");

        model.addAttribute("sb", objects);
        return "mealsKinds";
    }
}
