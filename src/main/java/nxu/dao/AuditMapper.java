package nxu.dao;

import nxu.entity.Audit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 常嘉祺
 * @apiNote 审核持久层接口
 */
public interface AuditMapper {
    /**
     * 根据审核类型查找审核记录
     *
     * @param type 审核类型
     * @return 返回该类型的所有审核记录
     */
    List<Audit> getAuditListByType(@Param("type") int type);
    /**
     * 根据审核状态查找审核记录
     *
     * @param state 审核状态
     * @return 返回该类型的所有审核记录
     */
    List<Audit> getAuditListByState(@Param("state") int state);
    /**
     * 根据审核ID获取审核详情
     *
     * @param id 审核ID
     * @return 审核实体
     */
    Audit getAuditById(@Param("id") int id);

    /**
     *更改审核状态
     *
     * @param id 审核ID
     * @param state 审核状态
     * @param info 描述信息
     * @return 更新的记录数
     */
    int updateAuditState(@Param("id") int id, @Param("state") int state, @Param("info") String info);
}
