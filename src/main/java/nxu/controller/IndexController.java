package nxu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 张宏业
 * @apiNote 系统控制器
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "欢迎访问乐享校园！当前为开发测试页面！");
        return "index";
    }

    @GetMapping("/toUserLogin")
    public String toLogin() {
        return "userLogin";
    }

    @GetMapping("/toUserRegister")
    public String toRegister() {
        return "userRegister";
    }

    @GetMapping("/toAdminMain")
    public String toAdminMain() {
        return "main";
    }

}