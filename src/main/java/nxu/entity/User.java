package nxu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * @author 张宏业
 * @apiNote 用户实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private int id;             // 用户编号
    private String name;        // 用户昵称
    private String phone;       // 手机号码
    private String password;    // 用户密码
    private String avatar;      // 头像路径
    private int gender;         // 用户性别(1-男，2-女)
    private Date register;      // 注册日期
    private String other;       // 其他信息
    private Identity identity;  // 身份类型
    private List<Address> addresses;    // 地址信息
}