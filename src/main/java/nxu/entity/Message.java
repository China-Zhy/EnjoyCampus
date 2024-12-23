package nxu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 张宏业
 * @apiNote 消息实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Message {
    private int id;             // 消息编号
    private int send;           // 发送用户
    private int receive;        // 接收用户
    private String content;     // 消息内容
}