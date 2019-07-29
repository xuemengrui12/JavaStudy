import com.spring.senior.fortest.TestBean;
import com.spring.senior.fortest.TestConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //SpringJUnit4ClassRunner在 JUnit环境下提供 Spring TestContext Framework的功能。
//@ContextConfiguration用来加载配置 ApplicationContext,其中 classes属性用来加载配置类。
@ContextConfiguration(classes = {TestConfig.class})
@ActiveProfiles("prod") //声明活动的profile
public class DemoBeanIntegrationTests {
	@Autowired
	private TestBean testBean;

	@Test
	public void prodBeanShouldInject(){
		String expected = "from production profile";
		String actual = testBean.getContent();
		Assert.assertEquals(expected, actual);
	}

	
}
