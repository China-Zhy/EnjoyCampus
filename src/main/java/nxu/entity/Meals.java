package nxu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 张宏业
 * @apiNote 餐品实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Meals {
    private int id;                 // 餐品编号
    private String name;            // 餐品名称
    private double price;           // 餐品价格
    private String materials;       // 餐品原料
    private String flavors;         // 风味类型
    private String image;           // 餐品图片
    private int heft;               // 餐品份量
    private String detail;          // 详情信息
    private int type;               // 餐品种类
    private Address address;        // 地址信息
}