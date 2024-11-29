package nxu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 张宏业
 * @apiNote 建筑实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Building {
    private int id;             // 建筑编号
    private String name;        // 建筑名称
    private int campusId;       // 所属校区
}