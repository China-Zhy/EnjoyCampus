package nxu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author 张宏业
 * @apiNote 点餐订单实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MealsOrder {
    private int id;                     // 订单编号
    private int user;                   // 用户编号
    private int errands;                // 配送人员
    private String checkList;           // 商品信息(商品编号-购买数量，...)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;    // 下单时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;      // 签收时间
    private int state;                  // 配送状态(1-未支付，2-已支付，3-商家已接单，4-骑手已结单，5-骑手配送中，6-餐品已送达，7-其他状况)
    private String remarks;             // 订单备注
    private int address;                // 订单地址(0-不配送，非0-地址编号)
    private double price;               // 订单价格
}