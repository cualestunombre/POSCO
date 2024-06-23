package ex01.filter;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import javax.servlet.Filter;
import ex01.config.AppConfig;
import ex01.config.WebConfig;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;


// 스프링빈을 주입받을 수 있는 설정
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfig.class, WebConfig.class})
@WebAppConfiguration // 필터 설정을 비롯해서 전체적인 서블릿을 대상으로 web test를 수행할 수 있게 한다
public class MyFilterTest {
	private MockMvc mvc;
	
	@BeforeEach
	public void setup(ApplicationContext applicationContext) {
		Filter myFilter = (Filter) applicationContext.getBean("myFilter");
		mvc = MockMvcBuilders
				.webAppContextSetup((WebApplicationContext) applicationContext)
				.addFilter(new DelegatingFilterProxy(myFilter), "/*")
				.build();
	}
	
	@Test
	public void hello() throws Exception {
		mvc.
			perform(get("/hello"))
			.andExpect(status().isOk())
			.andExpect(cookie().value("MyFilter", "Works"))
			.andDo(print());
	}
	
}
