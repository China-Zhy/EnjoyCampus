import com.github.pagehelper.PageInfo;
import nxu.entity.Comments;
import nxu.service.CommentsService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 张宏业
 * @apiNote 评论的单元测试
 */
public class CommentsTest extends BaseTest {

    @Autowired
    private CommentsService commentsService;

    @Test
    public void test1() {
        int insert = commentsService.insert(new Comments(0, 5, 1, 4, "味道超级棒，份量超级足！", "comments3.png", null));
        System.out.println(insert);
    }

    @Test
    public void test2() {
        int delete = commentsService.delete(3);
        System.out.println(delete);
    }

    @Test
    public void test3() {
        Map<String, Object> map = new HashMap<>();
        map.put("pageNum", 1);
        map.put("pageSize", 10);
        map.put("user", 5);
        map.put("meals", 1);
        PageInfo<Comments> commentsPageInfo = commentsService.selectComments(map);
        System.out.println(commentsPageInfo);
        for (Comments comments : commentsPageInfo.getList()) {
            System.out.println(comments);
        }
    }

}