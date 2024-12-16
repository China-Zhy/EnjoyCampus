package nxu.dao;

import nxu.entity.Identity;

import java.util.List;

/**
 * @author 张宏业
 * @apiNote 身份类型持久层接口
 */
public interface IdentityMapper {

    /**
     * 查询全部身份类型
     *
     * @return 身份类型实体类集合
     */
    List<Identity> selectAll();
}