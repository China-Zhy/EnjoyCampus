package nxu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 常嘉祺
 * @apiNote
 */
@Controller
public class AuditController {

    @GetMapping("/getAuditErrands")
    public String getAuditErrands(Model model, int type) {
        System.out.println("类型：" + type);
        model.addAttribute("type", type);
        return "auditErrands";
    }

    @GetMapping("/getAuditMealUser")
    public String getAuditMealUser(Model model, int type) {
        System.out.println("类型：" + type);
        model.addAttribute("type", type);
        return "auditMealUser";
    }

    @GetMapping("/getAuditMeals")
    public String getAuditMeals(Model model, int type) {
        System.out.println("类型：" + type);
        model.addAttribute("type", type);
        return "auditMeals";
    }

}