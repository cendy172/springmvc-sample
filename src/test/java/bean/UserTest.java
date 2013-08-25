package bean;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class UserTest
{

	private LoginCommand user;
	private LoginCommand user1;

	@Before
	public void setUp()
	{
		user = new LoginCommand();
		user1 = new LoginCommand();
		user.setUsername("user");
		user.setPassword("password");
	}

	@Test
	public void shouldGetName()
	{
		user.setUsername("name");
		assertThat(user.getUsername(), is("name"));
	}

	@Test
	public void shouldGetPassword()
	{
		user.setPassword("password");
		assertThat(user.getPassword(), is("password"));
	}

	@Test
	public void shouldReturnTrueWhenNameAndPasswordIsSame()
	{
		assertUserValid("user", "password", true);
	}

	@Test
	public void shouldReturnFalseWhenNameAndPasswordIsNotSame()
	{
		assertUserValid("fake_name", "fake_password", false);
	}

	private void assertUserValid(String name, String password, boolean same)
	{
		user1.setUsername(name);
		user1.setPassword(password);
		assertThat(user.isSameLoginCommand(user1), is(same));
	}
}
