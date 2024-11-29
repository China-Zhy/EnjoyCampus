package nxu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 张宏业
 * @apiNote 地址实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {
    private int id;             // 地址编号
    private User user;          // 所属用户
    private School school;      // 所属学校
    private Campus campus;      // 所属校区
    private Building building;  // 所属建筑
    private String consignee;   // 收货人名
    private String phone;       // 收货电话
}