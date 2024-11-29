import nxu.entity.Identity;
import nxu.entity.User;
import nxu.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 张宏业
 * @apiNote 用户业务单元测试
 */
public class UserTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Test
    public void test1() {
        Identity identity = new Identity(1, null);
        User user = new User(0, "测试用户", "18812345678", "nxu123", "/image/18812345678.png", 1, null, "测试的用户", identity, null);
        int i = userService.insertUser(user);
        System.out.println(i);
    }

    @Test
    public void test2() {
        Identity identity = new Identity(5, null);
        User user = new User(6, "新测试用户", "15012345678", "123nxu", "/image/15012345678.png", 2, null, "新测试的用户", identity, null);
        int i = userService.updateUser(user);
        System.out.println(i);
    }

    @Test
    public void test3() {
        User user1 = userService.selectUserById(6);
        System.out.println("通过ID查询1：" + user1);
        User user2 = userService.selectUserById(0);
        System.out.println("通过ID查询2：" + user2);
    }

    @Test
    public void test4() {
        User user1 = userService.selectUserByLogin("15012345678");
        System.out.println("通过登录查询1：" + user1);
        User user2 = userService.selectUserByLogin("18812345678");
        System.out.println("通过登录查询2：" + user2);
    }

    @Test
    public void test5() {
        List<User> users = userService.selectUserByIdentity(5);
        for (User user : users) {
            System.out.println(user);
        }
    }
}