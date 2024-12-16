package nxu.controller;

import nxu.entity.Comments;
import nxu.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

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