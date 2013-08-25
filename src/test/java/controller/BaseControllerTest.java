package controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
{ "file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml" })
public class BaseControllerTest
{

	@Autowired
	WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;
	private RequestBuilder requestBuilder;

	@Before
	public void setUp()
	{
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}

	@Test
	public void shouldReturnIndexPageWhenDefault() throws Exception
	{
		requestBuilder = MockMvcRequestBuilders.get("/");
		this.mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(
				MockMvcResultMatchers.view().name("index"));
	}
}
