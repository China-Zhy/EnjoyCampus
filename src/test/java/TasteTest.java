import nxu.entity.Taste;
import nxu.service.TasteService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 张宏业
 * @apiNote 餐品口味单元测试
 */
public class TasteTest extends BaseTest {

    @Autowired
    private TasteService tasteService;

    @Test
    public void test1() {
        int i = tasteService.insertTaste("新口味");
        System.out.println(i);
    }

    @Test
    public void test2() {
        int i = tasteService.updateTaste(6, "旧口味");
        System.out.println(i);
    }

    @Test
    public void test3() {
        int i = tasteService.deleteTaste(6);
        System.out.println(i);
    }

    @Test
    public void test4() {
        List<Taste> tastes = tasteService.selectAllTaste();
        for (Taste taste : tastes) {
            System.out.println(taste);
        }
    }
}