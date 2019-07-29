import com.spring.db.JdbcConfig;
import com.spring.db.domain.User;
import com.spring.db.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //SpringJUnit4ClassRunner在 JUnit环境下提供 Spring TestContext Framework的功能。
//@ContextConfiguration用来加载配置 ApplicationContext,其中 classes属性用来加载配置类。
@ContextConfiguration(classes = {JdbcConfig.class})
public class JdbcTests {
    @Autowired
    private UserService userService;

    @Test
    public void testAddUser() throws Exception {
        User user = new User();
        user.setName("lucy");
        user.setSex("f");
        userService.addUser(user);
    }


}
