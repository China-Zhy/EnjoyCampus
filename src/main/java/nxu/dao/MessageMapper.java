package nxu.dao;

import nxu.entity.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 张宏业
 * @apiNote 消息持久层接口
 */
public interface MessageMapper {

    /**
     * 添加消息
     *
     * @param record 消息实体
     * @return 添加结果
     */
    int insertMessage(Message record);

    /**
     * 查询消息
     *
     * @param send    发送用户
     * @param receive 接收用户
     * @return 消息集合
     */
    List<Message> selectMessage(@Param("send") int send, @Param("receive") int receive);
}