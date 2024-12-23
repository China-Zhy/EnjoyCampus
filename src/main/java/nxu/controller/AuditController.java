package nxu.controller;

import nxu.entity.Audit;
import nxu.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 常嘉祺、张宏业
 * @apiNote 审核控制器
 */
@Controller
public class AuditController {

    @Autowired
    private AuditService auditService;

    @GetMapping("/goToAuditManager")
    public String getAuditErrands(int type, Model model) {

        List<Audit> audits = auditService.getAuditListByType(type);

        model.addAttribute("auditList", audits);
        model.addAttribute("type", type);
        model.addAttribute("state", 0);

        return "auditManager";
    }

    @PostMapping("/doSelectAudit")
    public String doSelectAudit(int type, int state, Model model) {

        List<Audit> list = auditService.getAuditListByState(type, state);

        model.addAttribute("auditList", list);
        model.addAttribute("type", type);
        model.addAttribute("state", state);

        return "auditManager";
    }

    @PostMapping("/doUpdateAudit")
    @ResponseBody
    public Map<String, Object> doUpdateAudit(int id, int state, String info) {

        int i = auditService.updateAuditState(id, state, info);

        Map<String, Object> map = new HashMap<>();
        if (i > 0) {
            map.put("status", true);
            map.put("message", "系统提示：修改成功，该审核数据已更新！");
        } else {
            map.put("status", false);
            map.put("message", "系统提示：修改失败，该审核数据尚未修改！");
        }
        return map;
    }
}