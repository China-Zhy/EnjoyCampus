import nxu.entity.Address;
import nxu.entity.Building;
import nxu.entity.Campus;
import nxu.entity.School;
import nxu.service.AddressService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 张宏业
 * @apiNote 地址业务单元测试
 */
public class AddressTest extends BaseTest {

    @Autowired
    private AddressService addressService;

    @Test
    public void test1() {
        Address address = new Address();
        address.setEntity(5);
        address.setSchool(new School(1, ""));
        address.setCampus(new Campus(1, "", 1));
        address.setBuilding(new Building(1, "", 1));
        address.setDetail("测试地址");
        address.setConsignee("奥特曼");
        address.setPhone("18812345678");
        address.setType(1);
        int insert = addressService.insert(address);
        System.out.println(insert);
    }

    @Test
    public void test2() {
        int delete = addressService.delete(3);
        System.out.println(delete);
    }

    @Test
    public void test3() {
        Address address = new Address();
        address.setId(4);
        address.setEntity(4);
        address.setSchool(new School(2, ""));
        address.setCampus(new Campus(5, "", 2));
        address.setBuilding(new Building(30, "", 5));
        address.setDetail("新测试地址");
        address.setConsignee("小怪兽");
        address.setPhone("15512345678");
        address.setType(2);
        int update = addressService.update(address);
        System.out.println(update);
    }

    @Test
    public void test4() {
        Address address = addressService.selectById(4);
        System.out.println(address);
    }

    @Test
    public void test5() {
        List<Address> addresses = addressService.selectByEntity(5);
        for (Address address : addresses) {
            System.out.println(address);
        }
    }
}