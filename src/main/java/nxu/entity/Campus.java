package nxu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 张宏业
 * @apiNote 校区实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Campus {
    private int id;             // 校区编号
    private String name;        // 校区名称
    private String schoolId;    // 所属学校
}