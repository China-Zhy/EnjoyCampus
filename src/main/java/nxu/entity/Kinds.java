package nxu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 张宏业
 * @apiNote 餐品种类实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Kinds {
    private int id;             // 种类编号
    private String name;        // 种类名称
    private String image;       // 种类图片
}