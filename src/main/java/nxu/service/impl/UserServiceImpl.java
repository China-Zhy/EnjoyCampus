package nxu.service.impl;

import nxu.dao.UserMapper;
import nxu.entity.User;
import nxu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张宏业
 * @apiNote 用户服务层实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 添加用户
     *
     * @param user 用户实体类
     * @return 插入结果：0-失败，1-成功
     */
    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    /**
     * 删除用户
     *
     * @param id 用户编号
     * @return 删除结果：0-失败，1-成功
     */
    @Override
    public int deleteUser(int id) {
        return userMapper.deleteUser(id);
    }

    /**
     * 修改用户
     *
     * @param user 用户实体类
     * @return 修改结果：0-失败，1-成功
     */
    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    /**
     * 通过ID查询用户
     *
     * @param id 用户编号
     * @return 用户实体类
     */
    @Override
    public User selectUserById(int id) {
        return userMapper.selectUserById(id);
    }

    /**
     * 通过登录查询用户
     *
     * @param phone 手机号码
     * @return 用户实体类
     */
    @Override
    public User selectUserByLogin(String phone) {
        return userMapper.selectUserByLogin(phone);
    }

    /**
     * 通过身份类型查询用户群
     *
     * @param identity 身份类型
     * @return 用户实体类集合
     */
    @Override
    public List<User> selectUserByIdentity(int identity) {
        return userMapper.selectUserByIdentity(identity);
    }
}