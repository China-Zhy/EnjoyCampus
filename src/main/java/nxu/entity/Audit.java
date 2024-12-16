package nxu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 张宏业
 * @apiNote 审核实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Audit {
    private int id;                 // 审核编号
    private int type;               // 审核类型(1-配送人员，2-餐厅人员，3-餐厅餐品)
    private int entity;             // 被审核的实体编号
    private int state;              // 审核状态(1-未审核，2-审核通过，3-审核未通过)
    private String info;            // 其他描述信息
}