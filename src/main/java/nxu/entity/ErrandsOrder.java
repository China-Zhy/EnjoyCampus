package nxu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author 张宏业
 * @apiNote 跑腿订单实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ErrandsOrder {
    private int id;                     // 订单编号
    private int user;                   // 用户编号
    private int errands;                // 配送人员
    private String voucher;             // 凭证图片名称
    private String checkList;           // 商品信息(商品编号-购买数量，...)
    private LocalDateTime startTime;    // 下单时间
    private LocalDateTime endTime;      // 签收时间
    private int state;                  // 配送状态(1-配送中，2-已送达，3-其他状况)
    private String remarks;             // 订单备注
}