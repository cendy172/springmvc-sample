package service;


import bean.LoginCommand;

public class LoginService
{
	private LoginCommand user1;
	private LoginCommand user2;
	private LoginCommand user3;

	public LoginService()
	{
		user1 = new LoginCommand();
		user2 = new LoginCommand();
		user3 = new LoginCommand();
		user1.setUsername("user1");
		user1.setPassword("user1");
		user2.setUsername("user2");
		user2.setPassword("user2");
		user3.setUsername("user3");
		user3.setPassword("user3");
	}

	public boolean isValidUser(LoginCommand loginCommand)
	{
		return user1.isSameLoginCommand(loginCommand) || user2.isSameLoginCommand(loginCommand)
				|| user3.isSameLoginCommand(loginCommand) ? true : false;
	}
}
