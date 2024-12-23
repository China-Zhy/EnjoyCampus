package nxu.controller;

import jakarta.servlet.http.HttpSession;
import nxu.entity.Identity;
import nxu.entity.Kinds;
import nxu.entity.Taste;
import nxu.entity.User;
import nxu.service.IdentityService;
import nxu.service.KindsService;
import nxu.service.TasteService;
import nxu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 张宏业
 * @apiNote 用户控制器
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private IdentityService identityService;

    @Autowired
    private KindsService kindsService;

    @Autowired
    private TasteService tasteService;

    @PostMapping("/doUserLogin")
    @ResponseBody
    public Map<String, Object> login(HttpSession session, String phone, String password) {
        Map<String, Object> map = new HashMap<>();

        User user = userService.selectUserByLogin(phone);
        if (user == null) {
            map.put("status", 1);
            map.put("message", "系统提示：该手机号尚未注册！");
        } else {
            if (user.getPassword().equals(password)) {
                System.out.println("Tips:登录的用户信息：" + user);
                map.put("status", 2);
                map.put("message", "系统提示：登录成功，欢迎您！");
                session.setAttribute("user", user);     // 把用户数据存入Session

                List<Identity> identities = identityService.selectAll();
                session.setAttribute("identityList", identities);   // 把身份类型也存入Session

                List<Kinds> kinds = kindsService.selectAllKinds();
                session.setAttribute("kindsList", kinds);   // 把餐品种类也存入Session

                List<Taste> tastes = tasteService.selectAllTaste();
                session.setAttribute("tasteList", tastes);  // 把餐品口味也存入Session
            } else {
                map.put("status", 3);
                map.put("message", "系统提示：输入的密码不正确！");
            }
        }
        return map;
    }

    @GetMapping("/doUserLogout")
    public String logout(HttpSession session) {
        session.invalidate();
        System.out.println("Tips:用户已退出登录！");
        return "index";
    }

    @PostMapping("/doUserRegister")
    @ResponseBody
    public Map<String, Object> register(@ModelAttribute User user) {
        Map<String, Object> map = new HashMap<>();

        User isExists = userService.selectUserByLogin(user.getPhone());

        if (isExists != null) {
            map.put("status", 1);
            map.put("message", "系统提示：该手机号已被注册！");
        } else {
            user.setAvatar("/image/avatar/nxu.png");
            user.setGender(1);
            user.setOther("该用户尚未填写其他信息！");
            user.setIdentity(new Identity(5, ""));
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

    @GetMapping("/goToUserSelect")
    public String goToUserSelect(Model model) {

        List<User> users = userService.selectUserByIdentity(0);
        model.addAttribute("users", users);

        HashMap<String, Object> map = new HashMap<>();
        map.put("phone", "");
        map.put("identity", 0);
        map.put("register", "");
        model.addAttribute("params", map);

        return "userManager";
    }

    @PostMapping("/doSelectUser")
    public String doSelectUser(@RequestParam Map<String, Object> params, Model model) {

        List<User> users = userService.selectUserByConditions(params);

        model.addAttribute("users", users);

        List<Identity> identities = identityService.selectAll();
        model.addAttribute("identities", identities);

        // 将页面传过来的数据转换为int类型传回去
        int identity = Integer.parseInt(params.get("identity").toString());
        params.remove("identity");
        params.put("identity", identity);

        model.addAttribute("params", params);

        return "userManager";
    }

    @PostMapping("/getDetailUser")
    @ResponseBody
    public User getDetailUser(int id) {
        return userService.selectUserById(id);
    }

    @PostMapping("/doUpdateUser")
    @ResponseBody
    public Map<String, Object> doUpdateUser(@RequestParam Map<String, Object> params) {
        Map<String, Object> map = new HashMap<>();
        User user = new User();
        if (params.get("id") != null) {
            user.setId(Integer.parseInt(params.get("id").toString()));
        }
        if (params.get("name") != null) {
            user.setName(params.get("name").toString());
        }
        if (params.get("phone") != null) {
            user.setPhone(params.get("phone").toString());
        }
        if (params.get("password") != null) {
            user.setPassword(params.get("password").toString());
        }
        if (params.get("identity") != null) {
            user.setIdentity(new Identity(Integer.parseInt(params.get("identity").toString()), ""));
        }
        if (params.get("gender") != null) {
            user.setGender(Integer.parseInt(params.get("gender").toString()));
        }
        if (params.get("other") != null) {
            user.setOther(params.get("other").toString());
        }
        int i = userService.updateUser(user);
        if (i > 0) {
            map.put("status", true);
            map.put("message", "系统提示：修改成功，该用户数据已更新！");
        } else {
            map.put("status", false);
            map.put("message", "系统提示：修改失败，该用户数据未更改！");
        }
        return map;
    }

    @PostMapping("/doDeleteUser")
    @ResponseBody
    public Map<String, Object> doDeleteUser(int id) {
        Map<String, Object> map = new HashMap<>();
        int result = userService.deleteUser(id);
        if (result > 0) {
            map.put("status", true);
            map.put("message", "系统提示：删除成功，该用户已被删除！");
        } else {
            map.put("status", false);
            map.put("message", "系统提示：删除失败，该用户尚未被删除！");
        }
        return map;
    }

}