package nxu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 张宏业
 * @apiNote 身份实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Identity {
    private int id;             // 类型编号
    private String name;        // 身份类型
}