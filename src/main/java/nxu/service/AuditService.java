package nxu.service;

import nxu.entity.Audit;

import java.util.List;

/**
 * @author 常嘉祺、张宏业
 * @apiNote 审核服务层接口
 */
public interface AuditService {

    /**
     * 根据审核类型查找审核记录
     *
     * @param type 审核类型
     * @return 返回该类型的所有审核记录
     */
    List<Audit> getAuditListByType(int type);

    /**
     * 根据审核状态查找审核记录
     *
     * @param type  审核类型
     * @param state 审核状态
     * @return 返回该类型的所有审核记录
     */
    List<Audit> getAuditListByState(int type, int state);

    /**
     * 根据审核ID获取审核详情
     *
     * @param id 审核ID
     * @return 审核实体
     */
    Audit getAuditById(int id);

    /**
     * 更改审核状态
     *
     * @param id    审核ID
     * @param state 审核状态
     * @param info  描述信息
     * @return 更新的记录数
     */
    int updateAuditState(int id, int state, String info);
}