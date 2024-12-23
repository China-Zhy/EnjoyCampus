package nxu.dao;

import nxu.entity.Comments;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 张宏业
 * @apiNote 评论的持久层接口
 */
public interface CommentsMapper {

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
    int delete(@Param("id") int id);

    /**
     * 查询评论
     *
     * @param map 查询参数 meals、user、pageNum、pageSize等
     * @return 评论集合
     */
    List<Comments> selectComments(Map<String, Object> map);

    /**
     * 更改评论状态
     *
     * @param id    评论编号
     * @param state 评论状态
     * @return 更改结果
     */
    int updateComments(@Param("id") int id, @Param("state") int state);
}