package nxu.service;

import nxu.entity.Address;

import java.util.List;

/**
 * @author 张宏业
 * @apiNote 地址服务层接口
 */
public interface AddressService {
    /**
     * 添加地址
     *
     * @param address 地址实体类
     * @return 插入结果：0-失败，1-成功
     */
    int insert(Address address);

    /**
     * 修改地址
     *
     * @param address 地址实体类
     * @return 修改结果：0-失败，1-成功
     */
    int update(Address address);

    /**
     * 删除地址
     *
     * @param id 地址编号
     * @return 删除结果：0-失败，1-成功
     */
    int delete(int id);

    /**
     * 查询某个地址
     *
     * @param id 地址编号
     * @return 地址实体类
     */
    Address selectById(int id);

    /**
     * 查询某个用户的地址
     *
     * @param userId 用户编号
     * @return 地址实体类集合
     */
    List<Address> selectByUser(int userId);
}