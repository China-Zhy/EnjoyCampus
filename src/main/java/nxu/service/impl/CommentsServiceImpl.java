package nxu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import nxu.dao.CommentsMapper;
import nxu.entity.Comments;
import nxu.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 张宏业
 * @apiNote 评论服务层实现类
 */
@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentsMapper commentsMapper;

    /**
     * 插入评论
     *
     * @param comments 评论实体类
     * @return 插入结果 1-插入成功，0-插入失败
     */
    @Override
    public int insert(Comments comments) {
        return commentsMapper.insert(comments);
    }

    /**
     * 删除评论
     *
     * @param id 评论编号
     * @return 删除结果 1-删除成功，0-删除失败
     */
    @Override
    public int delete(int id) {
        return commentsMapper.delete(id);
    }

    /**
     * 查询评论
     *
     * @param map 查询参数 meals、user、pageNum、pageSize等
     * @return 评论集合
     */
    @Override
    public PageInfo<Comments> selectComments(Map<String, Object> map) {
        if (map.containsKey("pageNum") && map.containsKey("pageSize")) {
            // 开启分页查询，设置页码和每页数据量
            PageHelper.startPage((int) map.get("pageNum"), (int) map.get("pageSize"));
            List<Comments> comments = commentsMapper.selectComments(map);
            return new PageInfo<>(comments);    // 分页查询结果，里面包含总页数，当前第几页等
        } else {
            return new PageInfo<>(commentsMapper.selectComments(map));    // 不分页查询
        }
    }
}