package nxu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author 张宏业
 * @apiNote 评价实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Comments {
    private int id;                 // 评论编号
    private int user;               // 评论用户
    private int meals;              // 餐品编号
    private int rate;               // 评价星级
    private String info;            // 评价内容
    private String image;           // 评价图片
    private Date date;              // 评价时间
}