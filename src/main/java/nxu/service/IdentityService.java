package nxu.service;

import nxu.entity.Identity;

import java.util.List;

/**
 * @author 张宏业
 * @apiNote 身份类型服务层接口
 */
public interface IdentityService {

    /**
     * 查询全部身份类型
     *
     * @return 身份类型实体类集合
     */
    List<Identity> selectAll();
}