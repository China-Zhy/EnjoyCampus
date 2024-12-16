package nxu.service.impl;

import nxu.dao.IdentityMapper;
import nxu.entity.Identity;
import nxu.service.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张宏业
 * @apiNote 身份类型服务层实现类
 */
@Service
public class IdentityServiceImpl implements IdentityService {

    @Autowired
    private IdentityMapper identityMapper;

    /**
     * 查询全部身份类型
     *
     * @return 身份类型实体类集合
     */
    @Override
    public List<Identity> selectAll() {
        return identityMapper.selectAll();
    }
}