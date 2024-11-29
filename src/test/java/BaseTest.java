import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 张宏业
 * @apiNote 测试类父类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class BaseTest {
    //@RunWith是JUnit的一个注解, 用来告诉JUnit不要使用内置的方式进行单元测试, 而应该使用指定的类做单元测试
    //对于Spring单元测试总是要使用SpringJUnit4ClassRunner.class这个类
    //@ContextConfiguration注解用来告诉junit，spring的配置文件，参数是个String数组，允许多个值
}