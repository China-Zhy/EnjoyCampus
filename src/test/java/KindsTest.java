import nxu.entity.Kinds;
import nxu.service.KindsService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 张宏业
 * @apiNote
 */
public class KindsTest extends BaseTest {

    @Autowired
    private KindsService kindsService;


    @Test
    public void test1() {
        int insert = kindsService.insertKinds("测试餐品种类", "../../static/kinds/kind1.png");
        System.out.println(insert);
    }

    @Test
    public void test2() {
        int delete = kindsService.deleteKinds(10);
        System.out.println(delete);
    }

    @Test
    public void test3() {
        int update = kindsService.updateKinds(new Kinds(10, "新测试餐品种类", "../../static/kinds/kind2.png"));
        System.out.println(update);
    }

    @Test
    public void test4() {
        List<Kinds> kinds = kindsService.selectAllKinds();
        for (Kinds kind : kinds) {
            System.out.println(kind);
        }
    }
}