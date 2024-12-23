package nxu.controller;

import com.github.pagehelper.PageInfo;
import nxu.entity.Comments;
import nxu.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 张宏业
 * @apiNote 评论控制器
 */
@Controller
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    @GetMapping("/toToCommentsManager")
    public String toToCommentsManager(Model model) {
        PageInfo<Comments> commentsPageInfo = commentsService.selectComments(new HashMap<>());
        model.addAttribute("commentsList", commentsPageInfo.getList());
        Map<String, Object> map = new HashMap<>();
        map.put("user", "");
        map.put("meals", "");
        map.put("state", 0);
        model.addAttribute("params", map);
        return "commentsManager";
    }

    @PostMapping("/doSelectComments")
    public String doSelectComments(Model model, @RequestParam Map<String, Object> params) {
        boolean noState = false;
        if (params.containsKey("state") && Integer.parseInt(params.get("state").toString()) == 0) {
            params.remove("state");
            noState = true;
        }
        PageInfo<Comments> commentsPageInfo = commentsService.selectComments(params);
        model.addAttribute("commentsList", commentsPageInfo.getList());
        if (noState) {
            params.put("state", 0);
        } else {
            params.put("state", Integer.parseInt(params.get("state").toString()));
        }
        model.addAttribute("params", params);
        return "commentsManager";
    }

    @PostMapping("/doUpdateComments")
    @ResponseBody
    public Map<String, Object> doUpdateComments(int id, int state) {
        Map<String, Object> map = new HashMap<>();
        int i = commentsService.updateComments(id, state);
        if (i > 0) {
            map.put("status", true);
            map.put("message", "系统提示：修改成功，该评论状态已更新！");
        } else {
            map.put("status", false);
            map.put("message", "系统提示：修改失败，该评论状态尚未修改！");
        }
        return map;
    }

    @GetMapping("/getComments")
    @ResponseBody
    public List<Comments> getComments(@RequestBody Map<String, Object> params) {
        System.out.println(params);
        return commentsService.selectComments(params).getList();
    }

    @PostMapping("/addComments")
    @ResponseBody
    public int addComments(Comments comments) {
        return commentsService.insert(comments);
    }

}