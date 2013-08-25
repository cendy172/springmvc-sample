package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.LoginService;
import bean.LoginCommand;

@Controller
public class LoginController
{
	LoginService loginService = new LoginService();

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView index()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("loginCommand") LoginCommand loginCommand)
	{
		ModelAndView modelAndView = new ModelAndView();
 		if (loginService.isValidUser(loginCommand))
		{
			modelAndView.addObject("username", loginCommand.getUsername());
			modelAndView.setViewName("success");
			modelAndView.addObject("home", "home?username=" + loginCommand.getUsername());
		} else
		{
			modelAndView.addObject("errorMessage", "username or password is not correct");
			modelAndView.setViewName("login");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView toHome(@RequestParam("username") String username)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("username", username);
		modelAndView.setViewName("home");
		return modelAndView;
	}
}
