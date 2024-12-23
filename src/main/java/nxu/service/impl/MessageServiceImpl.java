package nxu.service.impl;

import nxu.dao.MessageMapper;
import nxu.entity.Message;
import nxu.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张宏业
 * @apiNote 消息服务层实现类
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    /**
     * 添加消息
     *
     * @param record 消息实体
     * @return 添加结果
     */
    @Override
    public int insertMessage(Message record) {
        return messageMapper.insertMessage(record);
    }

    /**
     * 查询消息
     *
     * @param send    发送用户
     * @param receive 接收用户
     * @return 消息集合
     */
    @Override
    public List<Message> selectMessage(int send, int receive) {
        return messageMapper.selectMessage(send, receive);
    }
}