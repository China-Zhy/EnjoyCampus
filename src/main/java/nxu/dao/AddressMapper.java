package nxu.dao;

import nxu.entity.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 张宏业
 * @apiNote 地址持久层接口
 */
public interface AddressMapper {

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
    int delete(@Param("id") int id);

    /**
     * 查询某个地址
     *
     * @param id 地址编号
     * @return 地址实体类
     */
    Address selectById(@Param("id") int id);

    /**
     * 查询某个用户的地址
     *
     * @param entity 实体编号
     * @return 地址实体类集合
     */
    List<Address> selectByEntity(@Param("entity") int entity);
}