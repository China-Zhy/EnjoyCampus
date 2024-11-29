package nxu.dao;

import nxu.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 张宏业
 * @apiNote 用户持久层接口
 */
public interface UserMapper {

    /**
     * 添加用户
     *
     * @param user 用户实体类
     * @return 插入结果：0-失败，1-成功
     */
    int insertUser(User user);

    /**
     * 删除用户
     *
     * @param id 用户编号
     * @return 删除结果：0-失败，1-成功
     */
    int deleteUser(@Param("id") int id);

    /**
     * 修改用户
     *
     * @param user 用户实体类
     * @return 修改结果：0-失败，1-成功
     */
    int updateUser(User user);

    /**
     * 通过ID查询用户
     *
     * @param id 用户编号
     * @return 用户实体类
     */
    User selectUserById(int id);

    /**
     * 通过登录查询用户
     *
     * @param phone 手机号码
     * @return 用户实体类
     */
    User selectUserByLogin(@Param("phone") String phone);

    /**
     * 通过身份类型查询用户群
     *
     * @param identity 身份类型
     * @return 用户实体类集合
     */
    List<User> selectUserByIdentity(@Param("identity") int identity);
}