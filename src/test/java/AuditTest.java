import nxu.entity.Audit;
import nxu.service.AuditService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 常嘉祺、张宏业
 * @apiNote 审核业务单元测试
 */
public class AuditTest extends BaseTest {

    @Autowired
    private AuditService auditService;

    @Test
    public void test1() {
        // 测试获取审核记录列表
        List<Audit> auditList = auditService.getAuditListByType(3);  // 假设查询审核类型为1（配送人员）
        System.out.println(auditList);
    }

    @Test
    public void test2() {
        Audit audit = auditService.getAuditById(2);// 假设查询审核记录id为2
        System.out.println(audit);
    }

    @Test
    public void test3() {
        int rowsAffected = auditService.updateAuditState(1, 2, "新已通过配送人员资质检査，允许进行跑腿服务。");
        System.out.println(rowsAffected);
        Audit audit = auditService.getAuditById(1);// 假设查询审核记录id为2
        System.out.println(audit);
    }

    @Test
    public void test4() {
        List<Audit> auditList = auditService.getAuditListByState(1, 2);  // 假设查询审核状态查询
        for (Audit audit : auditList) {
            System.out.println(audit);
        }
    }
}