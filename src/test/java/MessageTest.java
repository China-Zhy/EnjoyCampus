import nxu.entity.Message;
import nxu.service.MessageService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 张宏业
 * @apiNote 消息的单元测试
 */
public class MessageTest extends BaseTest {

    @Autowired
    private MessageService messageService;

    @Test
    public void test1() {
        int i = messageService.insertMessage(new Message(0, 1, 5, "今天你努力了吗？", null, 0));
        System.out.println(i);
    }

    @Test
    public void test2() {
        List<Message> messages = messageService.selectMessage(1, 5);
        for (Message message : messages) {
            System.out.println(message);
        }
    }

    @Test
    public void test3() {
        int i = messageService.updateMessage(1, 5);
        System.out.println(i);
    }

}