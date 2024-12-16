import nxu.entity.Identity;
import nxu.service.IdentityService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 张宏业
 * @apiNote 身份类型的单元测试
 */
public class IdentityTest extends BaseTest {

    @Autowired
    private IdentityService identityService;

    @Test
    public void test() {
        List<Identity> identities = identityService.selectAll();
        for (Identity identity : identities) {
            System.out.println(identity);
        }
    }
}