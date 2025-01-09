package nxu.controller;

import nxu.entity.Identity;
import nxu.entity.User;
import nxu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 张宏业
 * @apiNote APP的用户业务接口
 */
@RestController
public class AppUserController {

    @Autowired
    private UserService userService;

    // APP用户 的 登录操作
    @PostMapping("/doAppUserLogin")
    public Map<String, Object> doAppUserLogin(@RequestBody Map<String, Object> params) {
        HashMap<String, Object> map = new HashMap<>();

        User user = userService.selectUserByLogin(params.get("phone").toString());

        if (user == null) {
            map.put("status", 1);
            map.put("message", "系统提示：该手机号尚未注册！");
        } else {
            if (user.getPassword().equals(params.get("password").toString())) {
                map.put("status", 2);
                map.put("message", "系统提示：登录成功，欢迎您！");
                map.put("user", user);
            } else {
                map.put("status", 3);
                map.put("message", "系统提示：输入的密码不正确！");
            }
        }
        return map;
    }

    // APP用户 的 注册操作
    @PostMapping("/doAppUserRegister")
    public Map<String, Object> doAppUserRegister(@RequestBody Map<String, Object> params) {

        User user = new User();
        user.setName(params.get("name").toString());
        user.setPhone(params.get("phone").toString());
        user.setPassword(params.get("password").toString());

        Map<String, Object> map = new HashMap<>();

        if (userService.selectUserByLogin(user.getPhone()) != null) {
            map.put("status", 1);
            map.put("message", "系统提示：该手机号已被注册！换个试试~");
        } else {
            user.setIdentity(new Identity(5, ""));
            user.setOther("该用户尚未填写其他信息！");
            user.setAvatar("/image/avatar/nxu.png");
            user.setGender(1);

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