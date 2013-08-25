package bean;

public class LoginCommand
{
    private String username;
    private String password;

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public boolean isSameLoginCommand(LoginCommand loginCommand)
    {
        return loginCommand.getUsername().equals(username) && loginCommand.getPassword().equals(password) ? true : false;
    }
}
