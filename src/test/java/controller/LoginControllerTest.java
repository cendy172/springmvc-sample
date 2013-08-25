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
public class LoginControllerTest
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
	public void shouldGetLoginPageWhenLogin() throws Exception
	{
		requestBuilder = MockMvcRequestBuilders.get("/login");
		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(
				MockMvcResultMatchers.view().name("login"));
	}

	@Test
	public void shouldGetSuccessPageWhenAuthenticRight() throws Exception
	{
		requestBuilder = MockMvcRequestBuilders.post("/login").param("username", "user1").param("password", "user1");
		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(
				MockMvcResultMatchers.view().name("success"));
	}

	@Test
	public void shouldStayThisPageWhenAuthenticIncorrect() throws Exception
	{
		requestBuilder = MockMvcRequestBuilders.post("/login").param("username", "fake_username").param("password",
				"fake_password");
		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(
				MockMvcResultMatchers.view().name("login")).andExpect(
				MockMvcResultMatchers.model().attribute("errorMessage", "username or password is not correct"));
	}

	@Test
	public void shouldGetHomeWhenHome() throws Exception
	{
		requestBuilder = MockMvcRequestBuilders.get("/home").param("username", "fake_username");
		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(
				MockMvcResultMatchers.view().name("home")).andExpect(
				MockMvcResultMatchers.model().attribute("username", "fake_username"));
	}
}
