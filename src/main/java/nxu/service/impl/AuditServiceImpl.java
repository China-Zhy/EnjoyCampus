package nxu.service.impl;

import nxu.dao.AuditMapper;
import nxu.entity.Audit;
import nxu.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author 常嘉祺、张宏业
 * @apiNote 审核服务层实现类
 */
@Service
public class AuditServiceImpl implements AuditService {

    @Autowired
    private AuditMapper auditMapper;

    /**
     * 根据审核类型查找审核记录
     *
     * @param type 审核类型
     * @return 返回该类型的所有审核记录
     */
    @Override
    public List<Audit> getAuditListByType(int type) {
        return auditMapper.getAuditListByType(type);
    }

    /**
     * 根据审核状态查找审核记录
     *
     * @param type  审核类型
     * @param state 审核状态
     * @return 返回该类型的所有审核记录
     */
    @Override
    public List<Audit> getAuditListByState(int type, int state) {
        return auditMapper.getAuditListByState(type, state);
    }

    /**
     * 根据审核ID获取审核详情
     *
     * @param id 审核ID
     * @return 审核实体
     */
    @Override
    public Audit getAuditById(int id) {
        return auditMapper.getAuditById(id);
    }

    /**
     * 更改审核状态
     *
     * @param id    审核ID
     * @param state 审核状态
     * @param info  描述信息
     * @return 更新的记录数
     */
    @Override
    public int updateAuditState(int id, int state, String info) {
        return auditMapper.updateAuditState(id, state, info);
    }
}