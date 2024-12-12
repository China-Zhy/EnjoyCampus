package nxu.service;

import com.github.pagehelper.PageInfo;
import nxu.entity.Comments;

import java.util.Map;

/**
 * @author 张宏业
 * @apiNote 评论服务层接口
 */
public interface CommentsService {

    /**
     * 插入评论
     *
     * @param comments 评论实体类
     * @return 插入结果 1-插入成功，0-插入失败
     */
    int insert(Comments comments);

    /**
     * 删除评论
     *
     * @param id 评论编号
     * @return 删除结果 1-删除成功，0-删除失败
     */
    int delete(int id);

    /**
     * 查询评论
     *
     * @param map 查询参数 meals、user、pageNum、pageSize等
     * @return 评论集合
     */
    PageInfo<Comments> selectComments(Map<String, Object> map);
}