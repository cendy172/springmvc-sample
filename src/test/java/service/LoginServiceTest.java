package service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

import bean.LoginCommand;

public class LoginServiceTest
{
	private LoginService loginService;
	private LoginCommand loginCommand;

	@Before
	public void setUp()
	{
		loginService = new LoginService();
		loginCommand = new LoginCommand();
	}

	@Test
	public void shouldReturnTrueWhenUserIsValid()
	{
		assertUserValid("user1", "user1", true);
	}

	@Test
	public void shouldReturnFalseWhenUserIsNotValid()
	{
		assertUserValid("fake_name", "fake_password", false);
	}

	private void assertUserValid(String name, String password, boolean same)
	{
		loginCommand.setUsername(name);
		loginCommand.setPassword(password);
		boolean validUser = loginService.isValidUser(loginCommand);
		assertThat(validUser, is(same));
	}
}
