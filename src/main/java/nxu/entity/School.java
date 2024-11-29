package nxu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 张宏业
 * @apiNote 学校实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class School {
    private int id;             // 学校编号
    private String name;        // 学校名称
}