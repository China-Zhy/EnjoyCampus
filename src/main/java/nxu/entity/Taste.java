package nxu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 张宏业
 * @apiNote 口味实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Taste {
    private int id;             // 口味编号
    private String name;        // 口味名称
}