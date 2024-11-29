package nxu.controller;

import jakarta.servlet.http.HttpSession;
import nxu.entity.Identity;
import nxu.entity.User;
import nxu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 张宏业
 * @apiNote 用户控制器
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/doLogin")
    @ResponseBody
    public Map<String, Object> login(HttpSession session, String phone, String password) {
        Map<String, Object> map = new HashMap<>();
        System.out.println(phone + " " + password);
        User user = userService.selectUserByLogin(phone);
        if (user == null) {
            map.put("status", 1);
            map.put("message", "系统提示：该手机号尚未注册！");
        } else {
            if (user.getPassword().equals(password)) {
                System.out.println("登录的用户信息：" + user);
                map.put("status", 2);
                map.put("message", "系统提示：登录成功，欢迎您！");
                session.setAttribute("user", user);     // 把用户数据存入Session
            } else {
                map.put("status", 3);
                map.put("message", "系统提示：输入的密码不正确！");
            }
        }
        return map;
    }

    @GetMapping("/doLogout")
    @ResponseBody
    public Map<String, Object> logout(HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        session.invalidate();
        map.put("status", true);
        map.put("message", "系统提示：您已成功退出系统，即将离开！");
        return map;
    }

    @PostMapping("/doRegister")
    @ResponseBody
    public Map<String, Object> register(@ModelAttribute User user) {
        Map<String, Object> map = new HashMap<>();

        User isExists = userService.selectUserByLogin(user.getPhone());

        System.out.println("注册信息：" + user);

        if (isExists != null) {
            map.put("status", 1);
            map.put("message", "系统提示：该手机号已被注册！");
        } else {
            user.setAvatar("/image/avatar/nxu.png");
            user.setGender(1);
            user.setOther("该用户尚未填写其他信息！");
            user.setIdentity(new Identity(5, ""));
            System.out.println("新注册信息：" + user);
            int i = userService.insertUser(user);
            if (i > 0) {
                map.put("status", 2);
                map.put("message", "系统提示：注册成功！即将跳转登录页面！");
            } else {
                map.put("status", 3);
                map.put("message", "系统提示：注册失败！请联系系统管理员~");
            }
        }
        return map;
    }

}