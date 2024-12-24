package nxu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 张宏业
 * @apiNote 系统控制器
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
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