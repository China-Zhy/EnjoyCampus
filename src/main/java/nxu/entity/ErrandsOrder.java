package nxu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;    // 下单时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;      // 签收时间
    private int state;                  // 跑腿状态(1-跑腿服务寻找中，2-跑腿服务进行中，3-跑腿服务已完成，4-其他状况)
    private String remarks;             // 订单备注
    private double price;               // 订单价格
}