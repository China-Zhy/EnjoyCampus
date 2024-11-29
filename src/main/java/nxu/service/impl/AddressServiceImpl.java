package nxu.service.impl;

import nxu.dao.AddressMapper;
import nxu.entity.Address;
import nxu.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张宏业
 * @apiNote 地址服务层实现类
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    /**
     * 添加地址
     *
     * @param address 地址实体类
     * @return 插入结果：0-失败，1-成功
     */
    @Override
    public int insert(Address address) {
        return addressMapper.insert(address);
    }

    /**
     * 修改地址
     *
     * @param address 地址实体类
     * @return 修改结果：0-失败，1-成功
     */
    @Override
    public int update(Address address) {
        return addressMapper.update(address);
    }

    /**
     * 删除地址
     *
     * @param id 地址编号
     * @return 删除结果：0-失败，1-成功
     */
    @Override
    public int delete(int id) {
        return addressMapper.delete(id);
    }

    /**
     * 查询某个地址
     *
     * @param id 地址编号
     * @return 地址实体类
     */
    @Override
    public Address selectById(int id) {
        return addressMapper.selectById(id);
    }

    /**
     * 查询某个用户的地址
     *
     * @param userId 用户编号
     * @return 地址实体类集合
     */
    @Override
    public List<Address> selectByUser(int userId) {
        return addressMapper.selectByUser(userId);
    }
}