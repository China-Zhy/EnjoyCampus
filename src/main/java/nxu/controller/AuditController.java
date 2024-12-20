package nxu.controller;

import nxu.entity.Audit;
import nxu.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @author 常嘉祺
 * @apiNote 审核控制器
 */
@Controller
public class AuditController {

    @Autowired
    private AuditService auditService;

    /**
     * 显示所有审核记录
     * @param model 用于传递数据到视图层
     * @return 返回视图名称
     */
    @GetMapping("/getAuditErrands")
    public String getAuditErrands(@RequestParam("type") int type, Model model) {
        // 根据传入的 type 处理不同的审核记录
        List<Audit> audits = auditService.getAuditListByType(type);  // 调用 service 根据类型过滤数据
        model.addAttribute("audits", audits);  // 将审核记录传递到视图层
        return "auditErrands";  // 返回审核列表页面
    }
    @GetMapping("/getAuditMeals")
    public String getAuditMeals(@RequestParam("type") int type, Model model) {
        // 根据传入的 type 处理不同的审核记录
        List<Audit> audits = auditService.getAuditListByType(type);  // 调用 service 根据类型过滤数据
        model.addAttribute("audits", audits);  // 将审核记录传递到视图层
        return "auditMeals";  // 返回审核列表页面
    }
    @GetMapping("/getAuditMealUser")
    public String getAuditMealUser(@RequestParam("type") int type, Model model) {
        // 根据传入的 type 处理不同的审核记录
        List<Audit> audits = auditService.getAuditListByType(type);  // 调用 service 根据类型过滤数据
        model.addAttribute("audits", audits);  // 将审核记录传递到视图层
        return "auditMealUser";  // 返回审核列表页面
    }

}