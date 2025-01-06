package nxu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

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
    private LocalDateTime when; // 发送时间
    private int state;          // 是否已读(0-未读，1-已读)
}